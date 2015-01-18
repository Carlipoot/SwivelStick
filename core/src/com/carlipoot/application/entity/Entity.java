package com.carlipoot.application.entity;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.carlipoot.application.Application;
import com.carlipoot.application.manager.EntityManager;
import com.carlipoot.application.manager.ResourceManager;

/**
 * An abstract class that defines an entity.
 * @author Carlipoot
 */
public abstract class Entity extends Actor {

    /**
     * A reference to the EntityManager.
     */
    protected EntityManager entityManager;

    /**
     * A reference to the ResourceManager.
     */
    protected ResourceManager resourceManager;

    /**
     * A reference the Body created in the World.
     */
    protected Body body;

    private Application application;

    /**
     * Creates an Entity with a reference to the EntityManager.
     * @param entityManager the EntityManager reference.
     */
    public Entity(EntityManager entityManager) {
        this.entityManager = entityManager;
        application = entityManager.getApplication();
        resourceManager = application.getResourceManager();

        body = null;
    }

    /**
     * Sets the Body reference to the Entity.
     * @param body the reference to the Body.
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * Updates the Entity.
     * @param delta the change in time.
     */
    public abstract void update(float delta);

}
