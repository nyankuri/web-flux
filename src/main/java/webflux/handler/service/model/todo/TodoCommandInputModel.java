package webflux.handler.service.model.todo;

import lombok.experimental.Accessors;
import webflux.service.model.Input;

@Accessors(chain = true)
public record TodoCommandInputModel(String title, String description, String assignee, String memo) implements Input {
}
