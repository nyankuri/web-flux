package webflux.router.service.todo;

import reactor.core.publisher.Mono;
import webflux.router.service.model.todo.TodoQueryInputService;
import webflux.router.service.model.todo.TodoQueryOutputService;
import webflux.service.ApplicationService;

public interface TodoFindService extends ApplicationService<TodoQueryInputService, TodoQueryOutputService> {

  @Override
  Mono<TodoQueryOutputService> promise(TodoQueryInputService input);
}
