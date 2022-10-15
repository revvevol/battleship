package battleship;

import battleship.util.Position;

public class FirstBattleShipMain {
    public static void main(String[] args) {
        Sea sea = new Sea(10, 10);

        Ship ship1 = new Ship(3);
        Ship ship2 = new Ship(2);

        sea.addShip(ship1, new Position(2, 3), 3, 0);

        sea.addShip(ship2, new Position(6, 2), 0, 2);

        sea.display(true);
        sea.display(false);

        sea.shoot(new Position(6, 2));

        sea.display(true);
        sea.display(false);
    }
}
