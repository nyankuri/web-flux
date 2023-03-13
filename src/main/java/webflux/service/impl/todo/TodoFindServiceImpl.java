package webflux.service.impl.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import webflux.domain.entity.todo.Todo;
import webflux.domain.repository.todo.TodoRepository;
import webflux.handler.service.model.todo.TodoQueryInputModel;
import webflux.handler.service.model.todo.TodoQueryOutputModel;
import webflux.handler.service.todo.TodoFindService;

@Service
@RequiredArgsConstructor
public class TodoFindServiceImpl implements TodoFindService {

  private final TodoRepository todoRepository;

  @Override
  public Mono<TodoQueryOutputModel> promise(TodoQueryInputModel input) {
    return
        this.todoRepository
            .findById(Todo.of(input.id()))
            .map(TodoQueryConverter::new)
            .map(TodoQueryConverter::toModel);
  }
}
