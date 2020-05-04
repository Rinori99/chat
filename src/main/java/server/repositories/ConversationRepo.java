package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.models.Conversation;

@Repository
public interface ConversationRepo extends JpaRepository<Conversation, String> {

    @Query(value = "INSERT into conversation_participant (id, conversation_id, chat_user_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void saveUserToConversation(String id, String userId, String conversationId);

}
