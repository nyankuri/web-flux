package webflux.service.impl.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import webflux.domain.entity.todo.Todo;
import webflux.domain.repository.todo.TodoRepository;
import webflux.router.service.model.todo.QueryTodo;
import webflux.router.service.model.todo.TodoQueryInputService;
import webflux.router.service.model.todo.TodosQueryOutputService;
import webflux.router.service.todo.TodoFindAllService;

@Service
@RequiredArgsConstructor
public class TodoFindAllServiceImpl implements TodoFindAllService {

  private final TodoRepository todoRepository;

  @Override
  public Mono<TodosQueryOutputService> promise(TodoQueryInputService input) {
    return
        this.todoRepository
            .findAll()
            .map(this::todo)
            .collectList()
            .map(TodosQueryOutputService::new);
  }

  private QueryTodo todo(Todo todo) {
    return new QueryTodo(todo.id(), todo.name().value(), todo.memo().value());
  }
}
