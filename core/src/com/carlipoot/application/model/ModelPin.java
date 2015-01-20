package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.carlipoot.application.Application;

import static com.carlipoot.application.util.Box2DHelper.toMeters;

/** Models the main Entity that is controlled by the player.
 * @author Carlipoot */
public class ModelPin extends Model {

    /** Creates a new Model. */
    public ModelPin() {
        super();
    }

    /** Defines the Model with all components. */
    @Override
    public void defineModel() {
        bodyDef.type = BodyDef.BodyType.StaticBody;

         defineHitBox();

        // Create Fixtures
        FixtureDef mainFixture = new FixtureDef();
        PolygonShape mainShape = new PolygonShape();
        mainShape.setAsBox(toMeters(Application.WIDTH / 2 - 1), toMeters(10));
        mainFixture.shape = mainShape;

        fixtureDefs.add(mainFixture);
    }

}
