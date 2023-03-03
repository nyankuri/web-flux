package webflux.domain;

public non-sealed interface Value<V extends Value<V>> extends DomainObject<V> {

  String value();
}
