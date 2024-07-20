package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.Authority;
import chakaChatApp.chaka.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface AuthorityService {

    Authority createAuthority(Authority authority);

}
