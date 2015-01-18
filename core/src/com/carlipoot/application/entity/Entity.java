package com.carlipoot.application.entity;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.carlipoot.application.Application;
import com.carlipoot.application.manager.EntityManager;
import com.carlipoot.application.manager.ResourceManager;
import com.carlipoot.application.model.Model;

/** An abstract class that defines an entity.
 * @author Carlipoot */
public abstract class Entity extends Actor implements Disposable {

    /** A reference to the EntityManager. */
    protected EntityManager entityManager;

    /** A reference to the ResourceManager. */
    protected ResourceManager resourceManager;

    /** A reference the Body created in the World. */
    protected Body body;

    /** The Model that creates the Entity in the World. */
    protected Model model;

    private Application application;

    /** Creates an Entity with a reference to the EntityManager.
     * @param entityManager the EntityManager reference. */
    public Entity(EntityManager entityManager) {
        this.entityManager = entityManager;
        application = entityManager.getApplication();
        resourceManager = application.getResourceManager();

        body = null;
        model = null;

        entityManager.add(this);
    }

    /** Creates the Model in the given World at the specified position.
     * @param world the World to create the Entity in.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public void create(World world, int x, int y) {
        setPosition(x, y);
        model.create(world, x, y);
    }

    /** Sets the Body reference to the Entity.
     * @param body the reference to the Body. */
    public void setBody(Body body) {
        this.body = body;
    }

    /** Updates the Entity.
     * @param delta the change in time. */
    public abstract void update(float delta);

    /** Disposes of all objects. */
    @Override
    public abstract void dispose();

}
