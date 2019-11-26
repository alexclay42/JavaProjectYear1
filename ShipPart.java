
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

import city.cs.engine.Body;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
/** Creates the ship part for each completing each level */
public class ShipPart extends DynamicBody {
    private static final Shape shape = new PolygonShape(-2.73f, -1.33f, -1.73f, -0.12f, 0.38f, 0.54f, 1.59f, 0.65f, 1.76f, 0.25f, -0.57f, -1.3f, -2.5f, -1.34f);

    private static final BodyImage image =
            new BodyImage("data/Ship1.gif", 4f);

    public ShipPart(World world) {
        super(world, shape);
        addImage(image);
    }


}