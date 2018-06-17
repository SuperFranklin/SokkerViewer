
package main.java.logic.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import main.java.logic.dao.PlayerDao;
import main.java.logic.entity.Player;

@Service
public class LoginServiceImpl implements LoginService
{

	@Autowired
	private PlayersParserService playersParser;

	@Autowired
	private PlayerDao playerDao;

	private final String MAIN_URL = "http://sokker.org/players";
	private final String LOGIN_INPUT_FIELD_ID = "ilogin";
	private final String PASSWORD_INPUT_FIELD_ID = "ipassword";
	private final String SUBMIT_BTN_QUERY_SELECTOR = "button[type='submit']";

	@Transactional
	public void loginAndInitData(String login, String password) throws IOException {

		WebClient webClient = login( login, password);

		HtmlPage htmlPlayersPage = webClient.getPage( MAIN_URL);

		List<Player> players = playersParser.downloadPlayers( htmlPlayersPage);
		
		playerDao.savePlayers( players);
	}

	private WebClient login(String login, String password)
			throws IOException, MalformedURLException {
		WebClient webClient = new WebClient();
		webClient.getOptions().setJavaScriptEnabled( false);

		HtmlPage mainPage = webClient.getPage( MAIN_URL);

		HtmlInput loginInput = mainPage.getElementByName( LOGIN_INPUT_FIELD_ID);
		loginInput.setValueAttribute( login);

		HtmlInput passwordInput = mainPage
				.getElementByName( PASSWORD_INPUT_FIELD_ID);
		passwordInput.setValueAttribute( password);

		HtmlButton submitBtn = (HtmlButton) mainPage
				.querySelectorAll( SUBMIT_BTN_QUERY_SELECTOR).get( 0);
		mainPage = submitBtn.click();

		return webClient;
	}

}
