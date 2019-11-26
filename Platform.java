

package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;
/** Creates the platforms for the first level */


public class Platform extends StaticBody{

    private static final Shape shape = new PolygonShape(-3.34f,0.71f, -1.71f,1.42f, 2.2f,0.63f, 3.21f,-0.25f, 3.11f,-0.66f, 1.22f,-1.2f, -2.97f,-0.45f, -3.38f,0.59f);
    private static final BodyImage image = new BodyImage("data/iu-6.gif", 4f);


    public Platform(World world){
        super(world, shape);
        addImage(image);
    }

}
