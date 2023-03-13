package webflux.domain;

import java.util.Objects;

public non-sealed interface Value<V extends Value<V>> extends DomainObject<V> {

  String value();

  @Override
  default boolean equalTo(V target) {
    return Objects.equals(this.value(), target.value());
  }
}
