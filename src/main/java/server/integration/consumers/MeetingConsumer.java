package server.integration.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import server.integration.models.SerializableMeeting;
import server.services.OnlineMeetingService;

@Service
public class MeetingConsumer {

    private OnlineMeetingService onlineMeetingService;

    public MeetingConsumer(OnlineMeetingService onlineMeetingService) {
        this.onlineMeetingService = onlineMeetingService;
    }

    @RabbitListener(queues = {"${queue.meeting.new.online}"})
    public void handleNewOnlineMeeting(SerializableMeeting serializableMeeting) {
        onlineMeetingService.handleNewSerializableMeeting(serializableMeeting);
    }

}
