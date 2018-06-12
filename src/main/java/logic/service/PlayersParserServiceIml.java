
package main.java.logic.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

import main.java.logic.dao.PlayerDao;
import main.java.logic.entity.Player;
import main.java.logic.entity.PlayerSkills;

@Service
public class PlayersParserServiceIml implements PlayersParserService{

    @Autowired
    PlayerDao playerDao;

    @Transactional
    public List<Player> getPlayers( HtmlPage page ){

        List<String> fragments = extractTxtPerPlayer( page );

        prepareFragments( fragments );

        List<Player> players = extractPlayers( fragments );

        return players;
    }

    private List<String> extractTxtPerPlayer( HtmlPage page ){
        List<String> fragments = new ArrayList<>();

        String source = page.asXml();

        int previousLastIndex = 0;
        while (source.indexOf( "if(!playerData)", previousLastIndex ) != -1){
            int firstIndex = source.indexOf( "if(!playerData)", previousLastIndex );
            int endIndex = source.indexOf( "//]]>", firstIndex );

            String fragment = ( String ) source.subSequence( firstIndex, endIndex );

            previousLastIndex = endIndex;

            fragments.add( fragment );
        }

        return fragments;
    }

    private void prepareFragments( List<String> fragments ){

        for(String fragment : fragments){
            fragment.substring( 84 );
        }

    }

    private List<Player> extractPlayers( List<String> fragments ){
        List<Player> players = new ArrayList<>();

        for(String fragment : fragments){
            Player player = new Player();

            String[] skills = extractSkills( fragment );

            player.setName( skills[ 0 ] );
            player.setSurename( skills[ 1 ] );
            // player.setWeight( Integer.valueOf( skills[4] ) );
            player.setCountry( "Polska" );
            player.setHeight( 123 );
            player.setWeight( 99 );
            player.setId( extractId( fragment ) );
            assignSkillsToPlayer( player, skills );

            players.add( player );
        }

        return players;
    }

    private void persistPlayer( Player player ){
        playerDao.saveOrUpdate( player );
    }

    private void assignSkillsToPlayer( Player player, String[] skills ){
        PlayerSkills playerSkills = new PlayerSkills();

        playerSkills.setPlayer( player );
        playerSkills.setCondition( 12 );
        playerSkills.setDefender( 11 );
        playerSkills.setGolkeeper( 2 );
        playerSkills.setSalary( 1900000 );

        player.addSkills( playerSkills );
    }

    private Integer extractId( String fragment ){
        String PID;

        PID = ( String ) fragment.subSequence( fragment.indexOf( "[" ) + 2, fragment.indexOf( "]" ) - 1 );

        return Integer.valueOf( PID );
    }

    private String[] extractSkills( String fragment ){
        String[] skills = new String[ 15 ];

        int first = 0;
        int last = 0;
        int previous = 0;
        for(int i = 0; i < 15; i++){
            first = fragment.indexOf( "=", previous );
            last = fragment.indexOf( ";", first );
            if(i < 2){
                previous = last;
                // Two first lines does not contain data
                continue;
            }

            if(i < 4){
                skills[ i ] = ( String ) fragment.subSequence( first + 3, last - 1 );
            }else{
                skills[ i ] = ( String ) fragment.subSequence( first + 1, last );
            }
            previous = last;
        }

        return skills;
    }

}
