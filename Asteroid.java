
package game;

import city.cs.engine.*;

/** Creates the falling asteroid in level 3
 *
 */

public class Asteroid extends DynamicBody {

    private static final Shape shape = new PolygonShape(-3.54f,-0.5f, -2.07f,-0.16f, -1.2f,-0.68f, -1.41f,-1.63f, -2.73f,-2.54f, -3.72f,-1.93f, -3.61f,-0.66f);

    private static final BodyImage image = new BodyImage("data/lvl3ast.png",8f);

    public Asteroid (World world){
        super(world, shape);
        addImage(image);
    }

}
