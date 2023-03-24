package pong;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;

public class BatComponent extends Component {
    private static final double BAT_SPEED = 420;

    protected PhysicsComponent physics;

    public void up() {
        // speed should be -
        if (entity.getY() >= 0) {
            physics.setVelocityY(-BAT_SPEED);
        }
        else {
            stop();
        }
    }

    public void down() {
        // speed should be +
        if (entity.getY() <= 500-60) {
            physics.setVelocityY(BAT_SPEED);
        }
        else {
            stop();
        }
    }

    public void stop() {
        physics.setVelocityY(0);
    }
}
