package webflux.domain.value;

import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import webflux.domain.DomainObject;
import webflux.domain.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Name<D extends DomainObject<D>> implements Value<Name<D>> {

  private final String value;

  public static <O extends DomainObject<O>> Name<O> of(String value) {
    return new Name<>(value);
  }

  @Override
  public boolean equalTo(Name<D> target) {
    return Objects.equals(this.value, target.value());
  }

  @Override
  public String value() {
    return this.value;
  }
}
