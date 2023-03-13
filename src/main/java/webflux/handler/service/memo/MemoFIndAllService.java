package webflux.handler.service.memo;

import reactor.core.publisher.Flux;
import webflux.handler.service.model.memo.MemoQueryFindAllInputModel;
import webflux.handler.service.model.memo.MemoQueryFindAllOutputModel;
import webflux.service.FluxApplicationService;

public interface MemoFIndAllService extends FluxApplicationService<MemoQueryFindAllInputModel, MemoQueryFindAllOutputModel> {

  @Override
  Flux<MemoQueryFindAllOutputModel> promise(MemoQueryFindAllInputModel input);
}
