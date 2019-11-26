
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.Random;

/**Adds a collision listener and random spawning effect to the asteroid in level 3
 *
 */


public class AsteroidHandler implements CollisionListener {

    private Game game;
    private Level3 world;

    public AsteroidHandler(Game game, Level3 world) {
        this.game = game;
        this.world = world;
    }

    Random x = new Random();
    float y;

    /** Decreases player health on impact, and destroys asteroid on collision with another body
     * Uses variable y to control the random generation of the asteroid on the x axis
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == game.getPlayer()) {
            game.decrementPlayerHealth();
        }


        if (x.nextFloat() >= .5) {
            y = x.nextFloat() * 10;
        } else if (x.nextFloat() <= .5) {
            y = x.nextFloat() * -10;
        } else {
            y = x.nextFloat() * 12;
        }
        e.getReportingBody().destroy();
        Asteroid asteroid = new Asteroid(world);
        asteroid.setPosition(new Vec2(y, 10));
        asteroid.addCollisionListener(new AsteroidHandler(game, world));
        System.out.println("asteroid hit " + y);

    }


}
