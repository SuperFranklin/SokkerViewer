
package main.java.logic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import main.java.logic.entity.Player;
import main.java.logic.entity.Transfer;
import main.java.logic.service.LoginService;
import main.java.logic.service.PlayersParserService;
import main.java.logic.service.TransferParser;

@Controller
public class LoginController
{

	private static final String PLAYER_PAGE = "http://sokker.org/players";
	private static final String TRANSFER_PAGE = "http://sokker.org/transferSearch/trainer/0/pg/1/transfer_list/1/sort/end";
	@Autowired
	LoginService loginService;

	@Autowired
	PlayersParserService playersParser;

	@Autowired
	TransferParser transferParser;

	@GetMapping("/")
	public String showRegistrationForm() {
		return "loginForm";
	}

	@PostMapping("/")
	public String loginProcess(HttpServletRequest request, Model model) {
		String login = request.getParameter( "login");
		String password = request.getParameter( "password");

		try
		{
			HtmlPage playerPage = loginService.getPage( login, password,
					PLAYER_PAGE);
			List<Player> players = playersParser
					.downloadPlayers( playerPage.asXml());

			HtmlPage transferPage = loginService.getPage( login, password,
					TRANSFER_PAGE);

			List<Transfer> transfers = transferParser
					.downloadsTransfer( transferPage.asXml());
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return "loginSuccess";
	}
}
