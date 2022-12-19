package scoreboard.command;

public class CommandFactory {

    private static final String HELP_COMMAND_TEXT = "help";
    private static final String TERMINATE_COMMAND_TEXT = "terminate";
    private static final TerminateCommand TERMINATE_COMMAND = new TerminateCommand();
    private static final UnknownCommand UNKNOWN_COMMAND = new UnknownCommand();

    public static Command createCommand(String command) {
        if (command != null) {
            if (command.toLowerCase().startsWith(HELP_COMMAND_TEXT)) {
                return new HelpCommand();
            }
            if (command.toLowerCase().startsWith(TERMINATE_COMMAND_TEXT)) {
                return TERMINATE_COMMAND;
            }
        }
        return UNKNOWN_COMMAND;
    }
}
