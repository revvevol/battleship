package battleship;

import java.util.ArrayList;

import battleship.util.Answer;
import battleship.util.Position;

/**
 * A Sea represents a game map (2d array of cells)
 * here we test if a ship can be placed and if so we place them in cells
 * shoot function provide shooting functionality 
 * and display function displays game map
 */

public class Sea {
    /** cells 2d array (game map) */
    private Cell[][] array;
    /** summary life points of all ships (game points) */
    private int fullLifePoints;

    /**
     * builds 2dimensional array of empty cells and 0 life points
     * 
     * @param x
     * @param y
     */
    public Sea(int x, int y) {
        this.array = new Cell[x][y];
        this.fullLifePoints = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.array[i][j] = new Cell();
            }
        }
    }

    /**
     * add the ship b to this game’s sea. Ship is added in any direction from
     * position p.
     * The number of cells is determined by the ship life points.
     * 
     * @param shipToPlace the ship to add
     * @param position    the position of the first (top) cell occupied by the ship
     * @param dx          the direction of ship to be placed , dx -> vertically
     * @param dy          the direction of ship to be placed , dy -> horizontally
     * @throws IllegalStateException if the ship b can not be placed on the sea
     *                               (ship goes outside of the sea or some cell is
     *                               not empty)
     */
    public void addShip(Ship shipToPlace, Position position, int dx, int dy) throws IllegalStateException {
        boolean success = false;

        try {
            testIfShipCanBePlaced(shipToPlace, position, dx, dy);
            success = true;
        } catch (IllegalStateException e) {

        }

        if (success) {
            for (int i = 0; i < shipToPlace.getLifePoints(); i++) {
                if (dx > 0)
                    dx--;
                if (dy > 0)
                    dy--;

                int px = position.getX() + dx;
                int py = position.getY() + dy;

                this.array[px][py].setShip(shipToPlace);

            }
            fullLifePoints += shipToPlace.getLifePoints();
        }

    }

    /**
     * tests if ship can be placed using provided position, two ships cannot be
     * placed
     * as a neighbours, there should be distance in 1 cell in any directions,
     * aslo cells should be empty
     * 
     * @param shipToPlace the ship to add
     * @param position    the position of the first (top) cell occupied by the ship
     * @param dx          the direction of ship to be placed , dx -> vertically
     * @param dy          the direction of ship to be placed , dy -> horizontally
     * @throws IllegalStateException if the ship b can not be placed on the sea
     *                               (ship goes outside of the sea or some cell is
     *                               not empty)
     */
    private void testIfShipCanBePlaced(Ship shipToPlace, Position position, int dx, int dy)
            throws IllegalStateException {

        ArrayList<Position> cells = new ArrayList<Position>();

        for (int i = 0; i < shipToPlace.getLifePoints(); i++) {
            if (dx > 0)
                dx--;
            if (dy > 0)
                dy--;

            int px = position.getX() + dx;
            int py = position.getY() + dy;

            if (px >= this.array[0].length || py >= this.array[1].length || this.array[px][py].isEmpty() == false) {
                throw new IllegalStateException();
            }

            Position[] expectedCells = {
                    new Position(px + 1, py),
                    new Position(px - 1, py),
                    new Position(px, py + 1),
                    new Position(px, py - 1),
                    new Position(px + 1, py + 1),
                    new Position(px - 1, py - 1),
                    new Position(px + 1, py - 1),
                    new Position(px - 1, py + 1),

            };

            ArrayList<Position> suitableCells = new ArrayList<Position>();

            for (int j = 0; j < expectedCells.length; j++) {
                if (expectedCells[j].getX() >= 0 && expectedCells[j].getY() >= 0
                        && expectedCells[j].getX() < this.array[0].length &&
                        expectedCells[j].getY() < this.array[1].length) {
                    suitableCells.add(expectedCells[j]);
                }
            }

            for (int j = 0; j < suitableCells.size(); j++) {
                if (!cells.contains(suitableCells.get(j))) {
                    cells.add(suitableCells.get(j));
                }
            }
        }

        for (int j = 0; j < cells.size(); j++) {
            if (this.array[cells.get(j).getX()][cells.get(j).getY()].isEmpty() == false) {
                throw new IllegalStateException();
            }
        }

    }

    /**
     * shoot on provided cell position and decrease life points if hit or sunk
     * 
     * @param p position
     * @return ans SUNK|MISSED|HIT
     */
    public Answer shoot(Position p) {
        Answer ans = this.array[p.getX()][p.getY()].shot();
        if (ans == Answer.HIT || ans == Answer.SUNK) {
            this.fullLifePoints--;
        }
        return ans;
    }

    public int getRemainingLifePoints() {
        return this.fullLifePoints;
    }

    /**
     * display the game board line by line and cell by cell, on standard output,
     * the display is different for the defender or the attacker, according to
     * parameter
     * 
     * @param defender true iff display is for defender, false if for opponent
     */
    public void display(boolean defender) {
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < this.array.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < this.array[i].length; j++) {
                System.out.print(this.array[i][j].toCharacter(defender) + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
