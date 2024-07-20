package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.Authority;
import chakaChatApp.chaka.Entity.User;
import chakaChatApp.chaka.Respository.AuthorityRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements  AuthorityService {
    private  final AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public Authority createAuthority(Authority authority) {
        return authorityRepository.save(authority);
}
}
