package webflux.service.impl.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import webflux.domain.entity.todo.Todo;
import webflux.domain.repository.todo.MemoRepository;
import webflux.domain.repository.todo.TodoRepository;
import webflux.handler.service.model.todo.TodoCommandInputModel;
import webflux.handler.service.model.todo.TodoCommandOutputModel;
import webflux.handler.service.todo.TodoRegisterService;

@Service
@RequiredArgsConstructor
public class TodoRegisterServiceImpl implements TodoRegisterService {

  private final TodoRepository todoRepository;
  private final MemoRepository memoRepository;

  @Override
  public Mono<TodoCommandOutputModel> promise(TodoCommandInputModel input) {
    final var todo = Todo.of(input.title(), input.description(), input.assignee(), input.memo());
    return
        this.todoRepository
            .save(todo)
            .flatMap(id -> this.memoRepository.save(id, todo.memo()))
            .map(Todo.Id::value)
            .map(TodoCommandOutputModel::new);
  }
}
