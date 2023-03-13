package webflux.domain.value;

import java.util.Optional;
import java.util.function.Predicate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import webflux.domain.DomainObject;
import webflux.domain.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Assignee<D extends DomainObject<D>> implements Value<Assignee<D>> {

  private static final Integer MAX_ASSIGNEE_LENGTH = 64;
  private static final Predicate<String> LENGTH_IS_WITH_IN_LIMIT = description -> description.length() <= MAX_ASSIGNEE_LENGTH;
  private final String value;

  public static <O extends DomainObject<O>> Assignee<O> of(String value) {
    return Optional.ofNullable(value).filter(LENGTH_IS_WITH_IN_LIMIT).<Assignee<O>>map(Assignee::new).orElseThrow(IllegalAccessError::new);
  }

  @Override
  public String value() {
    return this.value;
  }
}
