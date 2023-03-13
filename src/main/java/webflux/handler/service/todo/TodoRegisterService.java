package webflux.handler.service.todo;

import reactor.core.publisher.Mono;
import webflux.handler.service.model.todo.TodoCommandInputModel;
import webflux.handler.service.model.todo.TodoCommandOutputModel;
import webflux.service.MonoApplicationService;

public interface TodoRegisterService extends MonoApplicationService<TodoCommandInputModel, TodoCommandOutputModel> {

  @Override
  Mono<TodoCommandOutputModel> promise(TodoCommandInputModel input);
}
