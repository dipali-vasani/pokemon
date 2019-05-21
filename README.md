# Pokemon
This is simple Java command line application for Pokemon Fight Game inspired by most famous pokemon show and the latest movie.

## Build & Run

You can Run from any IDE, Main class is `com.pokemon.Application.java`

or also from commandline, go to root of project and execute following commands

`mvn clean install`

`java -jar target/pokemon-0.0.1-SNAPSHOT.jar`

For code coverage and code quality

`mvn clean test`

`mvn sonar:sonar`


## Game Guide and Rules

1.	You need to create a Trainer (Trainer name must be in characters).

2.  You will be prompted to select one pokemon from preloaded pokemon list.

3.	If the Trainer (case insensitive) already exits into the storage, it will resume from last saved state.

4.	There are 3 preloaded Levels. For Each level, pokemon has different type of attacks available.

5.  Pokemons are initially assigned 200 points to fight to Opponent Pokemons.

6.	The game starts with 1st level mentioned in `application.properties`. 

7.  You can use “explore” option to see your trainer profile at any level of the game. It will show number of fights, Level and your pokemon attacks and list of opponent pokemons.

8.	When you choose to “Fight”:

    a. At start of each fight, a list of available attacks and the corresponding number to choose for the attack will be displayed.

    b. When you select an attack, your opponent also selects one(random attack) and points will be calculated based on both attack points(your attack points-opponent attack points).

    c. Application will validate your attacks and calculate your points and “display” your total points.

    d. If your total points reaches 0, Game will be Over and Terminated

    e. If not, you are ready to fight other opponent pokemon.

9. As we are not using any databases, you will not be able to save game in one system and replay it in other.

10. If you want to save a game at any point of time, you can use the "Save" option from the main menu.  You can resume, by choosing your Trainer name from the “Create a Trainer" option. Also, ensure, you are on same machine, as we don't have any connections database or clouds. 

11.	The levels and the points configuration is placed in `application.properties` file and can be modified easily.

## Assumptions

1. For making the fight simple:

    a. Opponent pokemon points or level does not increase, if they attack you
  
    b. If both pokemon uses attack with same points, that is counted as 0 and your points will not increase or decrease.
    
2. Your Trainer's Pokemon will always win and after winning fighting will all available opponents, it will never fight. 
