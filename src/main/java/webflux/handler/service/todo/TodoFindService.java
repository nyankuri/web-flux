package webflux.handler.service.todo;

import reactor.core.publisher.Mono;
import webflux.handler.service.model.todo.TodoQueryInputModel;
import webflux.handler.service.model.todo.TodoQueryOutputModel;
import webflux.service.MonoApplicationService;

public interface TodoFindService extends MonoApplicationService<TodoQueryInputModel, TodoQueryOutputModel> {

  @Override
  Mono<TodoQueryOutputModel> promise(TodoQueryInputModel input);
}
