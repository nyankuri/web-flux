package webflux.router.service.model.todo;

import webflux.service.model.Input;

public record TodoQueryInputService(String id) implements Input {
}
