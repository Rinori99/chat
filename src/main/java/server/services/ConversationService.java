package server.services;

import server.DTOs.ChatUserDTO;
import server.DTOs.ConversationDTO;
import server.models.Conversation;

import java.util.List;

public interface ConversationService {

    Conversation getConversationById(String conversationId);

    void saveUserToConversation(String userId, String conversationId);

    List<ChatUserDTO> getUsersByConversationId(String conversationId);

}
