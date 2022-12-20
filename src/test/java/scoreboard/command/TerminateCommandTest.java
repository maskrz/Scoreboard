package scoreboard.command;

import org.junit.jupiter.api.Test;
import scoreboard.exception.TerminateException;
import scoreboard.service.ScoreboardService;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TerminateCommandTest {

    @Test
    void shouldThrowTerminateException() {
        assertThrows(TerminateException.class, () -> new TerminateCommand().executeCommand(new ScoreboardService()));
    }
}
