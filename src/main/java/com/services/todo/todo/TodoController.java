package com.services.todo.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(TodoController.BASE_URI)
public class TodoController {

  static final String BASE_URI = "/api/v1/todo/{id}";

  private final TodoMapper todoMapper;

  private final TodoService todoService;

  @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TodoDto> getJson(@PathVariable UUID id) {
    Todo todo = todoService.findById(id).orElseThrow();
    TodoDto dto = todoMapper.toDto(todo);

    return ResponseEntity.ok(dto);
  }
}
