package server.services;

import server.DTOs.ChatMessageDTO;
import server.models.ChatMessage;

import java.sql.Timestamp;
import java.util.List;

public interface MessageService {

    ChatMessage getMessageById(String messageId);

    void saveMessage(String senderId, String conversationId, String content, Timestamp timeStamp);

    List<ChatMessageDTO> getMessagesByConversationId(String conversationId);

}
