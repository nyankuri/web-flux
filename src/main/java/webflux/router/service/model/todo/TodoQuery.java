package webflux.router.service.model.todo;

import lombok.experimental.Accessors;

@Accessors(fluent = true, chain = true)
public record TodoQuery(Integer id, String name, String memo) {
}
