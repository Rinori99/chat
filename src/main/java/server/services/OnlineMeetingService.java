package server.services;

import server.DTOs.OnlineMeetingDTO;

import java.util.List;

public interface OnlineMeetingService {

    List<OnlineMeetingDTO> getOnlineMeetingsByConversationId(String conversationId);

}
