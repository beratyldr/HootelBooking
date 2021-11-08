package com.kodluyoruz.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodluyoruz.demo.model.location.Address;
import lombok.*;
import lombok.experimental.SuperBuilder;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "hotels")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE hotels SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Hotel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max=150)
    @Column(unique = true,length = 150,nullable = false)
    private String name;

    @Column(nullable = false)
    private Address address;// il ilçe ve sokak verilerinin bulunduğu ayrı bir class model/location

    @Column(nullable = false)
    private int star;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)// Stop bidirectional relationship which cause a cycle.
    @JsonIgnore
    private List<Room> rooms;
}
