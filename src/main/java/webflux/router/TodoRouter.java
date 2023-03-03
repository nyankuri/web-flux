package webflux.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import webflux.router.service.model.todo.TodoQueryInputService;
import webflux.router.service.todo.TodoFindAllService;
import webflux.router.service.todo.TodoFindService;

@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class TodoRouter {

  private final TodoFindService todoFindService;
  private final TodoFindAllService todoFindAllService;

  @Bean
  public RouterFunction<ServerResponse> route() {
    return
        RouterFunctions
            .route(
                GET("/todo/find/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->
                    this.todoFindService
                        .promise(new TodoQueryInputService(request.pathVariable("id")))
                        .flatMap(
                            output ->
                                ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(output))))
            .andRoute(
                GET("/todo/all").and(accept(MediaType.APPLICATION_JSON)),
                request ->
                    this.todoFindAllService
                        .promise(new TodoQueryInputService(null))
                        .flatMap(
                            output ->
                                ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(output))));
  }
}
