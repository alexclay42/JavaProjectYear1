package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/** Main menu
 * Seen when game first initialises
 */

public class Level0MM extends GameLevel {
    private Game game;
    private static final BodyImage image =
            new BodyImage("data/mmbg.gif", 20f);

    public Level0MM(Game game) {
        this.game = game;

    }

    @Override
    public void populate(Game game) {
        super.populate(game);


        Body background = new StaticBody(this);
        background.setPosition(new Vec2(0, .03f));
        background.addImage(image);


    }
    public Game getGame() {
        return game;
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -120);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-100.4f, -9.6f);

    }

    @Override
    public Vec2 enemyPosition() {
        return new Vec2(-100.4f, -9.6f);

    }

    @Override
    public boolean isCompleted() {
        return game.getShipParts() >= 0;
    }

}


