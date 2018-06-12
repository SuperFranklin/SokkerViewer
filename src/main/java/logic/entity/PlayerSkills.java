package main.java.logic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "PLAYER_SKILLS")
@Entity
public class PlayerSkills{

    @Id
    Integer id;
    @ManyToOne
    Player player;
    Integer age;
    Integer value;
    Integer salary;
    Integer condition;
    Integer speed;
    Integer technique;
    Integer passes;
    Integer golkeeper;
    Integer defender;
    Integer quarterback;
    Integer shot;
}
