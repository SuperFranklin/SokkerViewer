package test.java.logic.daoTest.Filler.Implementation;

import main.java.logic.entity.PlayerSkills;
import test.java.logic.daoTest.Filler.Interface.EntityFiller;

public class PlayerSkillsFiller implements EntityFiller<PlayerSkills>
{

	@Override
	public PlayerSkills fill() {
		PlayerSkills skills = new PlayerSkills();
		
		skills.setShoot(9);
		skills.setConditionn( 10);
		skills.setDefender( 8);
		skills.setForm( 11);
		skills.setGolkeeper( 1);
		skills.setPasses( 14);
		skills.setQuarterback( 15);
		skills.setValue( 4500000);
		skills.setTechnique( 12);
		skills.setSalary( 79500);

		return skills;
	}

}
