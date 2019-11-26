package game;

import city.cs.engine.*;

/** Creates the body for the large block on level 3, and in the end screen
 *
 */

public class FriendlyNPC extends StaticBody  {
    private Game game;
    private static final Shape shape = new PolygonShape(0.23f,2.83f, 1.89f,1.08f, 1.96f,-2.32f, -1.86f,-2.29f, -1.94f,1.86f, 0.04f,2.81f);
    private static final BodyImage image = new BodyImage("data/soup.gif", 6f);

    public FriendlyNPC(Game game, World world){
        super(world, shape);
        this.game = game;
        addImage(image);
    }




}
