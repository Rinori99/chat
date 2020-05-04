package server.DTOs;

import java.sql.Timestamp;

public class ChatMessageDTO {

    private String senderId;
    private String conversationId;
    private String content;
    private Timestamp timeSent;

    public ChatMessageDTO() {}

    public ChatMessageDTO(String senderId, String conversationId, String content) {
        this.senderId = senderId;
        this.conversationId = conversationId;
        this.content = content;
    }

    public ChatMessageDTO(String senderId, String conversationId, String content, Timestamp timeSent) {
        this.senderId = senderId;
        this.conversationId = conversationId;
        this.content = content;
        this.timeSent = timeSent;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Timestamp timeSent) {
        this.timeSent = timeSent;
    }

}
