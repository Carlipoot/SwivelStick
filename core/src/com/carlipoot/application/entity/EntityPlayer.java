package com.carlipoot.application.entity;

import com.carlipoot.application.manager.EntityManager;

/**
 * The main Entity that is controlled by the player.
 * @author Carlipoot
 */
public class EntityPlayer extends Entity {

    /**
     * Creates an Entity with a reference to the EntityManager.
     * @param entityManager the EntityManager reference.
     */
    public EntityPlayer(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * Updates the Entity.
     * @param delta the change in time.
     */
    @Override
    public void update(float delta) {

    }

}
