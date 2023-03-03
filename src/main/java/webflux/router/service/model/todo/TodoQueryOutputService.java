package webflux.router.service.model.todo;

import webflux.service.model.Output;

public record TodoQueryOutputService(TodoQuery todo) implements Output {
}
