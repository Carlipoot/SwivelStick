package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.carlipoot.application.Application;
import com.carlipoot.application.entity.Entity;

import static com.carlipoot.application.util.Box2DHelper.toMeters;

/** Models the main Entity that is controlled by the playerTexture.
 * @author Carlipoot */
public class ModelPin extends Model {

    /** Creates a new Model for the specified.
     * @param entity the Entity this Model portrays. */
    public ModelPin(Entity entity) {
        super(entity);

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
