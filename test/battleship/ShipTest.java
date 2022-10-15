package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

import battleship.util.Answer;

public class ShipTest {

    @Test
    public void decreaseLifePointsWhenHit() {
        Ship ship = new Ship(2);
        Cell cell = new Cell();
        cell.setShip(ship);
        assertEquals(2, ship.getLifePoints());
        Answer answer = cell.shot();
        assertEquals(1, ship.getLifePoints());
        assertEquals(answer, Answer.HIT);
    }

    @Test
    public void isSunk() {
        Ship ship = new Ship(1);
        Cell cell = new Cell();
        cell.setShip(ship);
        assertFalse(ship.hasBeenSunk());
        Answer answer = cell.shot();
        assertTrue(ship.hasBeenSunk());
        assertEquals(answer, Answer.SUNK);
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(battleship.ShipTest.class);
    }
}
