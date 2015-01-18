package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.carlipoot.application.entity.Entity;

/**
 * An abstract class that defines the Box2D structure of an Entity.
 * @author Calripoot
 */
public abstract class Model {

    /**
     * A reference to the Entity this belongs to.
     */
    protected Entity entity;

    private BodyDef bodyDef;
    private Array<FixtureDef> fixtureDefs;

    /**
     * Creates a new Model for the specified Entity.
     * @param entity the Entity this Model portrays.
     */
    public Model(Entity entity) {
        this.entity = entity;

        // Initialise variables
        bodyDef = null;
        fixtureDefs = new Array<FixtureDef>();
    }

    /**
     * Creates the Model in the given world.
     * @param world the World to create the Model in.
     */
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
