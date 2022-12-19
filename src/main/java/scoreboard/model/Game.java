package scoreboard.model;

import java.time.LocalDateTime;

public class Game {

    Integer id;
    String homeTeam;
    String awayTeam;
    Integer homeScore;
    Integer awayScore;
    LocalDateTime created;
    LocalDateTime updated;
}
