package webflux.domain;

import java.util.Objects;

public interface Entity<E extends Entity<E>> extends DomainObject<E> {
  String id();

  @Override
  default boolean equalTo(E target) {
    return Objects.equals(this.id(), target.id());
  }
}
