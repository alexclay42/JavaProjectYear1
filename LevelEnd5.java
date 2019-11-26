package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/** End level which displays the score of the player */

public class LevelEnd5 extends GameLevel {
    private Game game;

    public LevelEnd5(Game game) {
        this.game = game;
    }


    private static final BodyImage image1 =
            new BodyImage("data/win.png", 6f);

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        Body text = new StaticBody(this);
        text.setPosition(new Vec2(6, -7));
        text.addImage(image1);

        FriendlyNPC beans = new FriendlyNPC(game, this);
        beans.setPosition(new Vec2(10, -10.5f));


    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(50, -11.5f);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(50, -10f);
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





