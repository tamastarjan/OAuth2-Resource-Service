package com.services.todo.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {

  private UUID id;

  private String description;

  private String creator;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}
