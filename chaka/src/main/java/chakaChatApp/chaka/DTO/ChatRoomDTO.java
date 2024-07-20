package chakaChatApp.chaka.DTO;

import chakaChatApp.chaka.Entity.Message;
import jakarta.persistence.Column;

import java.util.List;

public class ChatRoomDTO {
    private Long roomId;
    private String roomName;
    private  boolean isGroup;
    private List<UserDTO> participants;
    private Message message;

    public ChatRoomDTO(Long roomId, String roomName, boolean isGroup, List<UserDTO> participants, Message message) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.isGroup = isGroup;
        this.participants = participants;
        this.message = message;
    }

    public ChatRoomDTO(Long roomId, String roomName, boolean isGroup, List<UserDTO> participants) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.isGroup = isGroup;
        this.participants = participants;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public List<UserDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserDTO> participants) {
        this.participants = participants;
    }
}
