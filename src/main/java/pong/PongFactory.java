package pong;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PongFactory implements EntityFactory {
    @Spawns("ball")
    public Entity newBall(SpawnData data) {
        return FXGL.entityBuilder()
                .type(EntityType.BALL)
                .view(new Circle(30, Color.GOLD))
                .at(100, 100)
                .build();
    }

    @Spawns("bat")
    public Entity newBat(SpawnData data) {
        boolean isPlayer = data.get("isPlayer");

        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.KINEMATIC);

        return FXGL.entityBuilder(data)
                .type(isPlayer ? EntityType.PLAYER_BAT : EntityType.ENEMY_BAT)
                .view(new Rectangle(20, 60, Color.BLACK))
                .with(physics)
                .with(new BatComponent())
                .build();
    }
}
