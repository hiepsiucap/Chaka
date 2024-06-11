package chakaChatApp.chaka.Respository;

import chakaChatApp.chaka.Entity.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomMemberRepository extends JpaRepository<RoomMember, Long> {
}
