package webflux.domain.repository.todo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.domain.entity.todo.Todo;
import webflux.domain.repository.Repository;

public interface TodoRepository extends Repository<Todo> {

  Flux<Todo> findAll();

  Mono<Todo> findById(Integer id);
}
