package com.carlipoot.application.level;

import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.Application;
import com.carlipoot.application.manager.EntityManager;
import com.carlipoot.application.manager.LevelManager;

/** The first Level of the game
 * @author Carlipoot */
public class Level1 extends Level {

    /** Creates a new Level with a reference to the LevelManager and World.
     * @param levelManager the LevelManger reference.
     * @param world the World reference. */
    public Level1(LevelManager levelManager, World world) {
        super(levelManager, world);
    }

    /** Creates the Level. */
    @Override
    public void createLevel() {
        entityManager.createEntity(EntityManager.PLAYER, world, 150, 400);
        entityManager.createEntity(EntityManager.PLAYER, world, 200, 600);
        entityManager.createEntity(EntityManager.PLAYER, world, 250, 800);
        entityManager.createEntity(EntityManager.PIN, world, Application.WIDTH / 2, 20);
    }

    /** Releases all resources of this object. */
    @Override
    public void dispose() {
        entityManager.disposeEntities();
    }
}
