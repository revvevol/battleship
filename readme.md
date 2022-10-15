Tests:
javac src/battleship/util/Position.java -d classes

javac -classpath test4poo.jar test/battleship/CellTest.java -d classes

java -jar test4poo.jar battleship.ShipTest

Vladislav Yaromiy

**TP5**

- In this TP5 , we created battleship game
  We can place ships of different (1-3) length on a game map and shoot
  User can miss or hit or sunk a ship, all these actions are displayed
  Game ends when all ships are sunken<br/>

- To generate and conslut documentation:<br/>
  place yourself in **/poo/tp5/**<br/>
  and execute **javadoc -d docs -subpackages [packageName]**<br/>
  example : **javadoc -d docs -subpackages battleship**<br/>
  then folder **docs** will appear and you can find there **index.html** which you need to open in any browser<br/>

- To compile classes:<br/>
  place yourself in **/poo/tp5/**<br/>
  You have to define environnement variable CLASSPATH => **export CLASSPATH="src:classes"** | Else you will need to use **--classpath option**<br/>
  To verify: **echo $CLASSPATH**<br/>
  To compile execute :<br/>
  **javac src/battleship/\*java -d classes**<br/>
  **javac src/tv/\*java -d classes**<br/>
  **javac src/io/\*java -d classes**<br/>
  To compile using classpath option, execute:<br/>
  **javac -classpath src -d classes src/battleship/\*java**<br/>
  **javac -classpath src -d classes src/tv/\*java**<br/>
  **javac -classpath src -d classes src/io/\*java**<br/>

- To compile and run test:<br/>
  place yourself in **/poo/tp5/** <br/>
  I assume you have all classes compiled and classpath variable<br/>
  We compile test classes<br/>
  **javac -classpath test4poo.jar test/battleship/\*java -d classes**<br/>
  **javac -classpath test4poo.jar test/battleship/util/\*java -d classes**<br/>
  To run test<br/>
  **java -jar test4poo.jar [packageName].[testName]**<br/>
  Example<br/>
  **java -jar test4poo.jar battleship.ShipTest**<br/>
  **java -jar test4poo.jar battleship.util.PositionTest**<br/>

- To run a main program:<br/>
  place yourself in **/poo/tp5/**<br/>
  you should have all classes compiled, example above<br/>
  run: **java battleship.[mainClass]**<br/>
  Example : **java battleship.FirstBattleShipMain**
  Example : **java battleship.SecondBattleShipMain**

- To create game jar executable file:<br/>
  1)Create executable :**jar cvfe secondBattleShipMain.jar battleship.SecondBattleShipMain -C classes battleship -C classes io**<br/>
  Execute : **java -jar secondBattleShipMain.jar**<br/>

  2)Create executable :**jar cvfe thirdBattleShipMain.jar battleship.ThirdBattleShipMain -C classes battleship -C classes io**<br/>
  Execute : **java -jar thirdBattleShipMain.jar**<br/>
