package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A MouseListener that fires a laser when clicked
 */
public class LaserFire extends MouseAdapter {
    private WorldView view;
    private GameLevel world;
    private Game game;
    private static final float speed = 5f;

    /**
     * Construct a listener.
     *
     * @param view the view the mouse will be clicked on
     */
    public LaserFire(UserView view, GameLevel world, Game game) {
        this.view = view;
        this.world = world;
        this.game = game;
    }

    /**
     * Create a laser at the current mouse position.
     *
     * @param e event object containing the mouse position
     */


    public void mousePressed(MouseEvent e) {

        DynamicBody laser = new Laser(view.getWorld());


        float x = game.getPlayer().getPosition().x - 1;
        float y = game.getPlayer().getPosition().y;
        float z = view.viewToWorld(e.getPoint()).y;
        float z2 = view.viewToWorld(e.getPoint()).x;
        float a = z * -1;
        float b = z2 * 1;
        System.out.println(e.getPoint());
        laser.addCollisionListener(new LaserHandler(world, game));
        laser.setPosition(new Vec2(x, y));
        laser.applyForce(new Vec2(b, a));
        laser.setGravityScale(0);

    }


}


