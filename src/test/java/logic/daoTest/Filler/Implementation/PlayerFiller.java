package test.java.logic.daoTest.Filler.Implementation;

import main.java.logic.entity.Player;
import test.java.logic.daoTest.Filler.Interface.EntityFiller;

public class PlayerFiller implements EntityFiller<Player>
{

	@Override
	public Player fill() {
		Player player = new Player();

		player.setCountry( "Polska");
		player.setHeight( 188);
		player.setId( 997);
		player.setName( "Janusz");
		player.setSurename( "Radziwil");
		player.setWeight( 83);
		//player.addSkills( new PlayerSkillsFiller().fill());
		
		return player;
	}

}
