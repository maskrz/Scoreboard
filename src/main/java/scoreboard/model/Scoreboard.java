package scoreboard.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Scoreboard {

    private List<Game> games;
    private boolean isSorted;
    private int currentId;

    public Scoreboard() {
        this.games = new ArrayList<>();
        currentId = 1;
        isSorted = true;
    }

    public int addGame(Game game) {
        int id = currentId++;
        game.setId(id);
        games.add(game);
        isSorted = false;
        return id;
    }

    public Game findExistingGame(Game game) {
        return games.stream()
                .filter(g ->
                        (g.getAwayTeam().equals(game.getAwayTeam()) && g.getHomeTeam().equals(game.getHomeTeam()))
                || (g.getAwayTeam().equals(game.getHomeTeam()) && g.getHomeTeam().equals(game.getAwayTeam())))
                .findFirst().orElse(null);
    }

    public Game findExistingGame(int gameId) {
        return games.stream().filter(g -> g.getId() == gameId).findFirst().orElse(null);
    }

    public boolean removeGame(Game game) {
        games.remove(game);
        return true;
    }

    public void updateScore(Game game) {
        // nothing just mark scoreboard unsorted
        this.isSorted = false;
    }

    public void sort() {
        games.sort(Game::compareTo);
        this.isSorted = true;
    }

    public List<Game> getAll() {
        return this.games;
    }
}
