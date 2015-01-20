package com.carlipoot.application.manager;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.Application;
import com.carlipoot.application.level.Level;
import com.carlipoot.application.level.Level1;
import com.carlipoot.application.util.IDHelper;

/** Manages the World and each Level.
 * @author Carlipoot */
public class LevelManager extends Manager{

    /** ID for the level 1. */
    public static final int LEVEL1 = IDHelper.nextID();

    private World world;
    private Level level;
    private Box2DDebugRenderer worldRenderer;

    /** Creates an LevelManager with a reference to the Application.
     * @param application the Application reference. */
    public LevelManager(Application application) {
        super(application);

        world = application.getWorld();
        worldRenderer = new Box2DDebugRenderer();
    }

    /** Renders the current using the Box2DDebugger.
     * @param matrix the matrix to render the World to. */
    public void renderDebug(Matrix4 matrix) {
        worldRenderer.render(world, matrix);
    }

    /** Updates the current Level.
     * @param delta the change in time. */
    public void update(float delta) {
        world.step(delta, 10, 8);
    }

    private Level getLevel(int level) {
        if ( level == LEVEL1 ) return new Level1(this, world);
        return null;
    }

    /** Sets the current Level.
     * @param level the ID of the Level. */
    public void setLevel(int level) {
        this.level = getLevel(level);
        this.level.createLevel();
    }

}
