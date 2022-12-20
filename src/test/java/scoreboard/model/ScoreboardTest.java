package scoreboard.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
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

    @Test
    void shouldSortGames() {
        // given
        Game g1 = prepareGame("a", "b", 1, 1, 0);
        Game g2 = prepareGame("c", "d", 2, 5, 1);
        Game g3 = prepareGame("e", "f", 0, 0, 2);
        Game g4 = prepareGame("g", "h", 5, 2, 3);
        Game g5 = prepareGame("i", "j", 1, 1, 4);
        List<Game> games = Arrays.asList(g1, g2, g3, g4, g5);
        scoreboard.getGames().addAll(games);

        // when
        scoreboard.sort();

        // then
        assertEquals(g4, scoreboard.getAll().get(0));
        assertEquals(g2, scoreboard.getAll().get(1));
        assertEquals(g5, scoreboard.getAll().get(2));
        assertEquals(g1, scoreboard.getAll().get(3));
        assertEquals(g3, scoreboard.getAll().get(4));

    }

    private Game prepareGame(String homeName, String awayName, int homeScore, int awayScore, int offset) {
        Game game = new Game(homeName, awayName);
        game.setHomeScore(homeScore);
        game.setAwayScore(awayScore);
        game.setCreated(LocalDateTime.now().plusSeconds(offset));
        return game;
    }

    private static Stream<Arguments> gamesProvider() {
        return Stream.of(
                Arguments.of(new Game("Poland", "USA"), true),
                Arguments.of(new Game("Poland", "France"), false),
                Arguments.of(new Game("UK", "France"), false)
        );
    }
}
