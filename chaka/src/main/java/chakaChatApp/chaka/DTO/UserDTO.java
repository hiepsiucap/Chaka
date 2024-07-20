package chakaChatApp.chaka.DTO;

import jakarta.persistence.Column;

public class UserDTO {
    private Long userId;
    private String username;
    private  String ava;

    public String getAva() {
        return ava;
    }

    public void setAva(String ava) {
        this.ava = ava;
    }

    public UserDTO(Long userId, String username, String ava) {
        this.userId = userId;
        this.username = username;
        this.ava = ava;
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
}
