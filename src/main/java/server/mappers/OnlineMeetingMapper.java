package server.mappers;

import server.DTOs.OnlineMeetingDTO;
import server.models.OnlineMeeting;

public class OnlineMeetingMapper {

    public static OnlineMeetingDTO onlineMeetingToOnlineMeetingDTO(OnlineMeeting onlineMeeting) {
        return new OnlineMeetingDTO(onlineMeeting.getId(), onlineMeeting.getTitle(), onlineMeeting.getStartTime(),
                onlineMeeting.getEndTime(), onlineMeeting.getDescription(), onlineMeeting.getCreatedBy().getId(),
                onlineMeeting.getInvitedParticipant().getId(), onlineMeeting.getMessageStartId().getId(),
                onlineMeeting.getMessageEndId().getId());
    }

}
