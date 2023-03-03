package webflux.infrastructure.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.domain.entity.todo.Todo;
import webflux.domain.repository.todo.TodoRepository;
import webflux.infrastructure.dto.todo.Todos;
import webflux.infrastructure.mapper.todo.TodoMapper;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepository {

  private final TodoMapper todoMapper;

  @Override
  public Flux<Todo> findAll() {
    return
        this.todoMapper
            .findAll()
            .map(Todos::to);
  }

  @Override
  public Mono<Todo> findById(Integer id) {
    return
        this.todoMapper
            .findById(id)
            .map(Todos::to);
  }
}
