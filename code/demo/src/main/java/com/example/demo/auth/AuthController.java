package com.example.demo.auth;

import com.example.demo.auth.dto.RegisterRequest;
import com.example.demo.user.AppUser;
import com.example.demo.user.AppUserRepository;
import com.example.demo.profile.Profile;
import com.example.demo.profile.ProfileRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AppUserRepository userRepo;
  private final ProfileRepository profileRepo;
  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

  public AuthController(AppUserRepository userRepo, ProfileRepository profileRepo) {
    this.userRepo = userRepo;
    this.profileRepo = profileRepo;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@Validated @RequestBody RegisterRequest req) {
    if (userRepo.existsByEmail(req.getEmail())) {
      return ResponseEntity.badRequest().body("Email already registered");
    }

    var now = OffsetDateTime.now(ZoneOffset.UTC);

    // create user
    AppUser u = new AppUser();
    u.setEmail(req.getEmail().trim().toLowerCase());
    u.setPasswordHash(encoder.encode(req.getPassword()));
    u.setCreatedAt(now);
    u.setUpdatedAt(now);
    userRepo.save(u);

    // create profile
    Profile p = new Profile();
    p.setUserId(u.getId());
    p.setDisplayName(req.getDisplayName());
    p.setCity(req.getCity());
    p.setBirthYear(req.getBirthYear());
    p.setCreatedAt(now);
    p.setUpdatedAt(now);
    profileRepo.save(p);

    return ResponseEntity.ok().body(
        String.format("Registered user %s with id %d", u.getEmail(), u.getId())
    );
  }
}

