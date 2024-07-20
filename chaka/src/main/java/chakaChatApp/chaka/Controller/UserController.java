package chakaChatApp.chaka.Controller;

import chakaChatApp.chaka.DTO.ChatRoomDTO;
import chakaChatApp.chaka.DTO.LoginRequestDTO;
import chakaChatApp.chaka.DTO.LoginResponseDTO;
import chakaChatApp.chaka.Entity.Authority;
import chakaChatApp.chaka.Entity.ChatRoom;
import chakaChatApp.chaka.Entity.User;
import chakaChatApp.chaka.ExceptionHandler.BadRequest;
import chakaChatApp.chaka.ExceptionHandler.UnAuthenticated;
import chakaChatApp.chaka.Respository.UserRepository;
import chakaChatApp.chaka.Service.UserService;
import chakaChatApp.chaka.constants.ApplicationConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("")
    public List<User> getAllUsers() {
       throw new UnAuthenticated("không tồn tại tài khoản nào ");
//        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User userDetails) {
        try {
            User updatedUser = userService.updateUser(userId, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/currentUser")
    public  ResponseEntity<User>  getCurrUser()
    {
        User user= userService.getCurrentUser();
        if(user != null)
        return ResponseEntity.ok(user);
        else throw new BadRequest("No user exist");
    }
    @GetMapping("/currRooms")
    public List<ChatRoomDTO> getRoomsForUser() {
        User user = userService.getCurrentUser();
        if(user != null)
            return userService.getRoomsForUser(user.getUserId());
        else throw new BadRequest("No user exist");

    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
