package game;


import org.jbox2d.common.Vec2;

/** Creates the instruction page off the main menu
 *
 */
public class Level6Instruction extends GameLevel {

    private Game game;

    public Level6Instruction(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }


    @Override
    public void populate(Game game) {
        super.populate(game);


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
        return 1 == 1;
    }


}

