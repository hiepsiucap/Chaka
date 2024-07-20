package chakaChatApp.chaka.Controller;

import chakaChatApp.chaka.DTO.LoginRequestDTO;
import chakaChatApp.chaka.DTO.LoginResponseDTO;
import chakaChatApp.chaka.DTO.MeseageDTO;
import chakaChatApp.chaka.Entity.Authority;
import chakaChatApp.chaka.Entity.EmailDetails;
import chakaChatApp.chaka.Entity.User;
import chakaChatApp.chaka.ExceptionHandler.BadRequest;
import chakaChatApp.chaka.Respository.AuthorityRepository;
import chakaChatApp.chaka.Respository.UserRepository;
import chakaChatApp.chaka.Service.AuthorityService;
import chakaChatApp.chaka.Service.EmailService;
import chakaChatApp.chaka.Service.RandomStringService;
import chakaChatApp.chaka.Service.UserService;
import chakaChatApp.chaka.constants.ApplicationConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final Environment env;
    private  final RandomStringService randomStringService;
    private  final EmailService emailService;

    private final UserService userService;
  private  final  AuthorityService authorityService;

    public AuthController(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, Environment env, RandomStringService randomStringService, EmailService emailService, UserService userService, AuthorityService authorityService) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.env = env;
        this.randomStringService = randomStringService;
        this.emailService = emailService;
        this.userService = userService;
        this.authorityService = authorityService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> Login (@RequestBody LoginRequestDTO loginRequest, HttpServletResponse response)
    {
        String jwt="";
       Optional <User> optuser = userService.getUserByUsername(loginRequest.username());
       if(optuser.isPresent())
       {
           User user= optuser.get();
           user.get
       }
        org.springframework.security.core.Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(),
                loginRequest.password());
        Authentication authenticationresponse= authenticationManager.authenticate(authentication);
        if(null != authenticationresponse && authenticationresponse.isAuthenticated()) {
            if (null != env) {
                String secret = env.getProperty(ApplicationConstants.JWT_SECRET_KEY,
                        ApplicationConstants.JWT_SECRET_DEFAULT_VALUE);
                SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
                jwt = Jwts.builder().issuer("ChaKa").subject("JWT Token")
                        .claim("username", authenticationresponse.getName())
                        .claim("authorities", authenticationresponse.getAuthorities().stream().map(
                                GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                        .issuedAt(new java.util.Date())
                        .expiration(new java.util.Date((new java.util.Date()).getTime() + 30000000))
                        .signWith(secretKey).compact();
                Cookie cookie= new Cookie("auth_token", jwt);
                cookie.setPath("/");
                cookie.setMaxAge(7 * 24 * 60 * 60);
                cookie.setHttpOnly(true);
                cookie.setSecure(true);
                response.addCookie(cookie);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).header(ApplicationConstants.JWT_HEADER,jwt)
                .body(new LoginResponseDTO(HttpStatus.OK.getReasonPhrase(), jwt));
    }
    @PostMapping("/validate")
    public ResponseEntity<MeseageDTO> AuthVerified (@RequestParam String token ,@RequestParam Long user_id)
    {
          Optional <User> tempuser=userService.getUserById(user_id);
          if(tempuser.isPresent())
          {
              User user = tempuser.get();
             if(!user.getVerifiedToken().equals(token))
             {
                   throw new BadRequest("Xác thực không thành công vui lòng thử lại");
             }
             user.setVerified(true);
             userService.updateUser(user_id,user);
             return ResponseEntity.status(HttpStatus.OK).body(new MeseageDTO("Xác thực thành công"));
          }
          throw new BadRequest("Xác thực không thành công");
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @PostMapping("/register")
    public  ResponseEntity<User> Register(@RequestBody User user)
    {
        try{
            String hashPwd= passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPwd);
            String verifiedToken = randomStringService.generateSecureRandomString();
            user.setVerifiedToken(verifiedToken);
            user.setCreateDt(new Date(System.currentTimeMillis()));
            User saveuser = createUser(user);
            EmailDetails EmailService =new EmailDetails();
            EmailService.setRecipient(saveuser.getEmail());
            EmailService.setSubject("Xác nhận email của bạn tại Chaka");
            EmailService.setMsgBody(STR."Đường dẫn xác nhận tài khoản của bạn: http://localhost:3000/auth/?token=\{verifiedToken}&user_id=\{saveuser.getUserId()}");
            emailService.sendSimpleMail(EmailService);
            Authority authority= new Authority();
            authority.setName("ROLE_USER");
            authority.setUser(user);
            Set<Authority> authorities = new HashSet<>() ;
            authorities.add(authority);
            user.setAuthorities(authorities);
            authorityService.createAuthority(authority);
            if (saveuser.getUserId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).
                        body(saveuser);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(saveuser);
            }}
        catch (Exception ex) {
            throw new BadRequest("Đăng ký thất bại: " + ex.getMessage());
        }
    }

}
