package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.carlipoot.application.entity.Entity;

import static com.carlipoot.application.util.Box2DHelper.toMeters;

/** An abstract class that defines the Box2D structure of an Entity.
 * @author Calripoot */
public abstract class Model {

    /** A reference to the Entity this belongs to. */
    protected Entity entity;

    /** Defines the body of the Model. */
    protected BodyDef bodyDef;

    /** Defines the fixtures of the Model. */
    protected Array<FixtureDef> fixtureDefs;

    /** Creates a new Model for the specified Entity.
     * @param entity the Entity this Model portrays. */
    public Model(Entity entity) {
        this.entity = entity;

        // Initialise variables
        bodyDef = new BodyDef();
        fixtureDefs = new Array<FixtureDef>();

        // Create hit box for Entity
        FixtureDef hitBox = new FixtureDef();
        PolygonShape hitBoxShape = new PolygonShape();
        hitBoxShape.setAsBox(toMeters(entity.getWidth() / 2), toMeters(entity.getHeight() / 2));
        hitBox.shape = hitBoxShape;
        hitBox.density = 1.0f;
        fixtureDefs.add(hitBox);
    }

    /** Creates the Model in the given World at the specified position.
     * @param world the World to create the Entity in. */
    public void create(World world) {
        if ( bodyDef == null ) return;

        // Create Body in World and set the cyclic references
        bodyDef.position.set(toMeters(entity.getX()), toMeters(entity.getY()));
        Body body = world.createBody(bodyDef);
        body.setUserData(entity);
        entity.setBody(body);

        // Create fixtures on the Body
        for ( FixtureDef fixture : fixtureDefs) {
            if ( fixture != null ) body.createFixture(fixture);
        }
    }

}
