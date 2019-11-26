package game;
import city.cs.engine.*;
/** Creates the third level platforms */

public class PlatformShip extends StaticBody{

        private static final Shape shape = new PolygonShape( -5.2f,-3.4f, 4.48f,0.32f, 2.6f,1.38f, 0.64f,1.68f, -1.96f,0.88f, -5.16f,-3.14f);
        private static final BodyImage image = new BodyImage("data/lvl3plat.png", 16f);


        public PlatformShip(World world){
            super(world, shape);
            addImage(image);
        }

    }


