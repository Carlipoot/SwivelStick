package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.carlipoot.application.entity.Entity;

import static com.carlipoot.application.util.Box2DHelper.toMeters;

/** Models the main Entity that is controlled by the player.
 * @author Carlipoot */
public class ModelPlayer extends Model {

    /** Creates a new Model for the specified Entity.
     * @param entity the Entity this Model portrays. */
    public ModelPlayer(Entity entity) {
        super(entity);

        // Create the Body
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        // Create Fixtures
        FixtureDef mainFixture = new FixtureDef();
        PolygonShape mainShape = new PolygonShape();
        mainShape.setAsBox(toMeters(25), toMeters(5));
        mainFixture.shape = mainShape;

        fixtureDefs.add(mainFixture);
    }

}
