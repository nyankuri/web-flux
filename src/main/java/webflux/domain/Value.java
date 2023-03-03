package webflux.domain;

public interface Value<V extends Value<V>> extends DomainObject<V> {

  String value();
}
