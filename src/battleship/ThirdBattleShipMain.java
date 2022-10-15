package battleship;

import java.util.concurrent.ThreadLocalRandom;

import battleship.util.Position;

public class ThirdBattleShipMain {
    public static void main(String[] args) {
        Sea sea = new Sea(10, 10);

        for (int i = 0; i < 10; i++) {
            int randomLength = ThreadLocalRandom.current().nextInt(1, 4);
            int randomX = ThreadLocalRandom.current().nextInt(0, 9);
            int randomY = ThreadLocalRandom.current().nextInt(0, 9);

            Ship ship1 = new Ship(randomLength);
            Ship ship2 = new Ship(randomLength);

            sea.addShip(ship1, new Position(randomX, randomY), randomLength, 0);
            sea.addShip(ship2, new Position(randomX, randomY), 0, randomLength);
        }

        sea.display(true);

        Game game = new Game(sea);
        game.play();
    }
}
