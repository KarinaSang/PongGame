package pong;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import javafx.scene.paint.Color;

public class PongGame extends GameApplication {
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(800);
        settings.setTitle("PongGame");
        settings.setVersion("1.0");
    }


    @Override
    protected void initGame() {
        FXGL.getGameScene().setBackgroundColor(Color.rgb(0, 0, 5));

        FXGL.getGameWorld().addEntityFactory(new PongFactory());
        // FXGL.spawn("ball");
        FXGL.spawn("bat", new SpawnData(FXGL.getAppWidth()/4, FXGL.getAppHeight()/2-30).put("isPlayer", true));
        FXGL.spawn("bat", new SpawnData(3*FXGL.getAppWidth()/4-20, FXGL.getAppHeight()/2-30).put("isPlayer", false));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
