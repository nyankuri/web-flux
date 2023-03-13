package webflux.domain.value;

import java.util.Optional;
import java.util.function.Predicate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import webflux.domain.DomainObject;
import webflux.domain.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Title<D extends DomainObject<D>> implements Value<Title<D>> {

  private static final Integer MAX_TITLE_LENGTH = 64;
  private static final Predicate<String> LENGTH_IS_WITH_IN_LIMIT = description -> description.length() <= MAX_TITLE_LENGTH;
  private final String value;

  public static <O extends DomainObject<O>> Title<O> of(String value) {
    return Optional.ofNullable(value).filter(LENGTH_IS_WITH_IN_LIMIT).<Title<O>>map(Title::new).orElseThrow(IllegalAccessError::new);
  }

  @Override
  public String value() {
    return this.value;
  }
}
