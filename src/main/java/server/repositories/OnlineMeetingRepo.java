package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.models.OnlineMeeting;

import java.util.List;

@Repository
public interface OnlineMeetingRepo extends JpaRepository<OnlineMeeting, String> {

    @Query(value = "SELECT * FROM online_meeting om WHERE om.conversation_id = ?1", nativeQuery = true)
    List<OnlineMeeting> getOnlineMeetingsByConversationId(String conversationId);

}
