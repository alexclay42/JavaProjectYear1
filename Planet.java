package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/** Creates the planets for the scoring
 */
public class Planet extends StaticBody {
    private static final Shape shape = new CircleShape(0.8f);

    private static final BodyImage image =
            new BodyImage("data/Planet1.gif", 1.6f);

    public Planet(World world) {
        super(world, shape);
        addImage(image);
    }
}
