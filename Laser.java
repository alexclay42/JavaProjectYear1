package game;

import city.cs.engine.*;

/**
 * Creates the body for the laser that is fired on clicking
 */
public class Laser extends Walker {

    private static final Shape laserShape = new PolygonShape(-0.677f,0.051f, -0.432f,0.056f, -0.437f,0.083f, -0.688f,0.083f);

    private static final BodyImage laserImage =
            new BodyImage("data/laser.gif", 2);

    /**
     * Construct a bowling ball.
     * @param world the world in which this body exists.
     */
    public Laser(World world) {
        super(world, laserShape);
        addImage(laserImage);

    }
}
