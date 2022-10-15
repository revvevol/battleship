package battleship;

import battleship.util.Answer;

/**
 * A Cell represents cells occupied or not by ships and provides
 * A cell is initially empty. But it can be occupied by a single ship (getShip()
 * method).
 * We are able to place a boat on a cell (setShip() method).
 * The attacker can "shoot" on a cell: shot() method
 */

public class Cell {
    /** ship that occupy a cell */
    private Ship ship;
    /** shot bool represents if cell was shot or not */
    private boolean shot;

    /**
     * creates a cell , which is initially not touched
     * 
     */
    public Cell() {
        this.shot = false;
    }

    /**
     * verify if cell was shot or not
     * 
     * @return the shot boolean
     */
    public boolean hasBeenShot() {
        return this.shot;
    }

    /**
     * sets ship object to current cell
     * 
     * @param ship which occupy cell
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * return ship object of current cell
     * 
     * @return ship occupy cell
     */
    public Ship getShip() {
        return this.ship;
    }

    /**
     * verify whether cell is empty
     * 
     * @return <code>true</code> if is empty else <code>false</code>
     */
    public boolean isEmpty() {
        return this.ship == null;
    }

    /**
     * attack on current cell
     * if cell is empty or have already been shot returns MISSED
     * else ship is getting hitted
     * if ship life points become 0 returns SUNK
     * else returns HIT
     * 
     * @return SUNK|HIT|MISSED
     */
    public Answer shot() {
        if (this.getShip() == null || this.hasBeenShot()) {
            this.shot = true;
            return Answer.MiSSED;
        }

        this.ship.beenHitting();
        this.shot = true;
        if (this.ship.hasBeenSunk()) {
            return Answer.SUNK;
        } else {
            return Answer.HIT;
        }
    }

    /**
     * convert status of current cell to character
     * of a defender perspective we see all cells
     * of a attack perspective we see only touched cells
     * 
     * @param defender status of player
     * 
     * @return cell character
     */
    public char toCharacter(boolean defender) {
        char c = 'i';

        if (defender) {
            if (this.isEmpty()) {
                c = '~';
            } else if (this.getShip() != null && this.shot == false) {
                c = 'B';
            } else if (this.getShip() != null && this.shot == true) {
                c = '*';
            }
        } else {
            if (this.shot == false) {
                c = '.';
            } else if (this.shot == true && this.getShip() == null) {
                c = '~';
            } else if (this.shot == true && this.getShip() != null) {
                c = '*';
            }
        }
        return c;
    }
}
