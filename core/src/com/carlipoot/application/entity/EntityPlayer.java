package com.carlipoot.application.entity;

import com.badlogic.gdx.math.MathUtils;
import com.carlipoot.application.manager.EntityManager;
import com.carlipoot.application.model.ModelPlayer;

/** The main Entity that is controlled by the player.
 * @author Carlipoot */
public class EntityPlayer extends Entity {

    /** Creates an Entity with a reference to the EntityManager.
     * @param entityManager the EntityManager reference. */
    public EntityPlayer(EntityManager entityManager) {
        super(entityManager);

        model = new ModelPlayer(this);
    }

    /** Updates the Entity.
     * @param delta the change in time. */
    @Override
    public void update(float delta) {
        setPosition(body.getPosition().x, body.getPosition().y);
        setRotation(body.getAngle() * MathUtils.radiansToDegrees);
    }

    /** Disposes of all objects. */
    @Override
    public void dispose() {
        body.getWorld().destroyBody(body);
        model = null;
    }

}
