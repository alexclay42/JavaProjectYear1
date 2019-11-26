package game;

import city.cs.engine.BodyImage;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control the player
 */
public class PlayerController extends KeyAdapter {
    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 3.5f;
    private static final BodyImage image1 =
            new BodyImage("data/playerRight.gif", 3f);
    private static final BodyImage image2 =
            new BodyImage("data/playerLeft.png", 3f);
    private static final BodyImage image3 =
            new BodyImage("data/playerIdle.gif", 3f);

    private Walker body;

    public PlayerController(Walker body) {
        this.body = body;
    }

    /**
     * Handle key press events for walking and jumping.
     *
     * @param e description of the key event
     */

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) { // J = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); // 1 = walk left
            body.removeAllImages();
            body.addImage(image2);

        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); // 2 = walk right
            body.removeAllImages();
            body.addImage(image1);
        } else if (code == KeyEvent.VK_S) ;
        {
            body.jump(-JUMPING_SPEED);
        }

    }

    /**
     * Handle key release events (stop walking).
     *
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(image3);
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(image3);
        }
    }

    public void setBody(Walker body) {
        this.body = body;
    }
}
