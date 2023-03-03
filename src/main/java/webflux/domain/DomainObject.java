package webflux.domain;

public interface DomainObject<D> {

  boolean equalTo(D target);
}
