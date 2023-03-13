package webflux.handler.service.model.memo;

import webflux.service.model.Output;

public record MemoQueryFindAllOutputModel(Integer todoId, String memo) implements Output {
}
