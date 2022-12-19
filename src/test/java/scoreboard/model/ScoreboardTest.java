package scoreboard.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreboardTest {

    Scoreboard scoreboard;

    @BeforeEach
    void setUp() {
        this.scoreboard = new Scoreboard();
    }

    @Test
    void shouldAddGames() {
        Game g1 = new Game("Poland", "USA");
        Game g2 = new Game("UK", "France");
        int g1Id = scoreboard.addGame(g1);
        assertEquals(1, g1Id);
        assertEquals(1, g1.getId());
        int g2Id = scoreboard.addGame(g2);
        assertEquals(2, g2Id);
        assertEquals(2, g2.getId());
        assertFalse(scoreboard.isSorted());
    }

    @ParameterizedTest(name = "{index} => game={0}, expected existence={1}")
    @MethodSource("gamesProvider")
    void shouldFindExistingGames(Game game, boolean gameExists) {
        Game g1 = new Game("Poland", "USA");
        scoreboard.addGame(g1);
        Game foundGame = scoreboard.findExistingGame(game);
        assertEquals(gameExists, foundGame != null);
    }

    @Test
    void shouldFindExistingGameById() {
        Game g1 = new Game("Poland", "USA");
        scoreboard.addGame(g1);
        assertNull(scoreboard.findExistingGame(2));
        assertEquals(g1, scoreboard.findExistingGame(1));
    }

    private static Stream<Arguments> gamesProvider() {
        return Stream.of(
                Arguments.of(new Game("Poland", "USA"), true),
                Arguments.of(new Game("Poland", "France"), false),
                Arguments.of(new Game("UK", "France"), false)
        );
    }
}
