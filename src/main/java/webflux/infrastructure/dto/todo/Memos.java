package webflux.infrastructure.dto.todo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import webflux.domain.entity.todo.Todo;
import webflux.domain.value.Memo;
import webflux.infrastructure.dto.Dto;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Memos implements Dto<Memos> {

  @Id
  private Integer id;
  private Integer todoId;
  private String memo;

  public Todo.Id todoId() {
    return Todo.of(this.todoId);
  }

  public Memo<Todo> to() {
    return Memo.of(this.memo);
  }

  public static Memos saveFor(Todo.Id todoId, Memo<Todo> memo) {
    return new Memos(null, todoId.value(), memo.value());
  }
}
