package scoreboard.command;

import scoreboard.exception.InvalidCommandException;
import scoreboard.service.ScoreboardService;

public class UpdateScoreCommand extends Command {

    private String command;
    private int gameId;
    private int homeScore;
    private int awayScore;
    private boolean result;

    public UpdateScoreCommand(String command) {
        super();
        this.command = command;
    }

    @Override
    protected void validate() {
        String[] commandParts = command.split(commandPartsSplitter);
        if (commandParts.length < 4) {
            throw new InvalidCommandException("update command -> expected 4 arguments");
        }
        try {
            this.gameId = Integer.valueOf(commandParts[1].trim());
            this.homeScore = Integer.valueOf(commandParts[2].trim());
            this.awayScore = Integer.valueOf(commandParts[3].trim());
        } catch (NumberFormatException ex) {
            throw new InvalidCommandException("update command -> arguments must be numbers");
        }
    }

    @Override
    protected void executeCommand(ScoreboardService scoreboardService) {
        this.result = scoreboardService.updateScore(this.gameId, this.homeScore, this.awayScore);
    }

    @Override
    protected String getOutput() {
        if (this.result) {
            return "Score updated";
        } else {
            return "Cannot update score";
        }
    }
}
