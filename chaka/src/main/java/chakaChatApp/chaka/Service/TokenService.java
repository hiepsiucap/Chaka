package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.Token;

import java.util.List;
import java.util.Optional;

public interface TokenService {
    List<Token> getAllTokens();
    Optional<Token> getTokenById(Long tokenId);
    Token createToken(Token token);
    void deleteToken(Long tokenId);
}
