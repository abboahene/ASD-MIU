package game.gameState;

import game.Game;

public class Level1 extends GameState{

    public Level1(Game game) {
        super(game, "1");
    }

    @Override
    public void addPoints(int newPoints) {
        Game game = getGame();
        game.setTotalPoints(game.getTotalPoints() + newPoints);
        if (game.getTotalPoints() > 10) { // move to level 2
            game.setGameState(new Level2(game));
            game.setTotalPoints(game.getTotalPoints() + 1);//add 1 bonus point
        }
    }
}
