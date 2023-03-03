package webflux.router.service.model.todo;

import lombok.experimental.Accessors;

@Accessors(fluent = true, chain = true)
public record QueryTodo(String id, String name, String memo) {
}
