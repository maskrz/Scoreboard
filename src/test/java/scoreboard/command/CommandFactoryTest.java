package scoreboard.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandFactoryTest {

    @Test
    void shouldCreateUnknownCommand() {
        assertTrue(CommandFactory.createCommand(null) instanceof UnknownCommand);
        assertTrue(CommandFactory.createCommand("") instanceof UnknownCommand);
        assertTrue(CommandFactory.createCommand("unknown") instanceof UnknownCommand);
    }

    @Test
    void shouldCreateHelpCommand() {
        assertTrue(CommandFactory.createCommand("hElP") instanceof HelpCommand);
    }

    @Test
    void shouldCreateTerminateCommand() {
        assertTrue(CommandFactory.createCommand("TeRmInatE") instanceof TerminateCommand);
    }

    @Test
    void shouldCreateStartGameCommand() {
        assertTrue(CommandFactory.createCommand("sTarT") instanceof StartGameCommand);
    }

    @Test
    void shouldCreateFinishGameCommand() {
        assertTrue(CommandFactory.createCommand("Finish") instanceof FinishGameCommand);
    }

    @Test
    void shouldCreateUpdateScoreCommand() {
        assertTrue(CommandFactory.createCommand("uPDate") instanceof UpdateScoreCommand);
    }

    @Test
    void shouldCreateSummaryCommand() {
        assertTrue(CommandFactory.createCommand("summaryAAAAA") instanceof SummaryCommand);
    }
}
