
package sokker.core.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player{

    @Id
    private Integer PID;
    private String name;
    private String surename;
    private Integer height;
    private Integer weight;
    private String country;

    
    public Integer getPID(){
        return PID;
    }

    public void setPID( Integer pID ){
        PID = pID;
    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public String getSurename(){
        return surename;
    }

    public void setSurename( String surename ){
        this.surename = surename;
    }

    public Integer getHeight(){
        return height;
    }

    public void setHeight( Integer height ){
        this.height = height;
    }

    public Integer getWeight(){
        return weight;
    }

    public void setWeight( Integer weight ){
        this.weight = weight;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry( String country ){
        this.country = country;
    }
}
