package scoreboard.command;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import scoreboard.exception.InvalidCommandException;
import scoreboard.service.ScoreboardService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class FinishGameCommandTest {

    @Test
    void shouldThrowInvalidCommandException() {
        assertThrows(InvalidCommandException.class, () -> new FinishGameCommand("finish|").execute(new ScoreboardService()));
        assertThrows(InvalidCommandException.class, () -> new FinishGameCommand("finish|a").execute(new ScoreboardService()));
        assertThrows(InvalidCommandException.class, () -> new FinishGameCommand("finish").execute(new ScoreboardService()));
    }

    @Test
    void shouldCallServiceOnValidParameters(){
        // given
        ScoreboardService scoreboardService = Mockito.mock(ScoreboardService.class);
        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);

        //when
        Command command = new FinishGameCommand("finish|2");
        when(scoreboardService.finishGame(anyInt())).thenReturn(true);
        String result = command.execute(scoreboardService);

        // then
        verify(scoreboardService, times(1)).finishGame(idCaptor.capture());
        assertEquals(2, idCaptor.getValue());
        assertEquals("Game finished", result);
    };
}
