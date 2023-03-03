package webflux.infrastructure.mapper.todo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import webflux.infrastructure.dto.todo.Todos;
import webflux.infrastructure.mapper.DataSourceMapper;

public interface TodoMapper extends DataSourceMapper<TodoMapper>, R2dbcRepository<Todos, Integer> {
}
