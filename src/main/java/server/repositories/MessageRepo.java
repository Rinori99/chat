package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.models.ChatMessage;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<ChatMessage, String> {

//    @Query("INSERT into chat_message (id, senderId, conversationId, content) VALUES (:id, :conversationId, :senderId, :content)")
//    void saveMessage(@Param("id") String id, @Param("conversationId") String conversationId,
//                     @Param("senderId") String senderId, @Param("content") String content);

    @Query(value = "SELECT * FROM chat_message m WHERE m.conversation_id = ?1", nativeQuery = true)
    List<ChatMessage> getMessagesByConversationId(String conversationId);

}
