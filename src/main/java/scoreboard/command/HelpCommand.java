package scoreboard.command;

import scoreboard.service.ScoreboardService;

public class HelpCommand extends Command {

    public static final String outputText = new StringBuilder("Run following commands to execute actions:").append(System.getProperty("line.separator"))
            .append("start|homeTeamName|awayTeamName --> starts a game, returns game id").append(System.getProperty("line.separator"))
            .append("update|id|homeScore|awayScore --> updates game with <id>, sets <homeScore> and <awayScore>").append(System.getProperty("line.separator"))
            .append("finish|id --> removes game from the scoreboard").append(System.getProperty("line.separator"))
            .append("summary --> displays summary").append(System.getProperty("line.separator"))
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
