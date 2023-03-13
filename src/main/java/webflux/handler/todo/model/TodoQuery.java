package webflux.handler.todo.model;

import lombok.experimental.Accessors;
import reactor.util.function.Tuple2;
import webflux.handler.service.model.memo.MemoQueryOutputModel;
import webflux.handler.service.model.todo.TodoQueryOutputModel;

@Accessors(fluent = true, chain = true)
public record TodoQuery(Integer id, String title, String description, String assignee, String memo) {

  public static TodoQuery toQuery(Tuple2<TodoQueryOutputModel, MemoQueryOutputModel> aggregation) {
    var todoOutput = aggregation.getT1();
    var memoOutput = aggregation.getT2();
    return new TodoQuery(todoOutput.id(), todoOutput.title(), todoOutput.description(), todoOutput.assignee(), memoOutput.memo());
  }
}
