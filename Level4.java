package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/** Level 4 of the game
 * player reaching end after collecting all ship pieces
 */
public class Level4 extends GameLevel {

    private Game game;

    public Level4(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    private static final BodyImage image =
            new BodyImage("data/iu-1.gif", 26f);
    private static final BodyImage image1 =
            new BodyImage("data/Ship1.gif", 1f);

    @Override
    public void populate(Game game) {
        super.populate(game);

        Body background = new StaticBody(this);
        background.setPosition(new Vec2(0, 0));
        background.setAngleDegrees(90);
        background.addImage(image);

        Shape groundShape = new BoxShape(1.75f, .305f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-11, -9.5f));

        Body plat2 = new StaticBody(this, groundShape);
        plat2.setPosition(new Vec2(0, -12.5f));

        Shape ceiling = new BoxShape(14, .605f);
        Body ceiling1 = new StaticBody(this, ceiling);
        ceiling1.setPosition(new Vec2(0, -15.5f));
        Body ceiling2 = new StaticBody(this, ceiling);
        ceiling2.setPosition(new Vec2(0, 15.5f));

        //ground.addImage(image2);
        // walls
        Shape wall = new BoxShape(.5f, 40f);
        Body wall1 = new StaticBody(this, wall);
        Body wall2 = new StaticBody(this, wall);
        wall1.setPosition(new Vec2(-13f, 0));
        wall2.setPosition(new Vec2(13f, 0));


        //adding in last ship part
        Body part3 = new ShipPart(this);
        part3.setPosition(new Vec2(0, -10.6f));
        part3.addCollisionListener(new ShipPickup(game, this));


        //AMC adding in the ship picture indicators
        Body shipImage = new StaticBody(this);
        shipImage.setPosition(new Vec2(-11.5f, 11.5f));
        shipImage.addImage(image1);

        Body shipImage2 = new StaticBody(this);
        shipImage2.setPosition(new Vec2(-10.5f, 11.5f));
        shipImage2.addImage(image1);


    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(-11, -9.4f);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(0f, 11f);
    }

    @Override
    public Vec2 enemyPosition() {
        return new Vec2(-100.4f, -9.6f);

    }

    @Override
    public boolean isCompleted() {
        return (game.getShipParts() == 3);
    }
}



