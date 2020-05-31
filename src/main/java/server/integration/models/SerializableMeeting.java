package server.integration.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public final class SerializableMeeting implements Serializable {

    private final String id;
    private final String title;
    private final long startTime;
    private final long endTime;
    private final String place;
    private final String description;
    private final String createdBy;
    private final String invitedParticipant;

    public SerializableMeeting(@JsonProperty("id") String id,
                               @JsonProperty("title")String title,
                               @JsonProperty("startTime")long startTime,
                               @JsonProperty("endTime")long endTime,
                               @JsonProperty("place")String place,
                               @JsonProperty("description")String description,
                               @JsonProperty("createdBy") String createdBy,
                               @JsonProperty("invitedParticipant") String invitedParticipant) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
        this.description = description;
        this.createdBy = createdBy;
        this.invitedParticipant = invitedParticipant;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getInvitedParticipant() {
        return invitedParticipant;
    }

}
