package chakaChatApp.chaka.Respository;

import chakaChatApp.chaka.Entity.RoomMember;
import chakaChatApp.chaka.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomMemberRepository extends JpaRepository<RoomMember, Long> {
    List<RoomMember> findByUserId(Long userId);
    Optional<RoomMember> findByUserIdAndRoomId(Long userId, Long RoomId);
}
