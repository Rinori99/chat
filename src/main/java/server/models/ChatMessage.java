package server.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "chat_message")
public class ChatMessage {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id")
    private ChatUser senderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conversation_id")
    private Conversation conversationId;

    @Column(name = "content")
    private String content;

    @Column(name = "time_sent")
    private Timestamp timeSent;

    public ChatMessage() {}

    public ChatMessage(String id, ChatUser senderId, Conversation conversationId, String content) {
        this.id = id;
        this.senderId = senderId;
        this.conversationId = conversationId;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChatUser getSenderId() {
        return senderId;
    }

    public void setSenderId(ChatUser senderId) {
        this.senderId = senderId;
    }

    public Conversation getConversationId() {
        return conversationId;
    }

    public void setConversationId(Conversation conversationId) {
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
