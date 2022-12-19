package scoreboard.command;

import scoreboard.exception.InvalidCommandException;
import scoreboard.service.ScoreboardService;
import scoreboard.utils.StringUtils;

public class FinishGameCommand extends Command {

    private String command;
    private int gameId;
    private boolean result;

    public FinishGameCommand(String command) {
        super();
        this.command = command;
    }

    @Override
    protected void validate() {
        String[] commandParts = command.split(commandPartsSplitter);
        if (commandParts.length < 2) {
            throw new InvalidCommandException("finish command -> expected 2 arguments");
        }
        try {
            this.gameId = Integer.valueOf(commandParts[1]);
        } catch (NumberFormatException ex) {
            throw new InvalidCommandException("finish command -> id must be a number");
        }
    }


    @Override
    protected void executeCommand(ScoreboardService scoreboardService) {
        this.result = scoreboardService.finishGame(this.gameId);
    }

    @Override
    protected String getOutput() {
        if (this.result) {
            return "Game finished";
        } else {
            return "Cannot finish game";
        }
    }
}
