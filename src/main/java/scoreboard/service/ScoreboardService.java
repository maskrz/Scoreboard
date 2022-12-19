package scoreboard.service;

import scoreboard.model.Game;

public class ScoreboardService {

    ScoreboardManager scoreboardManager = new ScoreboardManager();

    public String startNewGame(String homeTeam, String awayTeam) {
        return "" + scoreboardManager.addGame(new Game(homeTeam, awayTeam));
    }
}
