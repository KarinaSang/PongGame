package pong;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.particle.ParticleEmitter;
import com.almasb.fxgl.particle.ParticleEmitters;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import javafx.beans.binding.Bindings;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PongFactory implements EntityFactory {
    @Spawns("ball")
    public Entity newBall(SpawnData data) {
        PhysicsComponent physicsComponent = new PhysicsComponent();
        physicsComponent.setBodyType(BodyType.DYNAMIC);
        physicsComponent.setOnPhysicsInitialized(() -> physicsComponent.setLinearVelocity(5*60, -5*60));

//        ParticleEmitter emitter = ParticleEmitters.newFireEmitter();
//        emitter.startColorProperty().bind(
//                Bindings.when(new Obser)
//                        .then()
//        )


        return FXGL.entityBuilder(data)
                .type(EntityType.BALL)
                .view(new Circle(30, Color.GOLD))
                .bbox(new HitBox(BoundingShape.circle(5)))
                .with(new CollidableComponent(true))
                .with(physicsComponent)
                .with(new BallComponent())
                .at(100, 100)
                .build();
    }

    @Spawns("bat")
    public Entity newBat(SpawnData data) {
        boolean isPlayer = data.get("isPlayer");
        System.out.println(isPlayer);

        PhysicsComponent physicsComponent = new PhysicsComponent();
        physicsComponent.setBodyType(BodyType.KINEMATIC);


        return FXGL.entityBuilder(data)
                .from(data)
                .type(isPlayer ? EntityType.PLAYER_BAT : EntityType.ENEMY_BAT)
                .viewWithBBox(new Rectangle(20, 60, Color.LIGHTGRAY))
                .with(new CollidableComponent(true))
                .with(physicsComponent)
                .with(new BatComponent())
                .build();
    }
}
