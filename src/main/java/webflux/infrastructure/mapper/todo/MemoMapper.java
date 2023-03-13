package webflux.infrastructure.mapper.todo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import webflux.infrastructure.dto.todo.Memos;
import webflux.infrastructure.mapper.DataSourceMapper;

public interface MemoMapper extends DataSourceMapper<MemoMapper>, R2dbcRepository<Memos, Integer> {
}
