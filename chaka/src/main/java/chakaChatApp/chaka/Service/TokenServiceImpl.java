package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.Token;
import chakaChatApp.chaka.Respository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    @Autowired
    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }

    @Override
    public Optional<Token> getTokenById(Long tokenId) {
        return tokenRepository.findById(tokenId);
    }

    @Override
    public Token createToken(Token token) {
        return tokenRepository.save(token);
    }

    @Override
    public void deleteToken(Long tokenId) {
        tokenRepository.deleteById(tokenId);
    }
}
