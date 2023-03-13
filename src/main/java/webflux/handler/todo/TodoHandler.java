package webflux.handler.todo;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import webflux.handler.Handler;
import webflux.handler.service.memo.MemoFindService;
import webflux.handler.service.model.memo.MemoQueryInputModel;
import webflux.handler.service.model.todo.TodoCommandInputModel;
import webflux.handler.service.model.todo.TodoQueryFIndAllInputModel;
import webflux.handler.service.model.todo.TodoQueryInputModel;
import webflux.handler.service.todo.TodoFindAllService;
import webflux.handler.service.todo.TodoFindService;
import webflux.handler.service.todo.TodoRegisterService;
import webflux.handler.todo.model.TodoCommandRequest;
import webflux.handler.todo.model.TodoQuery;

@Component
@RequiredArgsConstructor
public class TodoHandler implements Handler {

  private final TodoFindService todoFindService;
  private final TodoFindAllService todoFindAllService;
  private final TodoRegisterService todoRegisterService;

  private final MemoFindService memoFindService;

  public Mono<ServerResponse> findHandler(ServerRequest request) {
    return
        Mono.just(Integer.valueOf(request.pathVariable("id")))
            .flatMap(
                id ->
                    Mono.zip(
                        this.todoFindService.promise(new TodoQueryInputModel(id)),
                        this.memoFindService.promise(new MemoQueryInputModel(id))))
            .map(TodoQuery::toQuery)
            .flatMap(
                response ->
                    ok().contentType(APPLICATION_JSON).body(BodyInserters.fromValue(response)))
            .switchIfEmpty(ServerResponse.notFound().build());
  }

  public Mono<ServerResponse> findAllHandler(ServerRequest ignored) {
    return
        ok()
            .contentType(APPLICATION_JSON)
            .body(
                this.todoFindAllService
                    .promise(new TodoQueryFIndAllInputModel())
                    .map(todo -> new TodoQuery(todo.id(), todo.title(), todo.description(), todo.assignee(), null)),
                TodoQuery.class)
            .switchIfEmpty(ServerResponse.notFound().build());
  }

  public Mono<ServerResponse> registerHandler(ServerRequest request) {
    return
        request
            .bodyToMono(TodoCommandRequest.class)
            .map(this::toCommandModel)
            .flatMap(this.todoRegisterService::promise)
            .flatMap(response ->
                ok().contentType(APPLICATION_JSON).body(BodyInserters.fromValue(response)));
  }

  private TodoCommandInputModel toCommandModel(TodoCommandRequest request) {
    return new TodoCommandInputModel(request.title(), request.description(), request.assignee(), request.memo());
  }
}
