package com.carlipoot.application.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.manager.EntityManager;
import com.carlipoot.application.model.ModelPlayer;

/** The main Entity that is controlled by the player.
 * @author Carlipoot */
public class EntityPlayer extends Entity {

    /** Creates an Entity with a reference to the EntityManager.
     * @param entityManager the LevelManager reference.
     * @param texture the Texture for the Entity. */
    public EntityPlayer(EntityManager entityManager, Texture texture) {
        super(entityManager, texture);

        model = new ModelPlayer(this);
    }

    /** Creates the Entity in the given World.
     * @param world the World to create the Entity in.
     * @param x the horizontal position.
     * @param y the vertical position. */
    @Override
    public void create(World world, float x, float y) {
        setPosition(x, y);
        model.create(world);
        body.setAngularVelocity(1.6f);
    }

}
