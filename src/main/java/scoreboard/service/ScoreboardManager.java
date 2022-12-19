package scoreboard.service;

import lombok.Setter;
import scoreboard.exception.BusinessException;
import scoreboard.model.Game;
import scoreboard.model.Scoreboard;

import java.util.Optional;

public class ScoreboardManager {

    // setter for junit mock. Normally DI would do the job.
    @Setter
    private Scoreboard scoreboard;

    public ScoreboardManager() {
        this.scoreboard = new Scoreboard();
    }

    public int addGame(Game game) {
        Game currentGame = scoreboard.findExistingGame(game);
        if (currentGame != null) {
            throw new BusinessException("Game already exists");
        }
        return scoreboard.addGame(game);
    }

    public Optional<Game> getGameById(int gameId) {
        return Optional.ofNullable(scoreboard.findExistingGame(gameId));
    }

    public boolean finishGame(Game game){
        return scoreboard.removeGame(game);
    }

    public void updateScore(Game gameDto){}

    public void getSummary(){} {}
}
