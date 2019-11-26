package game;

import city.cs.engine.*;

import java.awt.*;

/** Creates a specialized view that places text on screen
 * Used in Instructions, Main Menu, and End screens
 */

public class EndText extends UserView {
    private Game game;

    public EndText(World world, Game game, int x, int y) {
        super(world, x, y);
        this.game = game;
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.green);
        if (game.getLevel() == 5) {


            g.drawString("Planets Found: " + game.getPlanetCount() + "/14 = " + game.getPlanetCount() * 15, 200, 200);
            g.drawString("Health: " + game.playerHealth + " = " + game.getPlayerHealth() * 5, 200, 250);
            g.drawString("Ship Parts Found: " + game.getShipParts() + " = " + game.getShipParts() * 10, 200, 300);
            g.drawString("Total Score = " + (game.getPlanetCount() * 15 + game.getPlayerHealth() * 5 + game.getPlanetCount() * 10), 200, 350);


        } else if (game.getLevel() == 0) {
            g.drawString("Welcome to the Adventures of Orange:", 135, 250);
            g.drawString("The Blue Robot", 195, 300);
        } else if (game.getLevel() == 6) {
            g.drawString("Controls: WASD and Click to fire laser", 135, 200);
            g.drawString("To progress between levels:", 150, 250);
            g.drawString("collect the ship part in levels 1,3, and 4", 135, 300);

        }

    }
}


