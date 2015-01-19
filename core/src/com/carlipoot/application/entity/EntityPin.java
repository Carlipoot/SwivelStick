package com.carlipoot.application.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.manager.LevelManager;
import com.carlipoot.application.model.ModelPin;

/** The main Entity that interacts with the player.
 * @author Carlipoot */
public class EntityPin extends Entity {

    /** Creates an Entity with a reference to the LevelManager at the specified position.
     * @param levelManager the LevelManager reference.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public EntityPin(LevelManager levelManager, int x, int y) {
        super(levelManager, x, y);

        model = new ModelPin(this, x, y);
    }

    /** Creates the Entity in the given World.
     * @param world the World to create the Entity in. */
    @Override
    public void create(World world) {
        // Create physical
        model.create(levelManager.getWorld());

        // Create visual

    }

    /** Updates the Entity.
     * @param delta the change in time. */
    @Override
    public void update(float delta) {
        // Match visual to physical
        setPosition(body.getPosition().x, body.getPosition().y);
        setRotation(body.getAngle() * MathUtils.radiansToDegrees);
    }

    /** Disposes of all objects. */
    @Override
    public void dispose() {
        levelManager.getWorld().destroyBody(body);
    }

}
