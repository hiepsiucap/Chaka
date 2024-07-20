package chakaChatApp.chaka.Respository;

import chakaChatApp.chaka.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByPhoneNumber(String phoneNumber);
    Optional<User> findByEmail(String email);
    // Thêm các phương thức tùy chỉnh nếu cần
}
