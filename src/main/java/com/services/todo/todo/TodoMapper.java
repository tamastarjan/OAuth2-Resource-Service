package com.services.todo.todo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TodoMapper {

  @Mapping(source = "creator.id", target = "creator")
  TodoDto toDto(Todo todo);

  @Mapping(source = "creator", target = "creator", ignore = true)
  Todo toEntity(TodoDto todoDto);
}
