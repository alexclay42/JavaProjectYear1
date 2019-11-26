package game;

import city.cs.engine.*;

/**
 * Doors in a game. When the actor collides with a door, if
 * the current level is complete the game is advanced to the
 * next level.
 */
public class Door extends StaticBody {
    private Game game;

    /**
     * Initialise a new door.
     *
     * @param world The world.
     */
    public Door(World world, Game game) {
        super(world, new PolygonShape(0.74f, 0.61f, 1.2f, -1.42f, -0.11f, -1.79f, -1.46f, 0.66f, -1.3f, 1.55f, -0.19f, 1.79f, 0.7f, 0.7f));
        this.game = game;
        addImage(new BodyImage("data/iu-12.png", 4f));
        if (game.getLevel() >= 3) {
            setAngleDegrees(180);
        }

    }
}
