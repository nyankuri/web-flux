package webflux.domain;

import java.util.Optional;

public interface Identifiable<T extends Identifiable<T>> {

  static <X extends Identifiable<X>> boolean equal(X a, X b) {
    return Optional.ofNullable(a).filter(x -> x.equalTo(b)).isPresent();
  }

  boolean equalTo(T target);
}
