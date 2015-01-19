package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.carlipoot.application.Application;
import com.carlipoot.application.entity.Entity;

import static com.carlipoot.application.util.Box2DHelper.toMeters;

/** Models the main Entity that is controlled by the player.
 * @author Carlipoot */
public class ModelPin extends Model {

    /** Creates a new Model for the specified Entity at position x, y.
     * @param entity the Entity this Model portrays.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public ModelPin(Entity entity, int x, int y) {
        super(entity, x, y);

        // Edit the Body
        bodyDef.type = BodyDef.BodyType.StaticBody;

        // Create Fixtures
        FixtureDef mainFixture = new FixtureDef();
        PolygonShape mainShape = new PolygonShape();
        mainShape.setAsBox(toMeters(Application.WIDTH / 2 - 1), toMeters(10));
        mainFixture.shape = mainShape;

        fixtureDefs.add(mainFixture);
    }

}
