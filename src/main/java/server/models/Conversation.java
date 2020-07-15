package server.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conversationId")
    private List<ChatMessage> messages;

    @ManyToMany(mappedBy = "conversations")
    private List<ChatUser> participants;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conversationId")
//    private List<OnlineMeeting> onlineMeetings;

    public Conversation() {}

    public Conversation(String id) {
        this.id = id;
    }

    public Conversation(String id, Date dateCreated) {
        this.id = id;
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public List<ChatUser> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ChatUser> participants) {
        this.participants = participants;
    }

//    public List<OnlineMeeting> getOnlineMeetings() {
//        return onlineMeetings;
//    }
//
//    public void setOnlineMeetings(List<OnlineMeeting> onlineMeetings) {
//        this.onlineMeetings = onlineMeetings;
//    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Conversation) {
            return this.getId().equals(((Conversation)obj).getId());
        }
        return false;
    }

}
