package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.carlipoot.application.entity.Entity;

import static com.carlipoot.application.util.Box2DHelper.toMeters;

/** Models the main Entity that is controlled by the player.
 * @author Carlipoot */
public class ModelPlayer extends Model {

    /** Creates a new Model for the specified Entity at position x, y.
     * @param entity the Entity this Model portrays.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public ModelPlayer(Entity entity, int x, int y) {
        super(entity, x, y);

        // Edit the Body
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        // Create Fixtures
        FixtureDef mainFixture = new FixtureDef();
        PolygonShape mainShape = new PolygonShape();
        mainShape.setAsBox(toMeters(25), toMeters(5));
        mainFixture.shape = mainShape;
        mainFixture.density = 1.0f;

        fixtureDefs.add(mainFixture);

        // Modify slightly
        FixtureDef newFixture = new FixtureDef();
        PolygonShape newShape = new PolygonShape();
        newShape.setAsBox(toMeters(30), toMeters(25));
        newFixture.shape = newShape;
        newFixture.density = 1.0f;

        fixtureDefs.add(newFixture);
    }

}
