package game;

import city.cs.engine.*;
public class BlockSmall extends DynamicBody {
    //Creates the movable blocks in level 2
    private static final Shape shape = new PolygonShape(-3.01f,2.38f, -1.01f,1.94f, -0.66f,-0.67f, -0.99f,-2.69f, -3.12f,-2.9f, -3.62f,0.1f, -3.12f,2.34f);
    private static final BodyImage image = new BodyImage("data/iu-10.png", 8f);


    public BlockSmall(World world){
        super(world, shape);
        addImage(image);
    }



}
