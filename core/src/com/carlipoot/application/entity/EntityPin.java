package com.carlipoot.application.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.manager.LevelManager;
import com.carlipoot.application.model.ModelPin;
import com.carlipoot.application.util.Resources;

/** The main Entity that interacts with the playerTexture.
 * @author Carlipoot */
public class EntityPin extends Entity {

    /** Creates an Entity with a reference to the LevelManager at the specified position.
     * @param levelManager the LevelManager reference.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public EntityPin(LevelManager levelManager, int x, int y) {
        super(levelManager, x, y);

        model = new ModelPin(this, x, y);
        setTexture((Texture) resourceManager.get(Resources.pinTexture));
    }

    /** Creates the Entity in the given World.
     * @param world the World to create the Entity in. */
    @Override
    public void create(World world) {
        model.create(world);
    }

}
