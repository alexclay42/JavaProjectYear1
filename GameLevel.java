package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Handles set up of player and enemy movement
 */
public abstract class GameLevel extends World {
    public Robot player;
    private Enemy enemy;
    private Laser laser;


    public Robot getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }


    public void populate(Game game) {
        player = new Robot(this);
        player.setPosition(startPosition());
        Door door = new Door(this, game);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
        enemy = new Enemy(this);
        enemy.setPosition(enemyPosition());
        enemy.addCollisionListener(new EnemyHandler(laser, game));



    }

    /**
     * The initial position of the player.
     */
    public abstract Vec2 startPosition();

    /**
     * The position of the exit door.
     */
    public abstract Vec2 doorPosition();

    public abstract Vec2 enemyPosition();

    /**
     * Is this level complete?
     */
    public abstract boolean isCompleted();
}
