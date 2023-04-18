package com.services.todo.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  @Transactional
  public User findByPrincipalOrCreateNew(Principal principal) {
    Optional<User> existingUser = userRepository.findByUsername(principal.getName());

    if (existingUser.isPresent()) {
      return existingUser.get();
    }

    User newUser = new User(null, principal.getName(), null);

    userRepository.save(newUser);

    return newUser;
  }
}
