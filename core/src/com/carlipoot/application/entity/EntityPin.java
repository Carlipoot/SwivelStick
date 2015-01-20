package com.carlipoot.application.entity;

import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.manager.EntityManager;
import com.carlipoot.application.model.ModelPin;
import com.carlipoot.application.util.Animation;

/** The main Entity that interacts with the player.
 * @author Carlipoot */
public class EntityPin extends Entity {

    /** Creates an Entity with a reference to the EntityManager.
     * @param entityManager the LevelManager reference.
     * @param animation the Animation for the Entity. */
    public EntityPin(EntityManager entityManager, Animation animation) {
        super(entityManager, animation);

        model = new ModelPin();
    }

    /** Creates the Entity in the given World.
     * @param world the World to create the Entity in.
     * @param x the horizontal position.
     * @param y the vertical position. */
    @Override
    public void create(World world, float x, float y) {
        setPosition(x, y);
        model.createModel(world, this);
    }

}
