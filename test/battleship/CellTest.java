package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

import battleship.util.Answer;

public class CellTest {

    @Test
    public void cellGettingShotOnce() {
        Ship ship = new Ship(2);
        Cell cell = new Cell();
        cell.setShip(ship);
        assertFalse(cell.hasBeenShot());
        Answer answer = cell.shot();
        assertTrue(cell.hasBeenShot());
    }

    @Test
    public void cannotShotTwoTimesSameCell() {
        Ship ship = new Ship(2);
        Cell cell = new Cell();
        cell.setShip(ship);
        cell.shot();
        Answer answer = cell.shot();
        assertEquals(1, ship.getLifePoints());
        assertEquals(answer, Answer.MiSSED);
    }

    @Test
    public void verifyCellCharacter() {
        Ship ship = new Ship(1);
        Cell cell = new Cell();

        assertEquals('~', cell.toCharacter(true));
        assertEquals('.', cell.toCharacter(false));

        cell.setShip(ship);

        assertEquals('B', cell.toCharacter(true));
        assertEquals('.', cell.toCharacter(false));

        cell.shot();

        assertEquals('*', cell.toCharacter(true));
        assertEquals('*', cell.toCharacter(false));

        Cell cell2 = new Cell();

        cell2.shot();
        assertEquals('~', cell2.toCharacter(false));


    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(battleship.CellTest.class);
    }
}
