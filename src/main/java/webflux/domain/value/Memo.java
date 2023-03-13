package webflux.domain.value;

import static webflux.lib.strings.Strings.BLANK;


import java.util.Optional;
import java.util.function.Predicate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import webflux.domain.DomainObject;
import webflux.domain.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Memo<D extends DomainObject<D>> implements Value<Memo<D>> {

  private static final Integer MAX_MEMO_LENGTH = 1024;
  private static final Predicate<String> LENGTH_IS_WITH_IN_LIMIT = description -> description.length() <= MAX_MEMO_LENGTH;
  private final String value;

  public static <O extends DomainObject<O>> Memo<O> of(String value) {
    return Optional.ofNullable(value).filter(LENGTH_IS_WITH_IN_LIMIT).<Memo<O>>map(Memo::new).orElseGet(() -> new Memo<>(BLANK));
  }

  @Override
  public String value() {
    return this.value;
  }
}
