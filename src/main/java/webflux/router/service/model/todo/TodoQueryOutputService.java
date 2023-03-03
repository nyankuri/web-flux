package webflux.router.service.model.todo;

import webflux.service.model.Output;

public record TodoQueryOutputService(QueryTodo todo) implements Output {
}
