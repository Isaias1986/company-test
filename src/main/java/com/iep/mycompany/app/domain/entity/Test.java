package com.iep.mycompany.app.domain.entity;

import com.iep.commons.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "test")
@Entity
@Builder
public class Test extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_generator")
    @SequenceGenerator(name = "test_generator", sequenceName = "test_seq", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

}
