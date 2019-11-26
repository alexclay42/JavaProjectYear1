package game;

import city.cs.engine.*;

/** Destroys laser on hitting another body
 * if the other body is the enemy, it also destroys it
 */
public class LaserHandler implements CollisionListener {
    private WorldView view;
    private GameLevel world;

    private Game game;


    public LaserHandler(GameLevel world, Game game) {
        this.world = world;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() != game.getPlayer()) {

            if (e.getOtherBody() == game.getEnemy()) {
                e.getOtherBody().destroy();
            }
            System.out.println("laser hit ");
            e.getReportingBody().destroy();


        }
    }
}
