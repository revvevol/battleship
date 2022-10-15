package battleship;

import battleship.util.Answer;
import battleship.util.Letter;
import battleship.util.Position;
import io.Input;

/**
 * A Game represents a main game file through which we launch a game
 * play function starts game loop and uses inputPosition function to
 * get users input
 */

public class Game {
    /** sea instance (game map) */
    private Sea sea;

    /**
     * builds game object with sea provided as param
     * 
     * @param sea game map
     */
    public Game(Sea sea) {
        this.sea = sea;
    }

    /**
     * launch game ,
     * until life points greater then 0 display game map from defender
     * point of view
     * ask for user input and shoot at provided position
     * when life points reaches 0 game has finished
     */
    public void play() {
        while (sea.getRemainingLifePoints() != 0) {
            sea.display(false);
            Position position;
            try {
                position = this.inputPosition();
                Answer ans = sea.shoot(position);
                System.out.println(ans);
            } catch (Exception e) {
            }

        }
        sea.display(false);
    }

    /**
     * return this sea
     * 
     * @return sea
     */
    public Sea getSea() {
        return this.sea;
    }

    /**
     * asks for user input coordinates under the (C4) form
     * any other input will be ignored
     * 
     * @return
     * @throws Exception
     */
    private Position inputPosition() throws Exception {
        System.out.println("Enter coordinates for an attack");
        int x, y;
        try {
            String userString = Input.readString();

            Letter letter = Letter.valueOf(userString.substring(0, 1));
            y = letter.getLetterCode();
            x = Integer.parseInt(userString.substring(1, 2));

        } catch (IllegalArgumentException e) {
            throw new Exception();
        }

        return new Position(x, y);

    }
}
