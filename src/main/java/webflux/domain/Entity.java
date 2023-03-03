package webflux.domain;

import java.util.Objects;

public non-sealed interface Entity<E extends Entity<E>> extends DomainObject<E> {
  Integer id();

  @Override
  default boolean equalTo(E target) {
    return Objects.equals(this.id(), target.id());
  }
}
