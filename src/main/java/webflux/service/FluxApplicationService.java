package webflux.service;

import reactor.core.publisher.Flux;
import webflux.service.model.Input;
import webflux.service.model.Output;

public interface FluxApplicationService<I extends Input, O extends Output> {

  Flux<O> promise(I input);
}
