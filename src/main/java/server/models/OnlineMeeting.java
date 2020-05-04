package server.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "online_meeting")
public class OnlineMeeting {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "startTime")
    private Timestamp startTime;

    @Column(name = "endTime")
    private Timestamp endTime;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by")
    private ChatUser createdBy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invited_participant")
    private ChatUser invitedParticipant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "message_start_id")
    private ChatMessage messageStartId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "message_end_id")
    private ChatMessage messageEndId;

    public OnlineMeeting() { }

    public OnlineMeeting(String id, String title, Timestamp startTime, Timestamp endTime, String description, ChatUser createdBy, ChatUser invitedParticipant) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.createdBy = createdBy;
        this.invitedParticipant = invitedParticipant;
    }

    public OnlineMeeting(String id, String title, Timestamp startTime, Timestamp endTime, String description, ChatUser createdBy, ChatUser invitedParticipant, ChatMessage messageStartId, ChatMessage messageEndId) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.createdBy = createdBy;
        this.invitedParticipant = invitedParticipant;
        this.messageStartId = messageStartId;
        this.messageEndId = messageEndId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ChatUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(ChatUser createdBy) {
        this.createdBy = createdBy;
    }

    public ChatUser getInvitedParticipant() {
        return invitedParticipant;
    }

    public void setInvitedParticipant(ChatUser invitedParticipant) {
        this.invitedParticipant = invitedParticipant;
    }

    public ChatMessage getMessageStartId() {
        return messageStartId;
    }

    public void setMessageStartId(ChatMessage messageStartId) {
        this.messageStartId = messageStartId;
    }

    public ChatMessage getMessageEndId() {
        return messageEndId;
    }

    public void setMessageEndId(ChatMessage messageEndId) {
        this.messageEndId = messageEndId;
    }

}
