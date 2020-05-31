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

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ConversationServiceImpl implements ConversationService {

    private ConversationRepo conversationRepo;
    private UserService userService;

    public ConversationServiceImpl(ConversationRepo conversationRepo, UserService userService) {
        this.conversationRepo = conversationRepo;
        this.userService = userService;
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
        ChatUser participant = userService.getUserByEmail(email);
        ChatUser user = userService.getUserById(PerRequestIdStorage.getUserId());
        List<ChatUser> participants = new ArrayList<>();
        participants.add(participant);
        participants.add(user);
        Conversation conversation = new Conversation(UUID.randomUUID().toString(), new Date(System.currentTimeMillis()));
        conversation.setParticipants(participants);
        return ConversationMapper.conversationToConversationDTO(conversationRepo.save(conversation));
    }

}
