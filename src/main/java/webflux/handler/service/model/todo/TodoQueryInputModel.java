package webflux.handler.service.model.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;
import webflux.service.model.Input;

@Accessors(fluent = true)
@AllArgsConstructor
@Getter
public class TodoQueryInputModel implements Input {

  private final Integer id;
}
