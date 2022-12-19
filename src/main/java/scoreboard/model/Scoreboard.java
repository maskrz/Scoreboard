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
        return games.stream().filter(g -> g.getAwayTeam().equals(game.getAwayTeam()) && g.getHomeTeam().equals(game.getHomeTeam())).findFirst().orElse(null);
    }
}
