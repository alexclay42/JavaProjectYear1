package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 *Falling asteroid in the first level, adds to player health
 */

public class PowerUp extends DynamicBody{

    private static final Shape shape = new PolygonShape(-0.761f,0.758f, -0.348f,0.744f, -0.085f,0.232f, -0.462f,-0.422f, -0.932f,-0.451f, -1.223f,0.239f, -0.804f,0.737f);

    private static final BodyImage image =
            new BodyImage("data/asteroid.gif", 2f);

    public PowerUp(World world) {
        super(world, shape);
        addImage(image);
    }

}
