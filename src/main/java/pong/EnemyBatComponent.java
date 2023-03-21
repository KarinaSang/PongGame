package pong;

import com.almasb.fxgl.entity.Entity;

public class EnemyBatComponent extends BatComponent{
    private Entity ball;

    public void moveAI() {
        Entity bat = entity;

        boolean isBallToLeft = ball.getRightX() <= bat.getX();
    }
}
