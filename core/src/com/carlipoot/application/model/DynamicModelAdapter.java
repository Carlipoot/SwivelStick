package com.carlipoot.application.model;

import com.badlogic.gdx.physics.box2d.BodyDef;

/** An adapter class to create a basic Model.
 * @author Carlipoot */
public class DynamicModelAdapter extends Model {

    /** Creates a new Model. */
    public DynamicModelAdapter() {
        super();
    }

    /** Defines the Model with all components. */
    public void defineModel() {
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        defineHitBox();
    }

}
