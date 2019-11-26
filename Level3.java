package game;


import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/** Level 3 of the game
 * Randomly falling asteroid and robot block
 */
public class Level3 extends GameLevel {

    private Game game;
    private GameLevel world;

    public Level3(Game game, GameLevel world) {
        this.game = game;
        this.world = world;
    }

    private static final BodyImage image1 =
            new BodyImage("data/Ship1.gif", 1f);
    private static final BodyImage image2 =
            new BodyImage("data/lvl3g.jpeg", 3f);
    private static final BodyImage image3 =
            new BodyImage("data/iu-15.png", 2.5f);


    @Override
    public void populate(Game game) {
        super.populate(game);

        Shape groundShape = new BoxShape(14, 1.605f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -13.5f));
        ground.addImage(image2);
        // walls
        Shape wall = new BoxShape(.5f, 20f);
        Body wall1 = new StaticBody(this, wall);
        Body wall2 = new StaticBody(this, wall);
        wall1.setPosition(new Vec2(-13f, 0));
        wall2.setPosition(new Vec2(13f, 0));


        //AMC adding in special planet
        Planet planet1 = new Planet(this);
        planet1.setPosition(new Vec2(6, 7));
        planet1.addImage(image3);
        planet1.addCollisionListener(new PlanetSpecialPickup(game));

        //AMC adding in falling asteroids
        Asteroid asteroid1 = new Asteroid(this);
        asteroid1.setPosition(new Vec2(5, 5));
        asteroid1.addCollisionListener(new AsteroidHandler(game, this));

        //AMC adding in ship platforms
        PlatformShip shipP1 = new PlatformShip(this);
        shipP1.setPosition(new Vec2(7, -3));

        //AMC second ship collectable
        Body ship1 = new ShipPart(this);
        ship1.setPosition(new Vec2(-6f, -11f));
        ship1.addCollisionListener(new ShipPickup(game, this));



        //AMC adding in the first ship image
        Body shipImage = new StaticBody(this);
        shipImage.setPosition(new Vec2(-11.5f, 11.5f));
        shipImage.addImage(image1);

        Body background = new StaticBody(this);
        background.setPosition(new Vec2(0, 10));


        FriendlyNPC soup = new FriendlyNPC(game, this);
        soup.setPosition(new Vec2(6, -10));
        soup.addCollisionListener(new FriendlyNPCHandler(game, this, world));


    }

    public Game getGame() {
        return game;
    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(10.4f, -9.6f);
    }

    @Override
    public Vec2 enemyPosition() {
        return new Vec2(-100.4f, -9.6f);

    }

    @Override
    public boolean isCompleted() {
        return game.getShipParts() == 2;
    }
}