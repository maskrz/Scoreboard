package scoreboard.command;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import scoreboard.exception.InvalidCommandException;
import scoreboard.service.ScoreboardService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UpdateScoreCommandTest {

    @Test
    void shouldThrowInvalidCommandException() {
        assertThrows(InvalidCommandException.class, () -> new UpdateScoreCommand("update|1 2 3").execute(new ScoreboardService()));
        assertThrows(InvalidCommandException.class, () -> new UpdateScoreCommand("update|x|1|2").execute(new ScoreboardService()));
        assertThrows(InvalidCommandException.class, () -> new UpdateScoreCommand("update|1|2|").execute(new ScoreboardService()));
    }

    @Test
    void shouldCallServiceOnValidParameters(){
        // given
        ScoreboardService scoreboardService = Mockito.mock(ScoreboardService.class);
        ArgumentCaptor<Integer> gameIdCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> homeTeamScoreCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> awayTeamScoreCaptor = ArgumentCaptor.forClass(Integer.class);

        //when
        Command command = new UpdateScoreCommand("update|1|2|3");
        when(scoreboardService.updateScore(anyInt(), anyInt(), anyInt())).thenReturn(true);
        String result = command.execute(scoreboardService);

        // then
        verify(scoreboardService, times(1)).updateScore(gameIdCaptor.capture(),
                homeTeamScoreCaptor.capture(), awayTeamScoreCaptor.capture());
        assertEquals(1, gameIdCaptor.getValue());
        assertEquals(2, homeTeamScoreCaptor.getValue());
        assertEquals(3, awayTeamScoreCaptor.getValue());
        assertEquals("Score updated", result);
    };
}
