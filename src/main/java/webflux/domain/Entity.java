package webflux.domain;

public non-sealed interface Entity<E extends Entity<E>> extends DomainObject<E> {

  <I extends Identifier<E, Object>> I id();

  @Override
  default boolean equalTo(E target) {
    return this.id().equalTo(target.id());
  }
}
