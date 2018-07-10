package main.java.logic.service;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import main.java.logic.entity.Transfer;

@Service
public class TransferParserImpl implements TransferParser
{
	private static final Pattern hrevPattern = Pattern
			.compile( ".*<a\\s+href=\"(.*)\">.*");
	private static final Pattern playerLinkPattern = Pattern.compile( ".*PID.*");

	@Override
	public List<Transfer> downloadsTransfer(String page) {
		Scanner scanner = new Scanner( page);
		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			if (hasLinkToPlayer( line))
			{
				System.out.println( "playerLine = " + line);
			}
		}
		scanner.close();

		return null;
	}

	private boolean hasLinkToPlayer(String line) {
		/*
		 * return hrevPattern.matcher( line).matches() && line.contains( "PID");
		 */
		return line.contains( "PID");
	}

}
