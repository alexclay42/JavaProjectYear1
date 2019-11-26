package game;

import city.cs.engine.*;
/** Creates the body for the enemy in the first level */

public class Enemy extends Walker {

    private static final Shape shape = new CircleShape(1f);
    private  BodyImage image =
            new BodyImage("data/enemy.gif", 8f);

    public Enemy(World world) {
        super(world, shape);
        addImage(image);
        setGravityScale(0);
    }
}
