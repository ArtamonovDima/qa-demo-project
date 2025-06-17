package demo.qa.auth.controller;

import demo.qa.auth.data.AuthUserRepository;
import demo.qa.auth.model.LoginRequest;
import demo.qa.auth.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(AuthUserRepository authUserRepository,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        var user = authUserRepository.findByUsername(request.username())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

        if (passwordEncoder.matches(request.password(), user.getPassword())) {
            String token = jwtService.generateToken(user.getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
