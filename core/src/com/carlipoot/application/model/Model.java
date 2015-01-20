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

    /** Creates a new Model. */
    public Model() {
        bodyDef = new BodyDef();
        fixtureDefs = new Array<FixtureDef>();
    }

    /** Creates the Model in the given World with all components.
     * @param world the World to create the Model in.
     * @param entity the Entity that's creating the Model. */
    public void createModel(World world, Entity entity) {
        setEntity(entity);

        defineModel();

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

    /** Defines a hit box for the Model. */
    public void defineHitBox() {
        FixtureDef hitBox = new FixtureDef();
        PolygonShape hitBoxShape = new PolygonShape();
        hitBoxShape.setAsBox(toMeters(entity.getWidth() / 2), toMeters(entity.getHeight() / 2));
        hitBox.shape = hitBoxShape;
        hitBox.density = 1.0f;
        fixtureDefs.add(hitBox);
    }

    /** Defines the Model with all components. */
    public abstract void defineModel();

    /** Sets the Entity this Model belongs to.
     * @param entity the Entity. */
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

}
