package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/** Controls the reaction of the robot block on level 3
 * if player has under 5 planets, will prompt with image to collect more
 * will disappear upon contact with player if planetCount >= 5
 */


public class FriendlyNPCHandler implements CollisionListener {
    private Game game;
    private Level3 level;
    private GameLevel world;

    public FriendlyNPCHandler(Game game, Level3 level, GameLevel world) {
        this.game = game;
        this.level = level;
        this.world = world;
    }

    private static final BodyImage image1 =
            new BodyImage("data/Failtext.png", 4f);

    @Override
    public void collide(CollisionEvent e) {

        Body shipImage = new StaticBody(level);
        shipImage.setPosition(new Vec2(9f, -6f));
        if ((e.getOtherBody() == game.getPlayer()) && (game.getPlanetCount() < 5)) {

            shipImage.addImage(image1);
            System.out.println("fail");

        } else if ((e.getOtherBody() == game.getPlayer()) && (game.getPlanetCount() >= 5)) {
            System.out.println("pass");
            e.getReportingBody().destroy();
            shipImage.destroy();
        }

        System.out.println("pass");
    }

}






