package scoreboard.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scoreboard.exception.BusinessException;
import scoreboard.model.Game;
import scoreboard.model.Scoreboard;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ScoreboardManagerTest {

    private ScoreboardManager scoreboardManager;

    @BeforeEach
    void setUp() {
        this.scoreboardManager = new ScoreboardManager();
    }

    @Test
    void shouldThrowExceptionOnExistingGame() {
        // given
        Scoreboard scoreboard = Mockito.mock(Scoreboard.class);
        scoreboardManager.setScoreboard(scoreboard);

        // when
        when(scoreboard.findExistingGame(any())).thenReturn(new Game("", ""));

        // then
        Exception ex = assertThrows(BusinessException.class, () -> scoreboardManager.addGame(new Game("", "")));
        assertEquals("Game already exists", ex.getLocalizedMessage());
    }

    @Test
    void shouldAddGame() {
        // given
        Scoreboard scoreboard = Mockito.mock(Scoreboard.class);
        scoreboardManager.setScoreboard(scoreboard);

        // when
        when(scoreboard.findExistingGame(any())).thenReturn(null);
        when(scoreboard.addGame(any())).thenReturn(10);

        // then
        assertEquals(10, scoreboardManager.addGame(new Game("", "")));
    }

    @Test
    void shouldUpdateGame() {
        // given
        Scoreboard scoreboard = Mockito.mock(Scoreboard.class);
        scoreboardManager.setScoreboard(scoreboard);
        Game game = new Game("UK", "USA");

        // when
        scoreboardManager.updateScore(game, 1, 3);

        // then
        assertNotNull(game.getUpdated());
        assertEquals(1, game.getHomeScore());
        assertEquals(3, game.getAwayScore());
        verify(scoreboard, times(1)).updateScore(any());
    }
}
