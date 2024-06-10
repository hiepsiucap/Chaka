package chakaChatApp.chaka.Respository;

import chakaChatApp.chaka.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
