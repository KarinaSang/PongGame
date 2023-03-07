package pong;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import javafx.geometry.Point2D;

public class BallComponent extends Component {
    private PhysicsComponent physicsComponent;

    @Override
    public void onUpdate(double tpf) {
        limitVelocity();
        checkOffScreen();
    }

    private void limitVelocity() {
        if (Math.abs(physicsComponent.getVelocityY()) > 5*60*2) {
            physicsComponent.setVelocityY(Math.signum(physicsComponent.getVelocityY())*5*60);
        }

        if (Math.abs(physicsComponent.getVelocityX()) < 5*60) {
            physicsComponent.setVelocityX(Math.signum(physicsComponent.getVelocityX())*5*60);
        }
    }

    private void checkOffScreen() {
        if (getEntity().getBoundingBoxComponent().isOutside(FXGL.getGameScene().getViewport().getVisibleArea())) {
            physicsComponent.overwritePosition(
                    new Point2D(
                           FXGL.getAppWidth()/2,
                           FXGL.getAppHeight()/2
                    )
            );
        }
    }

}
