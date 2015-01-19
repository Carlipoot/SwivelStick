package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
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

    /** Creates a new Model for the specified Entity at position x, y.
     * @param entity the Entity this Model portrays.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public Model(Entity entity, int x, int y) {
        this.entity = entity;

        // Initialise variables
        bodyDef = new BodyDef();
        bodyDef.position.set(toMeters(x), toMeters(y));
        fixtureDefs = new Array<FixtureDef>();
    }

    /** Creates the Model in the given World at the specified position.
     * @param world the World to create the Entity in. */
    public void create(World world) {
        if ( bodyDef == null ) return;

        // Create Body in World and set the cyclic references
        Body body = world.createBody(bodyDef);
        body.setUserData(entity);
        entity.setBody(body);

        // Create fixtures on the Body
        for ( FixtureDef fixture : fixtureDefs) {
            if ( fixture != null ) body.createFixture(fixture);
        }
    }

}
