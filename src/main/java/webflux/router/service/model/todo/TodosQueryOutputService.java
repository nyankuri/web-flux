package webflux.router.service.model.todo;

import java.util.List;
import webflux.service.model.Output;

public record TodosQueryOutputService(List<QueryTodo> todos) implements Output {
}
