package com.alinma.cib.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table
public class UserEntity {

    @Id
    private Long id;
    private String name;
}
