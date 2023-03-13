package webflux.handler.service.model.todo;

import lombok.experimental.Accessors;
import webflux.service.model.Output;

@Accessors(fluent = true, chain = true)
public record TodoQueryOutputModel(Integer id, String title, String description, String assignee) implements Output {
}
