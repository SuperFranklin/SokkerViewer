
package main.java.logic.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import main.java.logic.dao.PlayerDao;

@Service
public class LoginServiceImpl implements LoginService
{
	private final String LOGIN_INPUT_FIELD_ID = "ilogin";
	private final String PASSWORD_INPUT_FIELD_ID = "ipassword";
	private final String SUBMIT_BTN_QUERY_SELECTOR = "button[type='submit']";

	@Transactional
	public HtmlPage getPage(String login, String password, String url)
			throws IOException {
		return login( login, password, url).getPage( url);
	}

	private WebClient login(String login, String password, String url)
			throws IOException, MalformedURLException {
		WebClient webClient = new WebClient();
		webClient.getOptions().setJavaScriptEnabled( false);

		HtmlPage mainPage = webClient.getPage( url);

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
