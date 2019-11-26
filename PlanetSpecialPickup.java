package game;


import city.cs.engine.*;

/**
 * Collision listener for when player collides with 'special planet'd
 */
public class PlanetSpecialPickup implements CollisionListener {
    //  private Robot player;
    private Game game;

    public PlanetSpecialPickup(Game game) {
        this.game = game;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == game.getPlayer()) {
            for (int i = 0; i < 5; i++) {
                game.incrementPlanetCount();

            }
            game.incrementPlayerHealth();
            e.getReportingBody().destroy();
        }

    }

}

