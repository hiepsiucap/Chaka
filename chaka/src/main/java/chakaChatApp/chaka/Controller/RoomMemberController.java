package chakaChatApp.chaka.Controller;

import chakaChatApp.chaka.Entity.RoomMember;
import chakaChatApp.chaka.Service.RoomMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roommembers")
public class RoomMemberController {

    private final RoomMemberService roomMemberService;

    @Autowired
    public RoomMemberController(RoomMemberService roomMemberService) {
        this.roomMemberService = roomMemberService;
    }

    @GetMapping
    public List<RoomMember> getAllRoomMembers() {
        return roomMemberService.getAllRoomMembers();
    }

    @GetMapping("/{roomMemberId}")
    public ResponseEntity<RoomMember> getRoomMemberById(@PathVariable Long roomMemberId) {
        Optional<RoomMember> roomMember = roomMemberService.getRoomMemberById(roomMemberId);
        return roomMember.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public RoomMember createRoomMember(@RequestBody RoomMember roomMember) {
        return roomMemberService.createRoomMember(roomMember);
    }

    @DeleteMapping("/{roomMemberId}")
    public ResponseEntity<Void> deleteRoomMember(@PathVariable Long roomMemberId) {
        roomMemberService.deleteRoomMember(roomMemberId);
        return ResponseEntity.noContent().build();
    }
}
