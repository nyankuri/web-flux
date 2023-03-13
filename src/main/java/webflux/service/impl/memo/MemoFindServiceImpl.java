package webflux.service.impl.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import webflux.domain.entity.todo.Todo;
import webflux.domain.repository.todo.MemoRepository;
import webflux.handler.service.model.memo.MemoQueryInputModel;
import webflux.handler.service.model.memo.MemoQueryOutputModel;
import webflux.handler.service.memo.MemoFindService;

@Service
@RequiredArgsConstructor
public class MemoFindServiceImpl implements MemoFindService {

  private final MemoRepository memoRepository;

  @Override
  public Mono<MemoQueryOutputModel> promise(MemoQueryInputModel input) {
    return
        this.memoRepository
            .findById(Todo.of(input.todoId()))
            .map(memo -> new MemoQueryOutputModel(input.todoId(), memo.value()));
  }
}
