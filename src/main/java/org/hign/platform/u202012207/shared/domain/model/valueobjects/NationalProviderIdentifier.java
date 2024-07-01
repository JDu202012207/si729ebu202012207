package org.hign.platform.u202012207.shared.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * NationalProviderIdentifier.
 * <p>
 * Value object for representing a national provider identifier.
 * </p>
 *
 * @author Juan Cueto u202012207
 */
@Embeddable
@Getter
@NoArgsConstructor
public class NationalProviderIdentifier {

    private UUID value;

    public NationalProviderIdentifier(String value) {
        this.value = UUID.fromString(value);
    }

    public UUID getValue() {
        return value;
    }
}

