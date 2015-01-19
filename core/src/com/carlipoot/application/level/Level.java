package com.carlipoot.application.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.carlipoot.application.Application;
import com.carlipoot.application.entity.Entity;
import com.carlipoot.application.manager.LevelManager;

/** An abstract class the defines a level.
 * @author Carlipoot */
public abstract class Level implements Disposable{

    /** A reference to the LevelManager */
    protected LevelManager levelManager;

    /** A reference to the World this Level is in. */
    protected World world;

    /** An array for every Entity in the Level */
    protected Array<Entity> entities;

    private Application application;

    /** Creates a new Level with a reference to the LevelManager.
     * @param levelManager the LevelManger reference. */
    public Level(LevelManager levelManager) {
        this.levelManager = levelManager;
        application = levelManager.getApplication();
        world = levelManager.getWorld();

        entities = new Array<Entity>();
    }

    /** Creates the Level in the given World.
     * @param world the World to create the Level in. */
    public void create(World world) {
        for ( Entity entity : entities) {
            if ( entity != null ) entity.create(world);
        }
    }

    /** Renders the current Level.
     * @param spriteBatch the SpriteBatch used for rendering. */
    public void render(SpriteBatch spriteBatch) {
        for ( Entity entity : entities) {
            if ( entity != null ) entity.render(spriteBatch);
        }
    }

    /** Updates every Entity in the Level.
     * @param delta the change in time.*/
    public void update(float delta) {
        for ( Entity entity : entities) {
            if ( entity != null ) entity.update(delta);
        }
    }

    /** Disposes of all objects. */
    @Override
    public void dispose() {
        for ( Entity entity : entities) {
            if ( entity != null ) entity.dispose();
        }
    }

}
