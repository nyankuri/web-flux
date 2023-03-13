package webflux.handler.service.model.todo;

import webflux.service.model.Output;

public record TodoCommandOutputModel(Integer id) implements Output {
}
