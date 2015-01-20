package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.BodyDef;

/** Models the main Entity that is controlled by the player.
 * @author Carlipoot */
public class ModelPlayer extends Model {

    /** Creates a new Model. */
    public ModelPlayer() {
        super();
    }

    /** Defines the Model with all components. */
    @Override
    public void defineModel() {
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        defineHitBox();

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
