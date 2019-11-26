package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/** Handles when the enemy collides with another body
 * Decreases player health by one
 * enemy destroyed if hit with laser
 */

public class EnemyHandler implements CollisionListener {
    private Laser laser;
    private Game game;
    public EnemyHandler(Laser laser, Game game){this.laser = laser; this.game = game;}

    @Override
    public void collide(CollisionEvent e){
        if(e.getOtherBody() == laser){
            e.getReportingBody().destroy();

        }
        else if (e.getOtherBody() == game.getPlayer()){
            game.decrementPlayerHealth();
        }

        System.out.println("enemy collided");

    }

}
