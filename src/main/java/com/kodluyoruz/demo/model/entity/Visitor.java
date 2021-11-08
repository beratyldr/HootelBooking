package com.kodluyoruz.demo.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "visitors")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE visitors SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Visitor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 2, max = 20)
    @NotNull(message = "required")
    @Column(nullable = false)
    private String firstName;

    @Size(min = 2, max = 20)
    @NotNull(message = "required")
    @Column(nullable = false)
    private String lastName;

    private boolean child;
}
