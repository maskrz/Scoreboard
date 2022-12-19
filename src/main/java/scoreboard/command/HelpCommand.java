package scoreboard.command;

import scoreboard.service.ScoreboardManager;
import scoreboard.service.ScoreboardService;

public class HelpCommand extends Command {

    public static final String outputText = new StringBuilder("Run following commands to execute actions:").append(System.getProperty("line.separator"))
            .append("start|homeTeamName|awayTeamName --> starts a game").append(System.getProperty("line.separator"))
            .append("terminate --> terminates program").append(System.getProperty("line.separator"))
            .toString();

    @Override
    protected void executeCommand(ScoreboardService scoreboardService) {
        // nothing, just display static text
    }

    @Override
    protected String getOutput() {
        return outputText;
    }
}