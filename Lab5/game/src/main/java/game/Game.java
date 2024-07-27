package game;

import game.gameState.GameState;
import game.gameState.Level1;

import java.util.Random;

public class Game {
	private int totalPoints = 0;
	private GameState gameState = new Level1(this);

	public void play() {
		Random random = new Random();
		addPoints(random.nextInt(7));
		System.out.println("points="+totalPoints+" level="+gameState.getLabel());
	}

	public void addPoints(int newPoints) {
		gameState.addPoints(newPoints);
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
}
