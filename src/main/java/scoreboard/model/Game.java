package scoreboard.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import scoreboard.utils.DateTimeUtils;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Game implements Comparable<Game> {

    private Integer id;
    private String homeTeam;
    private String awayTeam;
    private Integer homeScore;
    private Integer awayScore;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.created = DateTimeUtils.getCurrentDateTime();
    }

    @Override
    public int compareTo(Game other) {
        int diff = other.getHomeScore() + other.getAwayScore() - homeScore - awayScore;
        return diff != 0 ? diff : other.getCreated().compareTo(created);
    }
}
