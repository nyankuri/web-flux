package webflux.domain.entity.todo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;
import webflux.domain.Entity;
import webflux.domain.value.Memo;
import webflux.domain.value.Name;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true)
@Getter
public class Todo implements Entity<Todo> {

  private final String id;
  private final Name<Todo> name;
  private final Memo<Todo> memo;

  public static Todo of(Integer id, String name, String memo) {
    return new Todo(id.toString(), Name.of(name), Memo.of(memo));
  }

  @Override
  public String id() {
    return this.id;
  }
}
