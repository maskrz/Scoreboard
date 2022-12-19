package scoreboard.command;

import org.junit.jupiter.api.Test;
import scoreboard.exception.TerminateException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TerminateCommandTest {

    @Test
    void shouldThrowTerminateException() {
        assertThrows(TerminateException.class, () -> new TerminateCommand().executeCommand());
    }
}
