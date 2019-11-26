package game;

import city.cs.engine.*;
import org.jbox2d.common.Timer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/** Controls the enemy in the first level when A is pressed
 * Random chance of it changing direction of motion each time the key is hit
 */
public class EnemyController extends KeyAdapter {
    private static final float WALKING_SPEED = .5f;
    private Timer timer = new Timer();
    private Walker body;

    public EnemyController(Walker body) {
        this.body = body;
    }

    @Override
    public void keyPressed(KeyEvent e ){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A){
            if(((timer.getMilliseconds())%1000 <= 500 )) {
                body.startWalking(-WALKING_SPEED);
            }
            else {
                body.startWalking(WALKING_SPEED);
            }
        }



    }
    public void setBody(Walker body){this.body = body;}
}

