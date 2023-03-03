package pong;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PongFactory implements EntityFactory {
    @Spawns("ball")
    public Entity newBall(SpawnData data) {
        return FXGL.entityBuilder()
                .type(EntityType.BALL)
                .view(new Circle(30, Color.GOLD))
                .at(100, 100)
                .build();
    }
}
