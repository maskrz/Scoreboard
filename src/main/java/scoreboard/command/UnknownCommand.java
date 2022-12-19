package scoreboard.command;

public class UnknownCommand extends Command {

    private static final String outputText = "Unknown command, type \"help\" for help";

    @Override
    protected void executeCommand() {
        // nothing, just display static text
    }

    @Override
    protected String getOutput() {
        return outputText;
    }
}
