package webflux.domain;

public sealed interface DomainObject<D> permits Aggregate, Entity, Value {

  boolean equalTo(D target);
}
