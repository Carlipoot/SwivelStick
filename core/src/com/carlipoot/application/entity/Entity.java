package com.carlipoot.application.entity;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.carlipoot.application.Application;
import com.carlipoot.application.manager.LevelManager;
import com.carlipoot.application.manager.ResourceManager;
import com.carlipoot.application.model.Model;

/** An abstract class that defines an entity.
 * @author Carlipoot */
public abstract class Entity extends Actor implements Disposable {

    /** A reference to the LevelManager. */
    protected LevelManager levelManager;

    /** A reference to the ResourceManager. */
    protected ResourceManager resourceManager;

    /** A reference the Body created in the World. */
    protected Body body;

    /** The Model that creates the Entity in the World. */
    protected Model model;

    private Application application;

    /** Creates an Entity with a reference to the LevelManager at the specified position.
     * @param levelManager the LevelManager reference.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public Entity(LevelManager levelManager, int x, int y) {
        this.levelManager = levelManager;
        application = levelManager.getApplication();
        resourceManager = application.getResourceManager();

        setPosition(x, y);
        body = null;
        model = null;
    }

    /** Sets the Body reference to the Entity.
     * @param body the reference to the Body. */
    public void setBody(Body body) {
        this.body = body;
    }

    /** Creates the Entity in the given World.
     * @param world the World to create the Entity in. */
    public abstract void create(World world);

    /** Updates the Entity.
     * @param delta the change in time. */
    public abstract void update(float delta);

    /** Disposes of all objects. */
    @Override
    public abstract void dispose();

}
