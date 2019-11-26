
package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the robot to collect the planets
 */
public class PlanetPickup implements CollisionListener {
    //  private Robot player;
    private Game game;

    public PlanetPickup(Game game) {
        this.game = game;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == game.getPlayer()) {
            game.incrementPlanetCount();
            e.getReportingBody().destroy();
        }

    }

}
