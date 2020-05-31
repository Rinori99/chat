package server.DTOs;

import java.util.Date;

public class ConversationDTO {

    private String id;
    private Date dateCreated;
    private String participantName;
    private String lastMessage;

    public ConversationDTO() {}

    public ConversationDTO(String id, Date dateCreated) {
        this.id = id;
        this.dateCreated = dateCreated;
    }

    public ConversationDTO(String id, Date dateCreated, String participantName, String lastMessage) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.participantName = participantName;
        this.lastMessage = lastMessage;
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

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
