package server.mappers;

import server.DTOs.ConversationDTO;
import server.PerRequestIdStorage;
import server.models.ChatMessage;
import server.models.ChatUser;
import server.models.Conversation;

import java.util.Collections;
import java.util.List;

public class ConversationMapper {

    public static ConversationDTO conversationToConversationDTO(Conversation conversation) {
        return new ConversationDTO(conversation.getId(), conversation.getDateCreated(),
                getOtherParticipantName(conversation.getParticipants()), getLastMessage(conversation.getMessages()));
    }

    private static String getOtherParticipantName(List<ChatUser> users) {
        String participantName = "";
        for(ChatUser user : users) {
            if(!user.getId().equals(PerRequestIdStorage.getUserId())) participantName = user.getFirstName() + " " + user.getLastName();
        }
        return participantName;
    }

    private static String getLastMessage(List<ChatMessage> messages) {
        if (messages == null || messages.size() == 0) {
            return "No messages yet";
        } else {
            Collections.sort(messages);
            return messages.get(0).getContent();
        }
    }
}
