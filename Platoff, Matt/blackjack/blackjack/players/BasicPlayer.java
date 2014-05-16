package blackjack.players;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import blackjack.BlackjackPlayer;
import blackjack.Card;
import blackjack.HandUtilities;
import blackjack.PlayerAction;
import blackjack.Result;
import blackjack.SomethingBadHappenedException;

public class BasicPlayer implements BlackjackPlayer {

	private char[][] hardTable = new char[10][10];
	private char[][] softTable = new char[7][10];
	private char[][] splitTable = new char[8][10];
	private Scanner in;

	public BasicPlayer() throws FileNotFoundException {

		in = new Scanner(new FileReader("blackjack_files\\basicStrat.txt"));
		in.useDelimiter(",");
		String temp;
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				if (in.hasNext()) {
					temp = in.next();
					hardTable[x][y] = temp.charAt(0);
				}
			}
		}

		for (int x = 0; x < 7; x++) {
			for (int y = 0; y < 10; y++) {
				if (in.hasNext()) {
					temp = in.next();
					softTable[x][y] = temp.charAt(0);
				}
			}
		}

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 10; y++) {
				if (in.hasNext()) {
					temp = in.next();
					splitTable[x][y] = temp.charAt(0);
				}
			}
		}
	}

	public String id() {
		return "Basic";
	}

	@Override
	public double bet(double minBet, double maxBet) {
		return minBet;
	}

	@Override
	public PlayerAction act(List<Card> ownHand, Card dealerUpCard,
			List<PlayerAction> allowedActions) {
		boolean soft = HandUtilities.soft(ownHand);
		char decide = 0;
		int handVal = 0;
		int tc, ti = 0;
		int temp = -1;
		boolean splitable = false;
		boolean splitAces = false;

		if (dealerUpCard.value().numericValue() != 1
				&& dealerUpCard.value().numericValue() != 11)
			tc = dealerUpCard.value().numericValue() - 2;
		else
			tc = 9;
		for (Card c : ownHand) {
			handVal += c.value().numericValue();
			if (c.value().numericValue() == temp
					|| Math.abs(temp - c.value().numericValue()) == 10) {
				splitable = true;
				if (Math.abs(temp - c.value().numericValue()) == 10)
					splitAces = true;
			}

			temp = c.value().numericValue();
		}
		if (handVal >= 4 && handVal <= 8) {
			if (handVal == 4 && splitable)
				ti = 0;
			if (handVal == 6 && splitable)
				ti = 1;
			if (handVal == 8 && splitable)
				ti = 2;
			else
				ti = 0;
		}

		if (handVal == 9) {
			if (!soft)
				ti = 1;
		}

		if (handVal == 10) {
			if (!splitable)
				ti = 2;
			else
				ti = 3;

		}
		if (handVal == 11) {
			if (!soft)
				ti = 3;
		}
		if (handVal == 12) {
			if (!splitable)
				ti = 4;
			else
				ti = 4;
		}
		if (handVal == 13) {
			if (!soft)
				ti = 5;
			else
				ti = 0;
		}
		if (handVal == 14) {
			if (splitable)
				ti = 4;
			else if (!soft)
				ti = 6;
			else
				ti = 1;
		}
		if (handVal == 15) {
			if (!soft)
				ti = 7;
			else
				ti = 2;
		}
		if (handVal == 16) {
			if (splitable)
				ti = 5;
			else if (!soft)
				ti = 8;
			else
				ti = 3;
		}
		if (handVal == 17) {
			if (!soft)
				ti = 9;
			else
				ti = 4;
		}
		if (handVal == 18) {
			if (splitable)
				ti = 6;
			else if (!soft)
				ti = 9;
			else
				ti = 5;
		}
		if (handVal == 19) {
			if (!soft)
				ti = 9;
			else
				ti = 6;
		}
		if (handVal == 20) {
			
			if (!soft)
				ti = 9;
			else
				ti = 6;
		}
		if (handVal == 21) {
			if (!soft)
				ti = 9;
			else
				ti = 6;
		}
		if (splitAces)
			ti = 7;
		if (splitable)
			decide = splitTable[ti][tc];
		else 	if (!soft)
			decide = hardTable[ti][tc];
		else if (soft)
			decide = softTable[ti][tc];
		switch (decide) {

		case 'h':
			return PlayerAction.HIT;

		case 'r':
			return allowedActions.contains(PlayerAction.DOUBLE) ? PlayerAction.DOUBLE
					: PlayerAction.STAND;

		case 's':
			return PlayerAction.STAND;

		case 'u':
			return allowedActions.contains(PlayerAction.SURRENDER) ? PlayerAction.SURRENDER
					: PlayerAction.STAND;

		case 't':

			return allowedActions.contains(PlayerAction.DOUBLE) ? PlayerAction.DOUBLE
					: PlayerAction.STAND;

		case 'z':

			return allowedActions.contains(PlayerAction.SPLIT) ? PlayerAction.SPLIT
					: PlayerAction.STAND;

		case 'p':
			return allowedActions.contains(PlayerAction.SPLIT) ? PlayerAction.SPLIT
					: PlayerAction.STAND;

		}
		System.out.println(decide);
		throw new SomethingBadHappenedException("oops, no action returned");

	}

	@Override
	public boolean insureHand(List<Card> ownHand, Card dealerUpCard) {
		return false;
	}

	@Override
	public void playerIDs(List<String> playerIDs) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialBet(int playerIndex, double bet) {
		// TODO Auto-generated method stub

	}

	@Override
	public void faceUpCard(Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insuranceDecision(int playerIndex, List<Card> playersHand,
			Card dealersUpCard, boolean insuredHand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insuranceResult(int playerIndex, double bet,
			List<Card> playersHand, Card dealersUpCard, boolean insuranceBetWon) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decision(int playerIndex, List<Card> playersHand,
			Card dealersUpCard, List<PlayerAction> allowedActions,
			PlayerAction action) {
		// TODO Auto-generated method stub

	}

	@Override
	public void result(int playerIndex, double bet, List<Card> playersHand,
			List<Card> dealersHand, Result result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialBets(List<Double> bets) {
		// TODO Auto-generated method stub

	}
}
