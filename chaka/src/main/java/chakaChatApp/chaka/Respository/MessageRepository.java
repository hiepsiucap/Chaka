package chakaChatApp.chaka.Respository;

import chakaChatApp.chaka.Entity.ChatRoom;
import chakaChatApp.chaka.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findTopByChatRoomOrderBySentAtDesc(ChatRoom chatRoom);
    List<Message> findByChatRoom(ChatRoom chatRoom);

}
