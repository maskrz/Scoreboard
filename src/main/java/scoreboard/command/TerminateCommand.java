package scoreboard.command;

import scoreboard.exception.TerminateException;

public class TerminateCommand extends Command {

    @Override
    protected void executeCommand() {
        throw new TerminateException();
    }

    @Override
    protected String getOutput() {
        // nothing, just terminate
        return "";
    }
}
