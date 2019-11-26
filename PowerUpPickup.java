
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/** Collision listener for when the player gets the powerup
 *
 */
    public class PowerUpPickup implements CollisionListener{

        private GameLevel world;
        private Game game;
        public PowerUpPickup(GameLevel world, Game game) { this.world = world; this.game = game;}

        @Override
        public void collide(CollisionEvent e) {
            if (e.getOtherBody() == world.player) {
                world.player.gotPowerUp();
                game.incrementPlayerHealth();
                e.getReportingBody().destroy();
            }
            else {
                e.getReportingBody().destroy();
                PowerUp powerUp = new PowerUp(world);
                powerUp.setPosition(new Vec2(-9.5f, 10f));
                powerUp.addCollisionListener(new PowerUpPickup(world, game));
            }

        }

    }

