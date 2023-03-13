package webflux.domain;

import java.util.Objects;

public interface Identifier<O, V> extends Identifiable<Identifier<O, V>> {

  V value();

  @Override
  default boolean equalTo(Identifier<O, V> target) {
    return Objects.equals(this.value(), target.value());
  }

  default boolean hasValueOf(V target) {
    return Objects.equals(this.value(), target);
  }
}
