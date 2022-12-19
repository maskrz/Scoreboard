package scoreboard.command;

import scoreboard.exception.InvalidCommandException;
import scoreboard.service.ScoreboardService;
import scoreboard.utils.StringUtils;

public class StartGameCommand extends Command {

    private String command;
    private String homeTeam;
    private String awayTeam;
    private String resultId;

    public StartGameCommand(String command) {
        super();
        this.command = command;
    }

    @Override
    protected void validate() {
        String[] commandParts = command.split(commandPartsSplitter);
        if (commandParts.length < 3) {
            throw new InvalidCommandException("start command -> expected 3 arguments");
        }
        this.homeTeam = commandParts[1].trim();
        this.awayTeam = commandParts[2].trim();
        if (StringUtils.isBlank(homeTeam) || StringUtils.isBlank(awayTeam)) {
            throw new InvalidCommandException("start command -> team name cannot be blank");
        }
    }


    @Override
    protected void executeCommand(ScoreboardService scoreboardService) {
        this.resultId = scoreboardService.startNewGame(this.homeTeam, this.awayTeam);
    }

    @Override
    protected String getOutput() {
        return "Game " + this.homeTeam + " - " + this.awayTeam + " started, id: " + resultId;
    }
}
