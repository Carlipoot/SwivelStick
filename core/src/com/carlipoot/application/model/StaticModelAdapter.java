package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.BodyDef;

/** An adapter class to create a basic Model.
 * @author Carlipoot */
public class StaticModelAdapter extends Model {

    /** Creates a new Model. */
    public StaticModelAdapter() {
        super();
    }

    /** Defines the Model with all components. */
    public void defineModel() {
        bodyDef.type = BodyDef.BodyType.StaticBody;

        defineHitBox();
    }

}
