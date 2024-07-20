package chakaChatApp.chaka.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    public User() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Column( name="password" ,nullable = false)
    private String password;
    @Column( name="email", nullable = false, unique = true)
    private String email;
    @Column(name = "create_dt")
    @JsonIgnore private Date createDt;
    @Column(name= "verified_token")
    @JsonIgnore private String VerifiedToken;

    @Column(name="phone_number",nullable = false)
    private String phoneNumber;

    public User(Long userId, String username, String password, String email, Date createDt, String verifiedToken, String phoneNumber, boolean isActive, boolean isVerified, Set<Authority> authorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createDt = createDt;
        VerifiedToken = verifiedToken;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.isVerified = isVerified;
        this.authorities = authorities;
    }

    public String getVerifiedToken() {
        return VerifiedToken;
    }

    public void setVerifiedToken(String verifiedToken) {
        VerifiedToken = verifiedToken;
    }

    @Column(name="is_active", nullable = false)
    private boolean isActive = false;

    @Column(name ="is_verified", nullable = false)
    private boolean isVerified = false;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Authority> authorities;

    public User(Date createDt) {
        this.createDt = createDt;
    }
    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }


}
