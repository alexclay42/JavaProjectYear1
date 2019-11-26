package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private Robot player;
    private Enemy enemy;
    private Laser laser;
    private Game game;


public Level1 (Game game){
        this.game = game;
    }
    //gives second planet variation
    private static final BodyImage image1 =
            new BodyImage("data/Planet2.gif", 1.6f);
    private static final BodyImage image2 =
            new BodyImage("data/floor.gif", 1f);
    private static final BodyImage image3 =
            new BodyImage("data/background.gif", 25f);


    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);



        // make the ground + ceiling
        Shape groundShape = new BoxShape(14,.605f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12.5f));
        ground.addImage(image2);
        Body ceiling = new StaticBody(this, groundShape);
        ceiling.setPosition(new Vec2(0f,13f));
        // making the walls
        Shape wall = new BoxShape(.5f,20f);
        Body wall1 = new StaticBody(this, wall);
        Body wall2 = new StaticBody(this, wall);
        wall1.setPosition(new Vec2(-13f,0));
        wall2.setPosition(new Vec2(13f,0));


        // making the platforms
        Platform platform1 = new Platform(this);
        platform1.setPosition(new Vec2(-5,-6f));
        Platform platform2 = new Platform(this);
        platform2.setPosition(new Vec2(5,-2f));
        Platform platform3 = new Platform(this);
        platform3.setPosition(new Vec2(-9,2));

        // Planet 1 - upper left hand corner
        Body planet1 = new Planet(this);
        planet1.setPosition(new Vec2(-4, -2.5f));
        planet1.addCollisionListener(new PlanetPickup( game));
        // Planet 2 - ground level middle
        Body planet2 = new Planet(this);
        planet2.setPosition(new Vec2(5, 6));
        planet2.addCollisionListener(new PlanetPickup(game));
        planet2.addImage(image1);




        // First ship collectable
        Body ship1 = new ShipPart(this);
        ship1.setPosition(new Vec2(-5f,-10f));
        ship1.addCollisionListener(new ShipPickup(game,this));

        // adding in the power-up
        PowerUp powerUp = new PowerUp(this);
        powerUp.setPosition(new Vec2(-9.5f, 10f));
        powerUp.addCollisionListener(new PowerUpPickup(this, game));

        // adds in stars
        Body background = new StaticBody(this);
        background.setPosition(new Vec2(0,0));
        background.addImage(image3);

    }

    public Laser getLaser(){return laser;}
    public Game getGame(){return game;}
    @Override
   public Vec2 startPosition() {return new Vec2(8, -11.5f);}

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-11f, -10f);
    }

    @Override
    public Vec2 enemyPosition() {
        return new Vec2(3,-10f);

    }

    @Override
    public boolean isCompleted() {return game.getShipParts() == 1;
    }
}
