package chakaChatApp.chaka.Respository;

import chakaChatApp.chaka.Entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    // Thêm các phương thức tùy chỉnh nếu cần
}
