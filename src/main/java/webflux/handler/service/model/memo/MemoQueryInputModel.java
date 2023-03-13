package webflux.handler.service.model.memo;

import webflux.service.model.Input;

public record MemoQueryInputModel(Integer todoId) implements Input {
}
