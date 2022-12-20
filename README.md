# Scoreboard
Simple interview assignment
## Technologies
* Java 11
* Maven
* Lombok
* JUnit
* Mockito
## How does it work?
To run and test project:
* clone repository
* build with maven to fetch necessary libraries - mvn clean install
* go to the output directory (/target) and run from command line:
```
java -jar .\Scoreboard-1.0.jar
```
Alternatively just open project with your favourite IDE and run as Java.
##Command
Following commands are available:
* *help* - displays help
* *start|X|Y* - X and Y are Strings. Starts a game between X and Y. Displays gameId.
* *update|I|A|B* - I, A, B are Integers. Updates score of the game with id==I. Sets A as a home team score and B as a away team score.
* *finish|I* - I is an Integer. Removes game with given id from the scoreboard.
* *summary* - displays scoreboard summary.
* *terminate* - terminates program.

## Assumptions
Following assumptions has been made:
* One team can play multiple games at the same time. Games: A vs. B and B vs. A are different games. It could be easily changed with modification of the Scoreboard.findExistingGame() method.
* Application has only one "BusinessException". It could also be extended.
* Tests do not cover really simple methods.
* Update can change score to lower.
* Team names are case sensitive.
