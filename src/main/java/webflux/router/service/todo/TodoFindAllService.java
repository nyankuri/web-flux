package webflux.router.service.todo;

import reactor.core.publisher.Flux;
import webflux.router.service.model.todo.TodoQueryInputService;
import webflux.router.service.model.todo.TodoQueryOutputService;
import webflux.service.FluxApplicationService;

public interface TodoFindAllService extends FluxApplicationService<TodoQueryInputService, TodoQueryOutputService> {

  @Override
  Flux<TodoQueryOutputService> promise(TodoQueryInputService input);
}
