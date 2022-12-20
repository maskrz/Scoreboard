package scoreboard.command;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scoreboard.model.Game;
import scoreboard.service.ScoreboardService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class SummaryCommandTest {

    @Test
    void shouldReturnNoGames() {
        // given
        ScoreboardService scoreboardService = Mockito.mock(ScoreboardService.class);

        // when
        Command command = new SummaryCommand();
        when(scoreboardService.getSummary()).thenReturn(new ArrayList<>());
        String results = command.execute(scoreboardService);

        // then
        assertEquals("No games ongoing", results);
    }

    @Test
    void shouldReturnSummary() {
        // given
        Game g1 = new Game("a", "b");
        g1.setId(1);
        Game g2 = new Game("c", "d");
        g2.setId(2);
        g2.setHomeScore(1);
        g2.setAwayScore(2);
        List<Game> games = Arrays.asList(g1, g2);
        ScoreboardService scoreboardService = Mockito.mock(ScoreboardService.class);

        // when
        Command command = new SummaryCommand();
        when(scoreboardService.getSummary()).thenReturn(games);
        String results = command.execute(scoreboardService);

        // then
        assertTrue(results.startsWith("Summary: "));
        assertTrue(results.contains("1. a 0 - b 0 gameId: 1"));
        assertTrue(results.contains("2. c 1 - d 2 gameId: 2"));
    }
}
