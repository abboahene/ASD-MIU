package game.gameState;

import game.Game;

public class Level2_5 extends GameState{

    public Level2_5(Game game) {
        super(game, "2_5");
    }

    @Override
    public void addPoints(int newPoints) {
        Game game = getGame();
        game.setTotalPoints(game.getTotalPoints() + newPoints);
        if (game.getTotalPoints() > 20) { // move to level 3
            game.setGameState(new Level3(game));
            game.setTotalPoints(game.getTotalPoints() + 1);//add 1 bonus point
        }
    }
}