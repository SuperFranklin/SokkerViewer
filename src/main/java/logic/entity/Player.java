
package main.java.logic.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.java.logic.Interfaces.Identifiable;

@Entity
@Setter
@Getter
@Table(name = "PLAYER")
public class Player implements Identifiable{

    @Id
    private Integer Id;
    private String name;
    private String surename;
    private Integer height;
    private Integer weight;
    private String country;
    @OneToMany(mappedBy = "player")
    @Cascade({CascadeType.ALL })
    private Set<PlayerSkills> skills = new HashSet<>();

    public void addSkills( PlayerSkills skill ){
        skills.add( skill );
    }

    @Override
    public String toString(){
        return "[ " + Id + ", " + name + ", " + surename + ", " + height + ", " + weight + ", " + country + " ]";
    }
}
