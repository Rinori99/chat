package server.services;

import org.springframework.stereotype.Service;
import server.DTOs.ConversationDTO;
import server.mappers.ConversationMapper;
import server.models.ChatUser;
import server.models.Conversation;
import server.repositories.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public ChatUser getUserById(String userId) {
        return userRepo.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found!"));
    }

    @Override
    public List<ConversationDTO> getConversationsByUserId(String userId) {
        ChatUser chatUser = getUserById(userId);
        List<Conversation> conversationList = chatUser.getConversations();
        List<ConversationDTO> conversationDTOList = new ArrayList<>();
        for(Conversation conversation : conversationList) {
            conversationDTOList.add(ConversationMapper.conversationToConversationDTO(conversation));
        }
        return conversationDTOList;
    }

    @Override
    public void saveUser(String id, String firstName, String lastName, String role) {
        userRepo.save(new ChatUser(id, firstName, lastName, role));
    }

}
