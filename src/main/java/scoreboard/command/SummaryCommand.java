package scoreboard.command;

import scoreboard.model.Game;
import scoreboard.service.ScoreboardService;

import java.util.List;
import java.util.StringJoiner;

public class SummaryCommand extends Command {

    private List<Game> summary;

    @Override
    protected void executeCommand(ScoreboardService scoreboardService) {
        this.summary = scoreboardService.getSummary();
    }

    @Override
    protected String getOutput() {
        if (summary.size() == 0) {
            return "No games ongoing";
        }
        StringJoiner summaryJoiner = new StringJoiner(System.getProperty("line.separator"), "Summary: " + System.getProperty("line.separator"), "");
        int i = 1;
        for (Game game : summary) {
            summaryJoiner.add(i++ + ". " + game.getHomeTeam() + " " + game.getHomeScore() +
                    " - " + game.getAwayTeam() + " " + game.getAwayScore() +
                    " gameId: " + game.getId() + ", started at: " + game.getCreated());
        }
        return summaryJoiner.toString();
    }
}
