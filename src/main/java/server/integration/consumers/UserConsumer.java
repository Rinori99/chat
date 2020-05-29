package server.integration.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import server.integration.models.SerializableUser;
import server.services.UserService;

@Service
public class UserConsumer {

//    private UserService userService;
//
//    public UserConsumer(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RabbitListener(queues = {"${queue.user.new.teacher}", "${queue.user.new.parent}"})
//    public void handleNewUserReception(SerializableUser user) {
//        userService.saveUser(user.getId(), user.getFirstName(), user.getLastName(), user.getRole());
//    }

}
