package com.carlipoot.application.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.manager.LevelManager;
import com.carlipoot.application.model.ModelPlayer;
import com.carlipoot.application.util.Animation;
import com.carlipoot.application.util.Resources;

/** The main Entity that is controlled by the playerTexture.
 * @author Carlipoot */
public class EntityPlayer extends Entity {

    private Animation animation;

    /** Creates an Entity with a reference to the LevelManager at the specified position.
     * @param levelManager the LevelManager reference.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public EntityPlayer(LevelManager levelManager, int x, int y) {
        super(levelManager, x, y);

        model = new ModelPlayer(this, x, y);
//        setTexture((Texture) resourceManager.get(Resources.playerTexture));
        animation = new Animation((Texture)resourceManager.get(Resources.exampleAnimation2), 11, 2, 0.05f );
    }

    /** Creates the Entity in the given World.
     * @param world the World to create the Entity in. */
    @Override
    public void create(World world) {
        model.create(world);
        body.setAngularVelocity(1.6f);
    }

    /** Updates the Entity.
     * @param delta the change in time. */
    @Override
    public void update(float delta) {
        super.update(delta);
        setTextureRegion(animation.getTextureRegion(application.getTime()));
    }

}
