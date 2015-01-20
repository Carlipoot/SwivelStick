package com.carlipoot.application.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.manager.EntityManager;
import com.carlipoot.application.model.Model;
import com.carlipoot.application.model.StaticModelAdapter;
import com.carlipoot.application.util.Animation;

/** An adapter class to create a basic Entity.
 * @author Carlipoot */
public class EntityAdapter extends Entity {

    /** Creates an Entity with a reference to the EntityManager.
     * @param entityManager the LevelManager reference.
     * @param texture the Texture for the Entity. */
    public EntityAdapter(EntityManager entityManager, Texture texture) {
        this(entityManager, texture, new StaticModelAdapter());
    }

    /** Creates an Entity with a reference to the EntityManager.
     * @param entityManager the LevelManager reference.
     * @param animation the Animation for the Entity. */
    public EntityAdapter(EntityManager entityManager, Animation animation) {
        this(entityManager, animation, new StaticModelAdapter());
    }

    /** Creates an Entity with a reference to the EntityManager.
     * @param entityManager the LevelManager reference.
     * @param texture the Texture for the Entity.
     * @param model the Model for the Entity*/
    public EntityAdapter(EntityManager entityManager, Texture texture, Model model) {
        super(entityManager, texture);

        this.model = model;
    }

    /** Creates an Entity with a reference to the EntityManager.
     * @param entityManager the LevelManager reference.
     * @param animation the Animation for the Entity.
     * @param model the Model for the Entity */
    public EntityAdapter(EntityManager entityManager, Animation animation, Model model) {
        super(entityManager, animation);

        this.model = model;
    }

    /** Creates the Entity in the given World.
     * @param world the World to create the Entity in.
     * @param x     the horizontal position.
     * @param y     the vertical position. */
    @Override
    public void create(World world, float x, float y) {
        setPosition(x, y);
        model.createModel(world, this);
    }

}
