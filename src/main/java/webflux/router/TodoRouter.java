package webflux.router;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import webflux.handler.todo.TodoHandler;

@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class TodoRouter {

  private final TodoHandler todoHandler;

  @Bean
  public RouterFunction<ServerResponse> route() {
    return
        RouterFunctions
            .route(GET("/todo/find/{id}").and(accept(APPLICATION_JSON)), this.todoHandler::findHandler)
            .andRoute(GET("/todo/list").and(accept(APPLICATION_JSON)), this.todoHandler::findAllHandler)
            .andRoute(POST("/todo").and(accept(APPLICATION_JSON)), this.todoHandler::registerHandler);
  }
}
