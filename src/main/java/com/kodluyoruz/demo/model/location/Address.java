package com.kodluyoruz.demo.model.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String business;

    @Column(nullable = false)
    @NotEmpty(message = "required")
    @NotNull(message = "required")
    private String streetLine1;

    private String streetLine2;


    @Column(nullable = false)
    private String suburb;

    @Column(nullable = false)
    @Embedded
    @Valid
    private PostCode postcode;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(business, address.business) &&
                Objects.equals(streetLine1, address.streetLine1) &&
                Objects.equals(streetLine2, address.streetLine2) &&
                Objects.equals(suburb, address.suburb) &&
                Objects.equals(postcode, address.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(business, streetLine1, streetLine2, suburb, postcode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "business='" + business + '\'' +
                ", streetLine1='" + streetLine1 + '\'' +
                ", streetLine2='" + streetLine2 + '\'' +
                ", suburb='" + suburb + '\'' +
                ", postcode=" + postcode +
                '}';
    }
}