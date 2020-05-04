package server.services;

import org.springframework.stereotype.Service;
import server.DTOs.OnlineMeetingDTO;
import server.mappers.OnlineMeetingMapper;
import server.models.OnlineMeeting;
import server.repositories.OnlineMeetingRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class OnlineMeetingServiceImpl implements OnlineMeetingService {

    private OnlineMeetingRepo onlineMeetingRepo;

    public OnlineMeetingServiceImpl(OnlineMeetingRepo onlineMeetingRepo) {
        this.onlineMeetingRepo = onlineMeetingRepo;
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

}
