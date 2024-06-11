package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.RoomMember;
import chakaChatApp.chaka.Respository.RoomMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomMemberServiceImpl implements RoomMemberService {

    private final RoomMemberRepository roomMemberRepository;

    @Autowired
    public RoomMemberServiceImpl(RoomMemberRepository roomMemberRepository) {
        this.roomMemberRepository = roomMemberRepository;
    }

    @Override
    public List<RoomMember> getAllRoomMembers() {
        return roomMemberRepository.findAll();
    }

    @Override
    public Optional<RoomMember> getRoomMemberById(Long id) {
        return roomMemberRepository.findById(id);
    }

    @Override
    public RoomMember createRoomMember(RoomMember roomMember) {
        return roomMemberRepository.save(roomMember);
    }

    @Override
    public RoomMember updateRoomMember(Long id, RoomMember roomMemberDetails) {
        Optional<RoomMember> roomMemberOptional = roomMemberRepository.findById(id);
        if (roomMemberOptional.isPresent()) {
            RoomMember roomMember = roomMemberOptional.get();
            roomMember.setRoomId(roomMemberDetails.getRoomId());
            roomMember.setUserId(roomMemberDetails.getUserId());
            roomMember.setJoinedAt(roomMemberDetails.getJoinedAt());
            return roomMemberRepository.save(roomMember);
        } else {
            throw new RuntimeException("RoomMember not found with id: " + id);
        }
    }

    @Override
    public void deleteRoomMember(Long id) {
        roomMemberRepository.deleteById(id);
    }
}
