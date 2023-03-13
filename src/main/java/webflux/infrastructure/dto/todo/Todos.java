package webflux.infrastructure.dto.todo;

import static webflux.lib.strings.Strings.BLANK;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import webflux.domain.entity.todo.Todo;
import webflux.infrastructure.dto.Dto;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Todos implements Dto<Todos> {

  @Id
  private Integer id;
  private String title;
  private String description;
  private String assignee;

  public Todo to() {
    return Todo.of(this.id, this.title, this.description, this.assignee, BLANK);
  }

  public static Todos saveFor(Todo entity) {
    return new Todos(null, entity.title().value(), entity.description().value(), entity.assignee().value());
  }
}
