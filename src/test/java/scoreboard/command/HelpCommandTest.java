package scoreboard.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelpCommandTest {

    @Test
    void shouldDisplayHelpText() {
        assertEquals(HelpCommand.outputText, new HelpCommand().getOutput());
    }
}
