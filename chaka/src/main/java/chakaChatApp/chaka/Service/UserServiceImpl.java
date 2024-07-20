package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.User;
import chakaChatApp.chaka.ExceptionHandler.BadRequest;
import chakaChatApp.chaka.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(User user) {


        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            throw  new BadRequest("UserName đã tồn tại vui lòng thử lại");
        }
        Optional<User> userOptional1 = userRepository.findByEmail(user.getEmail());
        if (userOptional1.isPresent()) {
            throw  new BadRequest("Email đã tồn tại vui lòng thử lại");
        }
        Optional<User> userOptional2 = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if (userOptional2.isPresent()) {
            throw  new BadRequest("Số điện thoại đã tồn tại đã tồn tại vui lòng thử lại");
        }

           return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User userDetails) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setActive(userDetails.isActive());
            user.setVerified(userDetails.isVerified());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
