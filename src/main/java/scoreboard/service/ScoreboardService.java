package scoreboard.service;

import lombok.Setter;
import scoreboard.model.Game;

import java.util.Optional;

public class ScoreboardService {

    @Setter
    ScoreboardManager scoreboardManager;

    public ScoreboardService() {
        this.scoreboardManager = new ScoreboardManager();
    }

    public String startNewGame(String homeTeam, String awayTeam) {
        return "" + scoreboardManager.addGame(new Game(homeTeam, awayTeam));
    }

    public boolean finishGame(int gameId) {
        Optional<Game> existingGame = scoreboardManager.getGameById(gameId);
        if (existingGame.isPresent()) {
            return scoreboardManager.finishGame(existingGame.get());
        }
        return false;
    }
}
