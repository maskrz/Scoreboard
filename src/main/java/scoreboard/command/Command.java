package scoreboard.command;

import scoreboard.service.ScoreboardService;

public abstract class Command {

    protected final String commandPartsSplitter = "|";

    public String execute(ScoreboardService scoreboardService) {
        validate();
        executeCommand(scoreboardService);
        return getOutput();
    }

    protected void validate() {
        // nothing, just do not throw exception
    }

    protected abstract void executeCommand(ScoreboardService scoreboardService);

    protected String getOutput() {
        return "Command executed";
    }

    ;


}
