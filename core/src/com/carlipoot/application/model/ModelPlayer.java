package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.carlipoot.application.entity.Entity;

/** Models the main Entity that is controlled by the playerTexture.
 * @author Carlipoot */
public class ModelPlayer extends Model {

    /** Creates a new Model for the specified Entity.
     * @param entity the Entity this Model portrays. */
    public ModelPlayer(Entity entity) {
        super(entity);

        // Edit the Body
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        // Create Fixtures
//        FixtureDef newFixture = new FixtureDef();
//        PolygonShape newShape = new PolygonShape();
//        newShape.setAsBox(toMeters(50), toMeters(25));
//        newFixture.shape = newShape;
//        newFixture.density = 1.0f;
//
//        fixtureDefs.add(newFixture);
    }

}
