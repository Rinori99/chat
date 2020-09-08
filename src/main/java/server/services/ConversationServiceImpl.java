package server.services;

import org.springframework.stereotype.Service;
import server.DTOs.ChatUserDTO;
import server.DTOs.ConversationDTO;
import server.PerRequestIdStorage;
import server.mappers.ConversationMapper;
import server.mappers.UserMapper;
import server.models.ChatUser;
import server.models.Conversation;
import server.repositories.ConversationRepo;
import server.repositories.UserRepo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class ConversationServiceImpl implements ConversationService {

    private ConversationRepo conversationRepo;
    private UserService userService;
    private UserRepo userRepo;
    private Supplier<UUID> uuidSupplier = UUID::randomUUID;

    public ConversationServiceImpl(ConversationRepo conversationRepo, UserService userService, UserRepo userRepo) {
        this.conversationRepo = conversationRepo;
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @Override
    public Conversation getConversationById(String conversationId) {
        return conversationRepo.findById(conversationId).orElseThrow(() -> new NoSuchElementException("Conversation not found!"));
    }

    @Override
    public void saveUserToConversation(String userId, String conversationId) {
        conversationRepo.saveUserToConversation(UUID.randomUUID().toString(), userId, conversationId);
    }

    @Override
    public List<ChatUserDTO> getUsersByConversationId(String conversationId) {
        List<ChatUser> chatUserList = conversationRepo.findById(conversationId)
                .orElseThrow(() -> new NoSuchElementException("Conversation not found")).getParticipants();
        List<ChatUserDTO> chatUserDTOList = new ArrayList<>();
        for(ChatUser chatUser : chatUserList) {
            chatUserDTOList.add(UserMapper.chatUserToChatUserDTO(chatUser));
        }
        return chatUserDTOList;
    }

    @Override
    public ConversationDTO createConversation(String email) {
        ChatUser invitedParticipant = userService.getUserByEmail(email);
        if (invitedParticipant == null) {
            throw new RuntimeException("User not found!");
        }
        ChatUser conversationCreator = userService.getUserById(PerRequestIdStorage.getUserId());
        Conversation conversation = new Conversation(getUUID(), new Date(System.currentTimeMillis()));
        Conversation savedConversation = conversationRepo.save(conversation);
        conversationCreator.getConversations().add(savedConversation);
        userRepo.save(conversationCreator);
        invitedParticipant.getConversations().add(savedConversation);
        userRepo.save(invitedParticipant);

        List<ChatUser> participants = new ArrayList<>();
        participants.add(conversationCreator);
        participants.add(invitedParticipant);
        savedConversation.setParticipants(participants);
        return ConversationMapper.conversationToConversationDTO(savedConversation);
    }

    private String getUUID() {
        return uuidSupplier.get().toString();
    }

}
