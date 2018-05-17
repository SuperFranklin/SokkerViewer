
package main.java.logic.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.java.logic.Interfaces.Identifiable;

@Entity
@Setter
@Getter
@EqualsAndHashCode
public class Player implements Identifiable{

    @Id
    private Long id;
    private Integer PID;
    private String name;
    private String surename;
    private Integer height;
    private Integer weight;
    private String country;
}
