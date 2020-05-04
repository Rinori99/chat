package server.mappers;

import server.DTOs.ChatMessageDTO;
import server.models.ChatMessage;

public class MessageMapper {

    public static ChatMessageDTO chatMessageToChatMessageDTO(ChatMessage chatMessage) {
        return new ChatMessageDTO(chatMessage.getSenderId().getId(), chatMessage.getConversationId().getId(), chatMessage.getContent(), chatMessage.getTimeSent());
    }

}
