package server.DTOs;

import java.sql.Timestamp;

public class OnlineMeetingDTO {

    private String id;
    private String title;
    private Timestamp startTime;
    private Timestamp endTime;
    private String description;
    private String createdById;
    private String invitedParticipantId;
    private String messageStartId;
    private String messageEndId;

    public OnlineMeetingDTO() { }

    public OnlineMeetingDTO(String id, String title, Timestamp startTime, Timestamp endTime, String description, String createdById, String invitedParticipantId) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.createdById = createdById;
        this.invitedParticipantId = invitedParticipantId;
    }

    public OnlineMeetingDTO(String id, String title, Timestamp startTime, Timestamp endTime, String description, String createdById, String invitedParticipantId, String messageStartId, String messageEndId) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.createdById = createdById;
        this.invitedParticipantId = invitedParticipantId;
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

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getInvitedParticipantId() {
        return invitedParticipantId;
    }

    public void setInvitedParticipantId(String invitedParticipantId) {
        this.invitedParticipantId = invitedParticipantId;
    }

    public String getMessageStartId() {
        return messageStartId;
    }

    public void setMessageStartId(String messageStartId) {
        this.messageStartId = messageStartId;
    }

    public String getMessageEndId() {
        return messageEndId;
    }

    public void setMessageEndId(String messageEndId) {
        this.messageEndId = messageEndId;
    }

}
