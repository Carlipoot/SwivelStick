package com.carlipoot.application.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.carlipoot.application.Application;
import com.carlipoot.application.manager.ScreenManager;

/**
 * An abstract class that defines a screen.
 * @author Carlipoot
 */
public abstract class Screen implements Disposable {

    /**
     * A reference to the ScreenManager that manages every Screen.
     */
    protected ScreenManager screenManager;

    /**
     * A reference to the Application.
     */
    protected Application application;

    /**
     * A reference to the OrthographicCamera for every Screen.
     */
    protected OrthographicCamera camera;

    /**
     * A reference to the SpriteBatch for every Screen.
     */
    protected SpriteBatch spriteBatch;

    /**
     * Creates a new Screen with a ScreenManager and sets all references.
     * @param screenManager the ScreenManager to manage the Screen.
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
     * Renders the Screen and all components.
     */
    public abstract void render();

    /**
     * Updates the Screen and all components.
     * @param delta the change in time.
     */
    public abstract void update(float delta);

    /**
     * Disposes the Screen and all components.
     */
    public abstract void dispose();

    /**
     * Clears the screen to the specified colour.
     * @param colour the colour to set the screen.
     */
    public void clearScreen(Color colour) {
        Gdx.gl.glClearColor(colour.r, colour.g, colour.b, colour.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
