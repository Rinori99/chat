package server.services;

import org.springframework.stereotype.Service;
import server.DTOs.OnlineMeetingDTO;
import server.integration.models.SerializableMeeting;
import server.mappers.OnlineMeetingMapper;
import server.models.ChatMessage;
import server.models.ChatUser;
import server.models.OnlineMeeting;
import server.repositories.OnlineMeetingRepo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OnlineMeetingServiceImpl implements OnlineMeetingService {

    private OnlineMeetingRepo onlineMeetingRepo;
    private UserService userService;
    private MessageService messageService;

    public OnlineMeetingServiceImpl(OnlineMeetingRepo onlineMeetingRepo, UserService userService, MessageService messageService) {
        this.onlineMeetingRepo = onlineMeetingRepo;
        this.userService = userService;
        this.messageService = messageService;
    }

    @Override
    public List<OnlineMeetingDTO> getOnlineMeetingsByConversationId(String conversationId) {
        List<OnlineMeeting> onlineMeetingList = onlineMeetingRepo.getOnlineMeetingsByConversationId(conversationId);
        List<OnlineMeetingDTO> onlineMeetingDTOList = new ArrayList<>();
        for(OnlineMeeting onlineMeeting : onlineMeetingList) {
            onlineMeetingDTOList.add(OnlineMeetingMapper.onlineMeetingToOnlineMeetingDTO(onlineMeeting));
        }
        return onlineMeetingDTOList;
    }

    @Override
    public void createOnlineMeeting(OnlineMeetingDTO onlineMeetingDTO) {
        ChatUser createdBy = userService.getUserById(onlineMeetingDTO.getCreatedById());
        ChatUser invitedUser = userService.getUserById(onlineMeetingDTO.getInvitedParticipantId());
        ChatMessage messageStart = messageService.getMessageById(onlineMeetingDTO.getMessageStartId());
        ChatMessage messageEnd = messageService.getMessageById(onlineMeetingDTO.getMessageEndId());
        OnlineMeeting onlineMeeting = OnlineMeetingMapper.onlineMeetingDtoToOnlineMeeting(UUID.randomUUID().toString(),
                onlineMeetingDTO, createdBy, invitedUser, messageStart, messageEnd);
        onlineMeetingRepo.save(onlineMeeting);
    }

    @Override
    public void handleNewSerializableMeeting(SerializableMeeting serializableMeeting) {
        ChatUser createdBy = userService.getUserById(serializableMeeting.getCreatedBy());
        ChatUser invitedParticipant = userService.getUserById(serializableMeeting.getInvitedParticipant());
        OnlineMeeting onlineMeeting = new OnlineMeeting(serializableMeeting.getId(), serializableMeeting.getTitle(),
                new Timestamp(serializableMeeting.getStartTime()), new Timestamp(serializableMeeting.getEndTime()),
                serializableMeeting.getDescription(), createdBy, invitedParticipant);
        onlineMeetingRepo.save(onlineMeeting);
    }

}
