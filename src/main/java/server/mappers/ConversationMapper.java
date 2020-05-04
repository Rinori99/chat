package server.mappers;

import server.DTOs.ConversationDTO;
import server.models.Conversation;

public class ConversationMapper {

    public static ConversationDTO conversationToConversationDTO(Conversation conversation) {
        return new ConversationDTO(conversation.getId(), conversation.getDateCreated());
    }

}
