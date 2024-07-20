package chakaChatApp.chaka.DTO;

import java.time.LocalDateTime;

public class ResponseMessageDTO {
    private Long messageId;
    private Long roomId;
    private LocalDateTime sentAt;
    private  Long userId;
    private  String username;
    private  String avaUser;

    public ResponseMessageDTO(Long messageId, Long roomId, LocalDateTime sentAt, Long userId, String username, String avaUser) {
        this.messageId = messageId;
        this.roomId = roomId;
        this.sentAt = sentAt;
        this.userId = userId;
        this.username = username;
        this.avaUser = avaUser;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvaUser() {
        return avaUser;
    }

    public void setAvaUser(String avaUser) {
        this.avaUser = avaUser;
    }
}
