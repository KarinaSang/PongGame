package pong;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;

public class PongGame extends GameApplication {
    private BatComponent playerBatComponent;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(500);
        settings.setTitle("PongGame");
        settings.setVersion("1.0");
    }

    @Override
    protected void initInput() {
        FXGL.getInput().addAction(new UserAction("up") {
            @Override
            protected void onAction() {
                playerBatComponent.up();
                System.out.println("Pressing up");
            }

            @Override
            protected void onActionEnd() {
                playerBatComponent.stop();
                System.out.println("Up ends");
            }

        }, KeyCode.W);

        FXGL.getInput().addAction(new UserAction("down") {
            @Override
            protected void onAction() {
                playerBatComponent.down();
                System.out.println("Pressing down");
            }

            @Override
            protected void onActionEnd() {
                playerBatComponent.stop();
                System.out.println("Down ends");
            }

        }, KeyCode.S);
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new PongFactory());
        FXGL.spawn("ball");

        Entity player = FXGL.spawn("bat", new SpawnData(FXGL.getAppWidth()/4, FXGL.getAppHeight()/2-30).put("isPlayer", true));
        playerBatComponent = player.getComponent(BatComponent.class);

        FXGL.spawn("bat", new SpawnData(3*FXGL.getAppWidth()/4 - 20, FXGL.getAppHeight()/2-30).put("isPlayer", false));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
