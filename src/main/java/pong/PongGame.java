package pong;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class PongGame extends GameApplication {
    private BatComponent playerBat;
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(800);
        settings.setTitle("PongGame");
        settings.setVersion("1.0");
    }

    @Override
    protected void initInput() {
        // userAction, keyCode
        FXGL.getInput().addAction(new UserAction("Up") {
            @Override
            protected void onAction() {
                playerBat.up();
                System.out.println("Pressing W");
            }

            @Override
            protected void onActionEnd() {
                playerBat.stop();
                System.out.println("Releasing W");
            }
        }, KeyCode.W);

        FXGL.getInput().addAction(new UserAction("Down") {
            @Override
            protected void onAction() {
                playerBat.down();
                System.out.println("Pressing S");
            }

            @Override
            protected void onActionEnd() {
                playerBat.stop();
                System.out.println("Releasing S");
            }
        }, KeyCode.S);
    }


    @Override
    protected void initGame() {
        FXGL.getGameScene().setBackgroundColor(Color.rgb(0, 0, 5));

        FXGL.getGameWorld().addEntityFactory(new PongFactory());
        // FXGL.spawn("ball");
        Entity player = FXGL.spawn("bat", new SpawnData(FXGL.getAppWidth()/4, FXGL.getAppHeight()/2-30).put("isPlayer", true));
        playerBat = player.getComponent(BatComponent.class);

        FXGL.spawn("bat", new SpawnData(3*FXGL.getAppWidth()/4-20, FXGL.getAppHeight()/2-30).put("isPlayer", false));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
