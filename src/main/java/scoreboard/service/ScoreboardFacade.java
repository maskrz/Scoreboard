package scoreboard.service;

import scoreboard.command.Command;

public class ScoreboardFacade {

    ScoreboardService scoreboardService;

    public ScoreboardFacade() {
        // normally DI framework would do the job
        this.scoreboardService = new ScoreboardService();
    }

    public String executeCommand(Command command) {
        return command.execute(scoreboardService);
    }
}
