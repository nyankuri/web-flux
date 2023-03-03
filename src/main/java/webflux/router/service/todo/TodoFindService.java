package webflux.router.service.todo;

import reactor.core.publisher.Mono;
import webflux.router.service.model.todo.TodoQueryInputService;
import webflux.router.service.model.todo.TodoQueryOutputService;
import webflux.service.MonoApplicationService;

public interface TodoFindService extends MonoApplicationService<TodoQueryInputService, TodoQueryOutputService> {

  @Override
  Mono<TodoQueryOutputService> promise(TodoQueryInputService input);
}
