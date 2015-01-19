package com.carlipoot.application.manager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.Application;
import com.carlipoot.application.level.Level;
import com.carlipoot.application.level.Level1;
import com.carlipoot.application.util.IDHelper;

/** Manages the chosen level and all it's content.
 * @author Carlipoot */
public class LevelManager {

    /** ID for the level 1. */
    public static final int LEVEL1 = IDHelper.nextID();

    private Application application;
    private World world;

    private Box2DDebugRenderer worldRenderer;
    private Level level;

    /** Creates an LevelManager with a reference to the Application.
     * @param application the Application reference. */
    public LevelManager(Application application, World world) {
        this.application = application;
        this.world = world;

        // Create the world renderer
        worldRenderer = new Box2DDebugRenderer();

        // Set default Level
        level = null;
    }

    /** Renders the current using the Box2DDebugger.
     * @param matrix the matrix to render the World to. */
    public void renderDebug(Matrix4 matrix) {
        worldRenderer.render(world, matrix);
    }

    /** Renders the current Level.
     * @param spriteBatch the SpriteBatch used for rendering. */
    public void render(SpriteBatch spriteBatch) {
        level.render(spriteBatch);
    }

    /** Updates the current Level.
     * @param delta the change in time. */
    public void update(float delta) {
        // Update physical model
        world.step(delta, 10, 8);

        // Update visual model
        level.update(delta);
    }


    /** Gets the World this LevelManager is managing.
     * @return the World. */
    public World getWorld() {
        return world;
    }

    /** Gets the Application reference.
     * @return the reference to the Application. */
    public Application getApplication() {
        return application;
    }

    private Level getLevel(int level) {
        if ( level == LEVEL1 ) return new Level1(this);
        return null;
    }

    /** Sets the current Level.
     * @param level the ID of the Level. */
    public void setLevel(int level) {
        this.level = getLevel(level);
        this.level.create(world);
    }

}
