package main.java.logic.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Getter;
import lombok.Setter;
import main.java.logic.Interfaces.Identifiable;

@Getter
@Setter
@Entity
public class Transfer implements Identifiable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private Integer price;
	private Date date;
	@OneToOne
	@Cascade({ CascadeType.ALL })
	private TransferPlayer transferPlayer;
}
