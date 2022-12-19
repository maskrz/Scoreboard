package scoreboard;

import scoreboard.command.Command;
import scoreboard.command.CommandFactory;
import scoreboard.exception.TerminateException;

import java.util.Scanner;

public class ScoreboardRunner {

    public static void main(String[] args) {
        System.out.println("Scoreboard initialized");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input an action. Type \"help\" for help.");
        try {
            while (true) {
                String stringCommand = scanner.nextLine();
                Command command = CommandFactory.createCommand(stringCommand);
                System.out.println(command.execute());
            }
        } catch (TerminateException ex) {
            System.exit(0);
        } catch (Exception ex) {
            System.out.println("Something unexpected has just happened.");
        }
    }
}
