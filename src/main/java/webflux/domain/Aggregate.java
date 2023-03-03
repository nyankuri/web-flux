package webflux.domain;

public non-sealed interface Aggregate<A extends Aggregate<A>> extends DomainObject<A> {
}
