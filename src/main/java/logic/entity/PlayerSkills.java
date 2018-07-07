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
import main.java.logic.Interfaces.Identifiable;

@Setter
@Getter
@Table(name = "PLAYERSKILLS")
@Entity
public class PlayerSkills implements Identifiable
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

	public void setAgeAsTxt(String txt) {
		age = Integer.valueOf( txt);
	}

	public void setValueAsTxt(String txt) {
		value = Integer.valueOf( txt);
	}

	public void setSalaryAsTxt(String txt) {
		salary = Integer.valueOf( txt);
	}

	public void setConditionAsTxt(String txt) {
		conditionn = Integer.valueOf( txt);
	}

	public void setSpeedAsTxt(String txt) {
		speed = Integer.valueOf( txt);
	}

	public void setTechniqueAsTxt(String txt) {
		technique = Integer.valueOf( txt);
	}

	public void setPassesAsTxt(String txt) {
		passes = Integer.valueOf( txt);
	}

	public void setGolkeeperAsTxt(String txt) {
		golkeeper = Integer.valueOf( txt);
	}

	public void setDefenderAsTxt(String txt) {
		defender = Integer.valueOf( txt);
	}

	public void setQuarterbackAsTxt(String txt) {
		quarterback = Integer.valueOf( txt);
	}

	public void setShootAsTxt(String txt) {
		shoot = Integer.valueOf( txt);
	}

	public void setFormAsTxt(String txt) {
		form = Integer.valueOf( txt);
	}

}
