package webflux.domain.value;

import java.util.Optional;
import java.util.function.Predicate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import webflux.domain.DomainObject;
import webflux.domain.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Description<D extends DomainObject<D>> implements Value<Description<D>> {

  private static final Integer MAX_DESCRIPTION_LENGTH = 1024;
  private static final Predicate<String> LENGTH_IS_WITH_IN_LIMIT = description -> description.length() <= MAX_DESCRIPTION_LENGTH;
  private final String value;

  public static <O extends DomainObject<O>> Description<O> of(String value) {
    return Optional.ofNullable(value).filter(LENGTH_IS_WITH_IN_LIMIT).<Description<O>>map(Description::new).orElseThrow(IllegalAccessError::new);
  }

  @Override
  public String value() {
    return this.value;
  }
}
