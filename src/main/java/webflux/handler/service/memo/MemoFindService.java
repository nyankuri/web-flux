package webflux.handler.service.memo;

import reactor.core.publisher.Mono;
import webflux.handler.service.model.memo.MemoQueryInputModel;
import webflux.handler.service.model.memo.MemoQueryOutputModel;
import webflux.service.MonoApplicationService;

public interface MemoFindService extends MonoApplicationService<MemoQueryInputModel, MemoQueryOutputModel> {

  @Override
  Mono<MemoQueryOutputModel> promise(MemoQueryInputModel input);
}
