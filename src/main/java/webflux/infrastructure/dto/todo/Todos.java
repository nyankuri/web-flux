package webflux.infrastructure.dto.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import webflux.domain.entity.todo.Todo;
import webflux.infrastructure.dto.Dto;

@Getter
@NoArgsConstructor
public class Todos implements Dto<Todos> {

  @Id
  private Integer id;
  private String name;
  private String memo;

  public Todo to() {
    return Todo.of(this.id, this.name, this.memo);
  }
}
