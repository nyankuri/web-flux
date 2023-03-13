package webflux.domain.repository.todo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.domain.entity.todo.Todo;
import webflux.domain.repository.Repository;
import webflux.domain.value.Memo;

public interface MemoRepository extends Repository<Memo<Todo>> {

  Mono<Memo<Todo>> findById(Todo.Id id);

  Flux<Memo<Todo>> findAll();

  Mono<Todo.Id> save(Todo.Id id, Memo<Todo> memo);
}
