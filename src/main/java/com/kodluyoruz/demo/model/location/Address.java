package com.kodluyoruz.demo.model.location;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(nullable = false)
    private String province;

    @Column(nullable = false)
    private String town;

    private String streetLine1;
    private String streetLine2;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(province, address.province) &&
                Objects.equals(streetLine1, address.streetLine1) &&
                Objects.equals(streetLine2, address.streetLine2) &&
                Objects.equals(town, address.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(province, streetLine1, streetLine2, town);
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", streetLine1='" + streetLine1 + '\'' +
                ", streetLine2='" + streetLine2 + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}