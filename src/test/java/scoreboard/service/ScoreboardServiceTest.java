package scoreboard.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scoreboard.model.Game;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class ScoreboardServiceTest {

    private ScoreboardService scoreboardService;

    @BeforeEach
    void setUp() {
        this.scoreboardService = new ScoreboardService();
    }

    @Test
    void shouldNotFinishGameIfNotFound() {
        // given
        ScoreboardManager scoreboardManager = Mockito.mock(ScoreboardManager.class);
        scoreboardService.setScoreboardManager(scoreboardManager);

        // when
        when(scoreboardManager.getGameById(anyInt())).thenReturn(Optional.ofNullable(null));

        // then
        assertFalse(scoreboardService.finishGame(1));
    }

    @Test
    void shouldNotFinishGameIfFound() {
        // given
        ScoreboardManager scoreboardManager = Mockito.mock(ScoreboardManager.class);
        scoreboardService.setScoreboardManager(scoreboardManager);

        // when
        when(scoreboardManager.getGameById(anyInt())).thenReturn(Optional.of(new Game("", "")));
        when(scoreboardManager.finishGame(any())).thenReturn(true);

        // then
        assertTrue(scoreboardService.finishGame(1));
    }
}
