package blackjack.players;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import blackjack.BlackjackPlayer;
import blackjack.Card;
import blackjack.PlayerAction;
import blackjack.Result;

public class BasicPlayer implements BlackjackPlayer {

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
		// allowedActions.remove(PlayerAction.DOUBLE);
		// allowedActions.remove(PlayerAction.SURRENDER);
		// allowedActions.remove(PlayerAction.SPLIT);

		char decide = 0;
		try {
			Scanner in = new Scanner(new FileReader("/Platoff, Matt/blackjack/basicStrat.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		switch (decide) {

		case 'h':
			return PlayerAction.HIT;

		case 'r':
			return PlayerAction.DOUBLE;

		case 's':
			return PlayerAction.STAND;

		case 'u':
			return PlayerAction.SURRENDER;

		case 't':
			return PlayerAction.DOUBLE;

		case 'z':

			return PlayerAction.SPLIT;

		case 'p':
			return PlayerAction.SPLIT;

		}

		return allowedActions
				.get((int) (Math.random() * allowedActions.size()));

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