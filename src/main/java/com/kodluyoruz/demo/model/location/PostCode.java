package com.kodluyoruz.demo.model.location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class PostCode {
    @Column(nullable = false)
    @Pattern(regexp = "[0-9]{4}", message = "Postcode must be 4 digits")
    @NotNull(message = "required")
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCode postcode = (PostCode) o;
        return Objects.equals(value, postcode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Postcode{" +
                "value='" + value + '\'' +
                '}';
    }
}