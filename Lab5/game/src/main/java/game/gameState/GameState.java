package game.gameState;

import game.Game;

public abstract class GameState {

    private Game game;
    private String label;

    public GameState(Game game, String label) {
        this.game = game;
        this.label = label;
    }

    public abstract void addPoints(int newPoints);

    public Game getGame() {
        return game;
    }

    public String getLabel() {
        return label;
    }
}
