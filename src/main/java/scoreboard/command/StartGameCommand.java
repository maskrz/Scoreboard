package scoreboard.command;

import scoreboard.exception.InvalidCommandException;
import scoreboard.model.Game;
import scoreboard.service.ScoreboardService;

public class StartGameCommand extends Command {

    private String command = "";

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
    }


    @Override
    protected void executeCommand(ScoreboardService scoreboardService) {
        Game game = new Game();
    }

    @Override
    protected String getOutput() {
        return null;
    }
}
