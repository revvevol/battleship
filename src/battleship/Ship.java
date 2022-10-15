package battleship;

/**
 * The Ship class is used to represent boats. A boat object is defined by its
 * length. The length
 * of a boat determines its number of "life points" and is fixed at creation.
 * When touched (method
 * beenHitting()), this number decreases. A boat is sunk when its number of life
 * points reaches 0 (the method
 * hasBeenSunk() lets you know if this is the case or not).
 *
 */
public class Ship {

    /* ship life points attribute */
    private int lifePoints;

    /**
     * creates a ship of given length
     * 
     * @param length the length (lifePoints)
     */
    public Ship(int length) {
        this.lifePoints = length;
    }

    /**
     * verify if ship life points all gone, if so a ship has been sunk
     * 
     * @return the <code>true</code> if sunk , <code>false</code> if its not
     */
    public boolean hasBeenSunk() {
        if (this.lifePoints == 0) {
            return true;
        }

        return false;
    }

    /**
     * decrease ship life points if its hitted
     * 
     */
    public void beenHitting() {
        this.lifePoints--;
    }

    /**
     * @return ship life points
     */
    public int getLifePoints() {
        return this.lifePoints;
    }

    /**
     * @return ship description
     */
    public String toString() {
        return "This ship have " + this.lifePoints + " life point left";
    }
}