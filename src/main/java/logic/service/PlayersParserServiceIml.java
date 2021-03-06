
package main.java.logic.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

import main.java.logic.dao.PlayerDao;
import main.java.logic.entity.Player;
import main.java.logic.entity.PlayerSkills;

@Service
public class PlayersParserServiceIml implements PlayersParserService
{

	@Autowired
	PlayerDao playerDao;
	public List<Player> downloadPlayers(String page) {

		List<String> fragments = extractTxtPerPlayer( page);

		prepareFragments( fragments);

		List<Player> players = extractPlayers( fragments);
		
		playerDao.savePlayers( players);

		return players;
	}

	private List<String> extractTxtPerPlayer(String source) {
		List<String> fragments = new ArrayList<>();

		int previousLastIndex = 0;
		while (source.indexOf( "if(!playerData)", previousLastIndex) != -1)
		{
			int firstIndex = source.indexOf( "if(!playerData)", previousLastIndex);
			int endIndex = source.indexOf( "//]]>", firstIndex);

			String fragment = (String) source.subSequence( firstIndex, endIndex);

			previousLastIndex = endIndex;

			fragments.add( fragment);
		}

		return fragments;
	}

	private void prepareFragments(List<String> fragments) {

		for (String fragment : fragments)
		{
			fragment.substring( 84);
		}
	}

	private List<Player> extractPlayers(List<String> fragments) {
		List<Player> players = new ArrayList<>();

		for (String fragment : fragments)
		{
			Player player = new Player();
			PlayerSkills playerSkills = new PlayerSkills();

			String[] skills = extractSkills( fragment);

			player.setName( skills[0]);
			player.setSurename( skills[1]);
			player.setId( extractId( fragment));

			playerSkills.setValueAsTxt( skills[3]);
			playerSkills.setSalaryAsTxt( skills[4]);
			playerSkills.setFormAsTxt( skills[5]);
			playerSkills.setConditionAsTxt( skills[6]);
			playerSkills.setSpeedAsTxt( skills[7]);
			playerSkills.setTechniqueAsTxt( skills[8]);
			playerSkills.setPassesAsTxt( skills[9]);
			playerSkills.setGolkeeperAsTxt( skills[10]);
			playerSkills.setDefenderAsTxt( skills[11]);
			playerSkills.setQuarterbackAsTxt( skills[12]);
			playerSkills.setShootAsTxt( skills[13]);

			player.addSkills( playerSkills);

			players.add( player);
		}

		return players;
	}

	private Integer extractId(String fragment) {
		String PID;

		PID = (String) fragment.subSequence( fragment.indexOf( "[") + 2,
				fragment.indexOf( "]") - 1);

		return Integer.valueOf( PID);
	}

	private String[] extractSkills(String fragment) {
		String[] parts = fragment.split( ";");

		Object[] objects = Arrays.stream( parts).filter( s -> isDoubleArray( s))
				.map( s -> removeUnnecessaryChars( s)).limit( 14)
				.map( s -> scrapValue( s)).toArray();

		return Arrays.asList( objects).toArray( new String[objects.length]);
	}

	private boolean isDoubleArray(String row) {
		int OPEN_SQUARE_BRACKET = 93;

		long numberOfOpenSqBracket = row.chars()
				.filter( i -> i == OPEN_SQUARE_BRACKET).count();
		if (numberOfOpenSqBracket >= 2)
		{
			return true;
		}
		return false;
	}

	private String removeUnnecessaryChars(String txt) {
		Integer SPACE = 32;
		Integer APOSTROPHE = 39;

		List<Integer> unnecessaryCharCodes = new ArrayList<>();
		unnecessaryCharCodes.add( SPACE);
		unnecessaryCharCodes.add( APOSTROPHE);

		return txt.chars()
				.filter( c -> !unnecessaryCharCodes.contains( Integer.valueOf( c)))
				.collect( StringBuilder::new, StringBuilder::appendCodePoint,
						StringBuilder::append)
				.toString();
	}

	private String scrapValue(String txt) {
		int EQUALS = 61;

		int location = txt.indexOf( EQUALS);

		return txt.substring( location + 1);
	}

}
