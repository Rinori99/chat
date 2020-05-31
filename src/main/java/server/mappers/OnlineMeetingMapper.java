package server.mappers;

import server.DTOs.OnlineMeetingDTO;
import server.models.ChatMessage;
import server.models.ChatUser;
import server.models.OnlineMeeting;

public class OnlineMeetingMapper {

    public static OnlineMeetingDTO onlineMeetingToOnlineMeetingDTO(OnlineMeeting onlineMeeting) {
        return new OnlineMeetingDTO(onlineMeeting.getId(), onlineMeeting.getTitle(), onlineMeeting.getStartTime(),
                onlineMeeting.getEndTime(), onlineMeeting.getDescription(), onlineMeeting.getCreatedBy().getId(),
                onlineMeeting.getInvitedParticipant().getId(), onlineMeeting.getMessageStartId().getId(),
                onlineMeeting.getMessageEndId().getId());
    }

    public static OnlineMeeting onlineMeetingDtoToOnlineMeeting(String id, OnlineMeetingDTO onlineMeetingDTO, ChatUser createdBy, ChatUser invitedUser,
                                                                ChatMessage messageStart, ChatMessage messageEnd) {
        return new OnlineMeeting(id, onlineMeetingDTO.getTitle(), onlineMeetingDTO.getStartTime(), onlineMeetingDTO.getEndTime(),
                onlineMeetingDTO.getDescription(), createdBy, invitedUser, messageStart, messageEnd);
    }

}
