package webflux.domain.entity.todo;


import static webflux.domain.value.Strings.BLANK;


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

  private final Integer id;
  private final Name<Todo> name;
  private final Memo<Todo> memo;

  public static Todo of(Integer id, String name, String memo) {
    return new Todo(id, Name.of(name), Memo.of(memo));
  }

  public static Todo of(Integer id) {
    return new Todo(id, Name.of(BLANK), Memo.of(BLANK));
  }

  @Override
  public Integer id() {
    return this.id;
  }
}
