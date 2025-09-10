package com.iep.mycompany.app.domain.entity;

import com.iep.commons.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "test")
public class Test extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_generator")
    @SequenceGenerator(name = "test_generator", sequenceName = "test_seq", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    public Test() {
    }

    @Builder
    public Test(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
