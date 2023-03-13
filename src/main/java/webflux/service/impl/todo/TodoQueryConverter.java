package webflux.service.impl.todo;

import lombok.AllArgsConstructor;
import webflux.domain.entity.todo.Todo;
import webflux.handler.service.model.todo.TodoQueryOutputModel;

@AllArgsConstructor
class TodoQueryConverter {

  private final Todo todo;

  TodoQueryOutputModel toModel() {
    return new TodoQueryOutputModel(this.todo.id().value(), this.todo.title().value(), this.todo.description().value(), this.todo.assignee().value());
  }
}
