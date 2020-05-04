package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.ChatUser;

@Repository
public interface UserRepo extends JpaRepository<ChatUser, String> {

}
