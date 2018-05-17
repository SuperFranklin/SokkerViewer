
package main.java.logic.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Player{

    @Id
    private Integer PID;
    private String name;
    private String surename;
    private Integer height;
    private Integer weight;
    private String country;

    

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((PID == null)? 0 : PID.hashCode());
        result = prime * result + ((country == null)? 0 : country.hashCode());
        result = prime * result + ((height == null)? 0 : height.hashCode());
        result = prime * result + ((name == null)? 0 : name.hashCode());
        result = prime * result + ((surename == null)? 0 : surename.hashCode());
        result = prime * result + ((weight == null)? 0 : weight.hashCode());
        return result;
    }

    @Override
    public boolean equals( Object obj ){
        if(!getCountry().equals( (( Player ) obj).getCountry() )) return false;
        return true;
    }

}
