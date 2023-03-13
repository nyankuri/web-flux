package webflux.service.impl.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import webflux.domain.repository.todo.TodoRepository;
import webflux.handler.service.model.todo.TodoQueryFIndAllInputModel;
import webflux.handler.service.model.todo.TodoQueryOutputModel;
import webflux.handler.service.todo.TodoFindAllService;

@Service
@RequiredArgsConstructor
public class TodoFindAllServiceImpl implements TodoFindAllService {

  private final TodoRepository todoRepository;

  @Override
  public Flux<TodoQueryOutputModel> promise(TodoQueryFIndAllInputModel input) {
    return
        this.todoRepository
            .findAll()
            .map(TodoQueryConverter::new)
            .map(TodoQueryConverter::toModel);
  }
}
