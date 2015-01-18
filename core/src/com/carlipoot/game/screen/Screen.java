package com.carlipoot.game.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.carlipoot.game.Application;
import com.carlipoot.game.manager.ScreenManager;

/**
 * An abstract class that defines a screen.
 * @author Carlipoot
 */
public abstract class Screen implements Disposable {

    /**
     * A reference to the screen manager that manages all screens.
     */
    protected ScreenManager screenManager;

    /**
     * A reference to the application.
     */
    protected Application application;

    /**
     * A reference to the main camera for all screens.
     */
    protected OrthographicCamera camera;

    /**
     * A reference to the main sprite batch for all screens.
     */
    protected SpriteBatch spriteBatch;

    /**
     * Creates a new scene with a scene manager and sets all references.
     * @param screenManager the screen manager to manage the screen.
     */
    protected Screen(ScreenManager screenManager) {
        this.screenManager = screenManager;
        application = screenManager.getApplication();
        spriteBatch = application.getSpriteBatch();
        camera = application.getCamera();
    }

    /**
     * Checks inputs and processes accordingly.
     */
    public abstract void handleInput();

    /**
     * Renders the screen and all components.
     */
    public abstract void render();

    /**
     * Updates the screen and all components.
     * @param delta the change in time.
     */
    public abstract void update(float delta);

    /**
     * Disposes the screen and all components.
     */
    public abstract void dispose();

}
