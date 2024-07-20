package chakaChatApp.chaka.Entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "room_members", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"room_id", "user_id"})
})
public class RoomMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_id", nullable = false)
    private Long roomId;

    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name =  "role", nullable = false)
    private  String role;

    public String getRole() {
        return role;
    }

    public RoomMember(Long roomId, Long userId, String role, ChatRoom chatRoom, User user) {
        this.roomId = roomId;
        this.userId = userId;
        this.role = role;
        this.chatRoom = chatRoom;
        this.user = user;
    }

    public RoomMember() {
    }

    public RoomMember(Long id, Long roomId, Long userId, String role, LocalDateTime joinedAt, ChatRoom chatRoom, User user) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.role = role;
        this.joinedAt = joinedAt;
        this.chatRoom = chatRoom;
        this.user = user;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "joined_at", nullable = false)
    private LocalDateTime joinedAt= LocalDateTime.now();;

    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
// Getters and setters
}
