package webflux.service.impl.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import webflux.domain.entity.todo.Todo;
import webflux.domain.repository.todo.TodoRepository;
import webflux.router.service.model.todo.QueryTodo;
import webflux.router.service.model.todo.TodoQueryInputService;
import webflux.router.service.model.todo.TodoQueryOutputService;
import webflux.router.service.todo.TodoFindService;

@Service
@RequiredArgsConstructor
public class TodoFindServiceImpl implements TodoFindService {

  private final TodoRepository todoRepository;

  @Override
  public Mono<TodoQueryOutputService> promise(TodoQueryInputService input) {
    return
        this.todoRepository
            .findById(Integer.valueOf(input.id()))
            .map(this::todo)
            .map(TodoQueryOutputService::new);
  }

  private QueryTodo todo(Todo todo) {
    return new QueryTodo(todo.id(), todo.name().value(), todo.memo().value());
  }
}