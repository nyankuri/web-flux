package webflux.infrastructure.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.domain.entity.todo.Todo;
import webflux.domain.repository.todo.MemoRepository;
import webflux.domain.value.Memo;
import webflux.infrastructure.dto.todo.Memos;
import webflux.infrastructure.mapper.todo.MemoMapper;

@Repository
@RequiredArgsConstructor
public class MemoRepositoryImpl implements MemoRepository {

  private final MemoMapper memoMapper;

  @Override
  public Mono<Memo<Todo>> findById(Todo.Id id) {
    return
        this.memoMapper
            .findById(id.value())
            .map(Memos::getMemo)
            .map(Memo::of);
  }

  @Override
  public Flux<Memo<Todo>> findAll() {
    return
        this.memoMapper
            .findAll()
            .map(Memos::to);
  }

  @Override
  public Mono<Todo.Id> save(Todo.Id id, Memo<Todo> memo) {
    return
        this.memoMapper
            .save(Memos.saveFor(id, memo))
            .map(Memos::todoId);
  }
}
