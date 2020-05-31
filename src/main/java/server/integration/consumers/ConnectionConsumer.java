package server.integration.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import server.integration.models.SerializableTeacherSubjectConnection;

@Service
public class ConnectionConsumer {

//
//
//    @RabbitListener(queues = {"${queue.connection.teacher.subject}"})
//    public void handleNewUserReception(SerializableTeacherSubjectConnection teacherSubjectConnection) {
//        //courseService.handleNewTeacherSubjectConnection(teacherSubjectConnection);
//    }

}


//