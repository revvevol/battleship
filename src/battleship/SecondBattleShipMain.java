package battleship;

import battleship.util.Position;

public class SecondBattleShipMain {
    public static void main(String[] args) {
        Sea sea = new Sea(10, 10);
      
        Ship ship1 = new Ship(3);
        Ship ship2 = new Ship(3);

        sea.addShip(ship1, new Position(5, 6), 0, 3);

        sea.addShip(ship2, new Position(7, 5), 3, 0);


        sea.display(true);

        Game game = new Game(sea);
        game.play();
    }
}
