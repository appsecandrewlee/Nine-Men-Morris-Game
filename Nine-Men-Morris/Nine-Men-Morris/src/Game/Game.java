package Game;

public class Game {
    public void gameStart() {
        GameHandler gameHandler = new GameHandler();
        gameHandler.playGame();
        gameHandler.setGameStatus(GameStatus.GameRunning);
        while (gameHandler.getGameStatus() != GameStatus.GameEnd) {
            gameHandler.playGame();
        }
    }
}