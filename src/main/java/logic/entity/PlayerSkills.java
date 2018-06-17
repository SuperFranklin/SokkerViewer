package main.java.logic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "PLAYERSKILLS")
@Entity
public class PlayerSkills
{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Integer id;
	@ManyToOne
	Player player;
	Integer age;
	Integer value;
	Integer salary;
	//because conditin is reserved word in mysql
	Integer conditionn;
	Integer speed;
	Integer technique;
	Integer passes;
	Integer golkeeper;
	Integer defender;
	Integer quarterback;
	Integer shoot;
	Integer form;

	public void setAge(String txt) {
		age = Integer.valueOf( txt);
	}

	public void setValue(String txt) {
		value = Integer.valueOf( txt);
	}

	public void setSalary(String txt) {
		salary = Integer.valueOf( txt);
	}

	public void setCondition(String txt) {
		conditionn = Integer.valueOf( txt);
	}

	public void setSpeed(String txt) {
		speed = Integer.valueOf( txt);
	}

	public void setTechnique(String txt) {
		technique = Integer.valueOf( txt);
	}

	public void setPasses(String txt) {
		passes = Integer.valueOf( txt);
	}

	public void setGolkeeper(String txt) {
		golkeeper = Integer.valueOf( txt);
	}

	public void setDefender(String txt) {
		defender = Integer.valueOf( txt);
	}

	public void setQuarterback(String txt) {
		quarterback = Integer.valueOf( txt);
	}

	public void setShot(String txt) {
		shoot = Integer.valueOf( txt);
	}

	public void setForm(String txt) {
		form = Integer.valueOf( txt);
	}

}
