package scoreboard.command;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import scoreboard.exception.InvalidCommandException;
import scoreboard.service.ScoreboardService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class StartGameCommandTest {

    @Test
    void shouldThrowInvalidCommandException() {
        assertThrows(InvalidCommandException.class, () -> new StartGameCommand("start|poland usa").execute(new ScoreboardService()));
        assertThrows(InvalidCommandException.class, () -> new StartGameCommand("start| |usa").execute(new ScoreboardService()));
        assertThrows(InvalidCommandException.class, () -> new StartGameCommand("start|poland|").execute(new ScoreboardService()));
    }

    @Test
    void shouldCallServiceOnValidParameters(){
        // given
        ScoreboardService scoreboardService = Mockito.mock(ScoreboardService.class);
        ArgumentCaptor<String> homeTeamCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> awayTeamCaptor = ArgumentCaptor.forClass(String.class);

        //when
        Command command = new StartGameCommand("start|Poland|USA");
        when(scoreboardService.startNewGame(any(), any())).thenReturn("5");
        String result = command.execute(scoreboardService);

        // then
        verify(scoreboardService, times(1)).startNewGame(homeTeamCaptor.capture(), awayTeamCaptor.capture());
        assertEquals("Poland", homeTeamCaptor.getValue());
        assertEquals("USA", awayTeamCaptor.getValue());
        assertEquals("Game Poland - USA started, id: 5", result);
    };
}
