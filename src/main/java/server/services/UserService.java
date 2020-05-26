package server.services;

import server.DTOs.ConversationDTO;
import server.models.ChatUser;

import java.util.List;

public interface UserService {

    ChatUser getUserById(String userId);

    List<ConversationDTO> getConversationsByUserId(String userId);

    void saveUser(String id, String firstName, String lastName, String role);

}
