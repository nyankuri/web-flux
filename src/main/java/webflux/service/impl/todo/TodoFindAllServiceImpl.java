package webflux.service.impl.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import webflux.domain.entity.todo.Todo;
import webflux.domain.repository.todo.TodoRepository;
import webflux.router.service.model.todo.TodoQuery;
import webflux.router.service.model.todo.TodoQueryInputService;
import webflux.router.service.model.todo.TodoQueryOutputService;
import webflux.router.service.todo.TodoFindAllService;

@Service
@RequiredArgsConstructor
public class TodoFindAllServiceImpl implements TodoFindAllService {

  private final TodoRepository todoRepository;

  @Override
  public Flux<TodoQueryOutputService> promise(TodoQueryInputService input) {
    return
        this.todoRepository
            .findAll()
            .map(this::todo)
            .map(TodoQueryOutputService::new);
  }

  private TodoQuery todo(Todo todo) {
    return new TodoQuery(todo.id(), todo.name().value(), todo.memo().value());
  }
}
