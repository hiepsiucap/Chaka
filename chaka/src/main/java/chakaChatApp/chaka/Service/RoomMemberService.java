package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.RoomMember;

import java.util.List;
import java.util.Optional;

public interface RoomMemberService {
    List<RoomMember> getAllRoomMembers();
    Optional<RoomMember> getRoomMemberById(Long id);
    RoomMember createRoomMember(RoomMember roomMember);
    RoomMember updateRoomMember(Long id, RoomMember roomMemberDetails);

    Boolean CheckRoomMember(Long userId, Long roomId);
    void deleteRoomMember(Long id);
}
