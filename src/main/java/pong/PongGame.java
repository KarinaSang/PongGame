package pong;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;

public class PongGame extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(500);
        settings.setTitle("PongGame");
        settings.setVersion("1.0");
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new PongFactory());
        FXGL.spawn("ball");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
