package main.java.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import main.java.logic.Interfaces.Identifiable;

@Entity
@Setter
@Getter
@Table(name = "TRANSFER_PLAYER")
public class TransferPlayer implements Identifiable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer Id;
	private String name;
	private String surename;
	private Integer height;
	private Integer weight;
	private String country;
	private Integer age;
	private Integer value;
	private Integer salary;
	//because conditin is reserved word in mysql
	private Integer conditionn;
	private Integer speed;
	private Integer technique;
	private Integer passes;
	private Integer golkeeper;
	private Integer defender;
	private Integer quarterback;
	private Integer shoot;
	private Integer form;

	@Override
	public String toString() {
		return "[ " + Id + ", " + name + ", " + surename + ", " + height + ", "
				+ weight + ", " + country + " ]";
	}
}
