package com.services.todo.todo;

import com.services.todo.user.User;
import com.services.todo.user.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;

  private final UserService userService;

  public Todo create(Principal principal, Todo todo) {
    Validate.isTrue(todo.getId() == null);

    User creator = userService.findByPrincipalOrCreateNew(principal);
    todo.setCreator(creator);

    return todoRepository.save(todo);
  }

  public Optional<Todo> findById(UUID id) {
    return todoRepository.findById(id);
  }
}
