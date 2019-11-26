package game;
import city.cs.engine.*;

import city.cs.engine.StaticBody;

public class BlockLarge extends StaticBody {
    //Creates the static blocks in level 2
    private static final Shape shape = new PolygonShape(-1.14f,6.45f, 0.0f,6.51f, 0.78f,2.49f, 0.36f,-1.9f, -1.2f,-1.96f, -1.74f,2.37f, -1.2f,6.09f);
    private static final BodyImage image = new BodyImage("data/iu-14.png", 20f);



    public BlockLarge(World world){
        super(world, shape);
        addImage(image);
    }
}
