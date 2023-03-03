package webflux.service;

import reactor.core.publisher.Mono;
import webflux.service.model.Input;
import webflux.service.model.Output;

public interface ApplicationService<I extends Input, O extends Output> {

  Mono<O> promise(I input);
}
