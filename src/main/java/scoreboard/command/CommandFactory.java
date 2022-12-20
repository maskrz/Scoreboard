package scoreboard.command;

public class CommandFactory {

    private static final String HELP_COMMAND_TEXT = "help";
    private static final String TERMINATE_COMMAND_TEXT = "terminate";
    private static final String START_COMMAND_TEXT = "start";
    private static final String FINISH_COMMAND_TEXT = "finish";
    private static final String UPDATE_COMMAND_TEXT = "update";
    private static final String SUMMARY_COMMAND_TEXT = "summary";
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
            if (command.toLowerCase().startsWith(START_COMMAND_TEXT)) {
                return new StartGameCommand(command);
            }
            if (command.toLowerCase().startsWith(FINISH_COMMAND_TEXT)) {
                return new FinishGameCommand(command);
            }
            if (command.toLowerCase().startsWith(UPDATE_COMMAND_TEXT)) {
                return new UpdateScoreCommand(command);
            }
            if (command.toLowerCase().startsWith(SUMMARY_COMMAND_TEXT)) {
                return new SummaryCommand();
            }
        }
        return UNKNOWN_COMMAND;
    }
}
