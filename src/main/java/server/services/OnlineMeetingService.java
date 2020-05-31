package server.services;

import server.DTOs.OnlineMeetingDTO;
import server.integration.models.SerializableMeeting;

import java.util.List;

public interface OnlineMeetingService {

    List<OnlineMeetingDTO> getOnlineMeetingsByConversationId(String conversationId);

    void createOnlineMeeting(OnlineMeetingDTO onlineMeetingDTO);

    void handleNewSerializableMeeting(SerializableMeeting serializableMeeting);
}
