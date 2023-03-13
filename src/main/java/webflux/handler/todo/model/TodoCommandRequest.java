package webflux.handler.todo.model;

import lombok.experimental.Accessors;

@Accessors(chain = true)
public record TodoCommandRequest(String title, String description, String assignee, String memo) {
}
