package webflux.domain.entity.todo;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;
import webflux.domain.Entity;
import webflux.domain.Identifier;
import webflux.domain.value.Assignee;
import webflux.domain.value.Description;
import webflux.domain.value.Memo;
import webflux.domain.value.Title;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true)
@Getter
public class Todo implements Entity<Todo> {

  private final Id id;
  private final Title<Todo> title;
  private final Description<Todo> description;
  private final Assignee<Todo> assignee;
  private final Memo<Todo> memo;

  public static Todo of(Integer id, String title, String description, String assignee, String memo) {
    return new Todo(new Id(id), Title.of(title), Description.of(description), Assignee.of(assignee), Memo.of(memo));
  }

  public static Todo.Id of(Integer id) {
    return new Id(id);
  }

  public static Todo of(String title, String description, String assignee, String memo) {
    return new Todo(new Id(null), Title.of(title), Description.of(description), Assignee.of(assignee), Memo.of(memo));
  }

  @Accessors(fluent = true)
  public record Id(Integer id) implements Identifier<Todo, Integer> {

    @Override
    public Integer value() {
      return this.id;
    }
  }
}
