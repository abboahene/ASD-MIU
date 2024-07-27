package game.gameState;

import game.Game;

public class Level2 extends GameState{

    public Level2(Game game) {
        super(game, "2");
    }

    @Override
    public void addPoints(int newPoints) {
        Game game = getGame();
        game.setTotalPoints(game.getTotalPoints() + 2 * newPoints);
        if (game.getTotalPoints() > 15) { // move to level 2_5
            game.setGameState(new Level2_5(game));
            game.setTotalPoints(game.getTotalPoints() + 2);//add 2 bonus point
        }
    }
}
