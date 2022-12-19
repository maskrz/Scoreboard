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
}
