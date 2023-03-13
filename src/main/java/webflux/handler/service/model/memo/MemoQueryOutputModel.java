package webflux.handler.service.model.memo;

import webflux.service.model.Output;

public record MemoQueryOutputModel(Integer todoId, String memo) implements Output {
}
