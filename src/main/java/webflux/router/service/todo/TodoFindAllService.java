package webflux.router.service.todo;

import reactor.core.publisher.Mono;
import webflux.router.service.model.todo.TodoQueryInputService;
import webflux.router.service.model.todo.TodosQueryOutputService;
import webflux.service.ApplicationService;

public interface TodoFindAllService extends ApplicationService<TodoQueryInputService, TodosQueryOutputService> {

  @Override
  Mono<TodosQueryOutputService> promise(TodoQueryInputService input);
}
