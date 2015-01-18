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

    private Application application;
    private Body body;

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

    // These may be required soon
    public abstract void update(float delta);

}
