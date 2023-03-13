package webflux.handler.service.todo;

import reactor.core.publisher.Flux;
import webflux.handler.service.model.todo.TodoQueryFIndAllInputModel;
import webflux.handler.service.model.todo.TodoQueryOutputModel;
import webflux.service.FluxApplicationService;

public interface TodoFindAllService extends FluxApplicationService<TodoQueryFIndAllInputModel, TodoQueryOutputModel> {

  @Override
  Flux<TodoQueryOutputModel> promise(TodoQueryFIndAllInputModel input);
}
