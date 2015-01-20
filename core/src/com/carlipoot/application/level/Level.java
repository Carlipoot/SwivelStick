package com.carlipoot.application.level;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;
import com.carlipoot.application.manager.EntityManager;
import com.carlipoot.application.manager.LevelManager;

/** An abstract class the defines a level.
 * @author Carlipoot */
public abstract class Level implements Disposable{

    /** A reference to the LevelManager */
    protected LevelManager levelManager;

    /** A reference to the EntityManager */
    protected EntityManager entityManager;

    /** A reference to the World this Level is in. */
    protected World world;

    /** Creates a new Level with a reference to the LevelManager and World.
     * @param levelManager the LevelManger reference.
     * @param world the World reference. */
    public Level(LevelManager levelManager, World world) {
        this.levelManager = levelManager;
        this.world = world;

        entityManager = levelManager.getApplication().getEntityManager();
    }

    /** Creates the Level. */
    public abstract void createLevel();

}
