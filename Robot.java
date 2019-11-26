package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Creates the player character
 */
public class Robot extends Walker {


    private static final Shape shape = new PolygonShape(
            0.149f, 0.975f, 0.775f, 0.193f, 0.772f, -0.099f, 0.401f, -0.928f, -0.36f, -0.922f, -0.719f, -0.025f, -0.725f, 0.163f, -0.14f, 0.972f);

    private BodyImage image =
            new BodyImage("data/playerIdle.gif", 3f);

    private static final BodyImage image3 =
            new BodyImage("data/lvl4end.png", 8f);


    private boolean PowerUp;
    public boolean AllShipParts;

    public Robot(World world) {
        super(world, shape);
        PowerUp = false;
        AllShipParts = false;
        addImage(image);
    }


    public void gotPowerUp() {
        PowerUp = true;
        System.out.println("powerup " + PowerUp);


    }

    public void gotAllShipParts() {
        AllShipParts = true;
        System.out.println("All Ship parts " + AllShipParts);
        addImage(image3);
        setGravityScale(0);

    }

}
