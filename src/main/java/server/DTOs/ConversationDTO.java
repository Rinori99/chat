package server.DTOs;

import java.util.Date;

public class ConversationDTO {

    private String id;
    private Date dateCreated;

    public ConversationDTO() {}

    public ConversationDTO(String id, Date dateCreated) {
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

}
