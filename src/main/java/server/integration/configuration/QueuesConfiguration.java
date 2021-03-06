package server.integration.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueuesConfiguration {

    @Value("${queue.user.new.parent}")
    private String newParentsQueueName;

    @Value("${queue.user.new.teacher}")
    private String newTeachersQueueName;

    @Value("${queue.meeting.new.online}")
    private String newOnlineMeetingQueue;

    @Bean(name = "newParentsQueue")
    public Queue newParentsQueue() {
        return new Queue(newParentsQueueName);
    }

    @Bean(name = "newTeachersQueue")
    public Queue newTeachersQueue() {
        return new Queue(newTeachersQueueName);
    }

    @Bean(name = "newOnlineMeetingQueue")
    public Queue newOnlineMeetingQueue() {
        return new Queue(newOnlineMeetingQueue);
    }

}
