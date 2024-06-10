package chakaChatApp.chaka.Respository;

import chakaChatApp.chaka.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    // Thêm các phương thức tùy chỉnh nếu cần
}
