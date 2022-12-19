package scoreboard.command;

import scoreboard.exception.TerminateException;
import scoreboard.service.ScoreboardService;

public class TerminateCommand extends Command {

    @Override
    protected void executeCommand(ScoreboardService scoreboardService) {
        throw new TerminateException();
    }
}
