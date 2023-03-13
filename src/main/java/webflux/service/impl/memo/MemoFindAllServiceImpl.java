package webflux.service.impl.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import webflux.domain.repository.todo.MemoRepository;
import webflux.handler.service.memo.MemoFIndAllService;
import webflux.handler.service.model.memo.MemoQueryFindAllInputModel;
import webflux.handler.service.model.memo.MemoQueryFindAllOutputModel;

@Service
@RequiredArgsConstructor
public class MemoFindAllServiceImpl implements MemoFIndAllService {

  private final MemoRepository memoRepository;

  @Override
  public Flux<MemoQueryFindAllOutputModel> promise(MemoQueryFindAllInputModel input) {
    return null;
  }
}
