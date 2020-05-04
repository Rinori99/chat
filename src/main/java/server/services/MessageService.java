package server.services;

import server.DTOs.ChatMessageDTO;

import java.sql.Timestamp;
import java.util.List;

public interface MessageService {

    void saveMessage(String senderId, String conversationId, String content, Timestamp timeStamp);

    List<ChatMessageDTO> getMessagesByConversationId(String conversationId);

}
