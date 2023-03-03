package webflux.domain;

public interface Aggregate<A extends Aggregate<A>> extends DomainObject<A> {
}
