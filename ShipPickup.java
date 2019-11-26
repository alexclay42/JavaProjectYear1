

package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

/** Collision listener for when the player picks up the ship part
 * adds small image to top left corner as indicator when collected
 */
public class ShipPickup implements CollisionListener {

    private Game game;
    private GameLevel world;

    public ShipPickup(Game game, GameLevel world) {
        this.game = game;

        this.world = world;
    }

    private static final BodyImage image1 =
            new BodyImage("data/Ship1.gif", 1f);

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == game.getPlayer()) {
            game.incrementShipParts();
            e.getReportingBody().destroy();

            if (game.getShipParts() == 1) {
                Body shipImage = new StaticBody(world);
                shipImage.setPosition(new Vec2(-11.5f, 11.5f));
                shipImage.addImage(image1);
            } else if (game.getShipParts() == 2) {
                Body shipImage = new StaticBody(world);
                shipImage.setPosition(new Vec2(-10.5f, 11.5f));
                shipImage.addImage(image1);
            } else if (game.getShipParts() == 3) {
                Body shipImage = new StaticBody(world);
                shipImage.setPosition(new Vec2(-9.5f, 11.5f));
                shipImage.addImage(image1);
                world.player.gotAllShipParts();

            }


        }

    }
}


