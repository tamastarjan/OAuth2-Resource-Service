package com.services.todo.todo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping(TodosController.BASE_URI)
public class TodosController {

  static final String BASE_URI = "/api/v1/todos";

  private final TodoMapper todoMapper;

  private final TodoService todoService;

  @Transactional
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TodoDto> postJson(Principal principal, @RequestBody TodoDto todoDto) {
    Todo todo = todoMapper.toEntity(todoDto);
    Todo savedTodo = todoService.create(principal, todo);
    TodoDto savedDto = todoMapper.toDto(savedTodo);

    return ResponseEntity.created(URI.create(TodoController.BASE_URI.replace("{id}",
        savedDto.getId().toString()))).body(savedDto);
  }
}
