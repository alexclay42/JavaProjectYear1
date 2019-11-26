package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {


    private Game game;

    private static final BodyImage image1 =
            new BodyImage("data/Ship1.gif", 1f);
    private static final BodyImage image2 =
            new BodyImage("data/iu-13.png", 3.2f);
    private static final BodyImage image3 =
            new BodyImage("data/iu.png", 22f);
    private static final BodyImage image4 =
            new BodyImage("data/iu-15.png", 2.5f);

    public Level2(Game game) {
        this.game = game;
    }


    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);


        // make the ground
        Shape groundShape = new BoxShape(14, 1.605f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -13.5f));
        ground.addImage(image2);
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-12f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(12f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        //AMC adding in small blocks
        BlockSmall block1 = new BlockSmall(this);
        block1.setPosition(new Vec2(7f, -5f));
        BlockSmall block2 = new BlockSmall(this);
        block2.setPosition(new Vec2(-.6f, .3f));
        block2.setAngleDegrees(90);

        //AMC adding in large blocks
        BlockLarge blockL1 = new BlockLarge(this);
        blockL1.setPosition(new Vec2(5, 7));
        BlockLarge blockL2 = new BlockLarge((this));
        blockL2.setPosition(new Vec2(5, -14));
        BlockLarge blockL3 = new BlockLarge(this);
        blockL3.setPosition(new Vec2(0f, -7));
        BlockLarge blockL4 = new BlockLarge(this);
        blockL4.setPosition(new Vec2(3, 5));
        blockL4.setAngleDegrees(90);
        BlockLarge blockL5 = new BlockLarge(this);
        blockL5.setPosition(new Vec2(-10, 1f));
        blockL5.setAngleDegrees(90);


        // AMC adding in planet
        Body planet1 = new Planet(this);
        planet1.setPosition(new Vec2(8, 9f));
        planet1.addCollisionListener(new PlanetPickup(game));
        Body planet2 = new Planet((this));
        planet2.setPosition(new Vec2(6, 0));
        planet2.addCollisionListener(new PlanetPickup(game));
        Body planetSpecial = new Planet(this);
        planetSpecial.setPosition(new Vec2(0, 7));
        planetSpecial.addCollisionListener(new PlanetSpecialPickup(game));
        planetSpecial.addImage(image4);

        //AMC adds in pickup image from previous level
        Body shipImage = new StaticBody(this);
        shipImage.setPosition(new Vec2(-11.5f, 11.5f));
        shipImage.addImage(image1);
        //AMC adds in stars
        Body background = new StaticBody(this);
        background.setPosition(new Vec2(0, 0));
        background.addImage(image3);

    }

    public Game getGame() {
        return game;
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -12);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);

    }

    @Override
    public Vec2 enemyPosition() {
        return new Vec2(-100.4f, -9.6f);

    }

    @Override
    public boolean isCompleted() {
        return game.getShipParts() == 1;
    }

}
