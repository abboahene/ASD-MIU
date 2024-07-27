package game.gameState;

import game.Game;

public class Level3 extends GameState{

    public Level3(Game game) {
        super(game, "3");
    }

    @Override
    public void addPoints(int newPoints) {
        Game game = getGame();
        game.setTotalPoints(game.getTotalPoints() + 3 * newPoints);
    }
}