package com.carlipoot.application.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.manager.LevelManager;
import com.carlipoot.application.model.ModelPin;
import com.carlipoot.application.util.Animation;
import com.carlipoot.application.util.Resources;

/** The main Entity that interacts with the playerTexture.
 * @author Carlipoot */
public class EntityPin extends Entity {

    private Animation animation;

    /** Creates an Entity with a reference to the LevelManager at the specified position.
     * @param levelManager the LevelManager reference.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public EntityPin(LevelManager levelManager, int x, int y) {
        super(levelManager, x, y);

        model = new ModelPin(this, x, y);
        animation = new Animation((Texture)resourceManager.get(Resources.exampleAnimation), 6, 5, 0.05f );
    }

    /** Creates the Entity in the given World.
     * @param world the World to create the Entity in. */
    @Override
    public void create(World world) {
        model.create(world);
    }

    /** Updates the Entity.
     * @param delta the change in time. */
    @Override
    public void update(float delta) {
        super.update(delta);
        setTextureRegion(animation.getTextureRegion(application.getTime()));
    }
}
