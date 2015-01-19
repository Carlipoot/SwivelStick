package com.carlipoot.application.screen;

import com.badlogic.gdx.graphics.Color;
import com.carlipoot.application.Application;
import com.carlipoot.application.manager.LevelManager;
import com.carlipoot.application.manager.ScreenManager;
import com.carlipoot.application.util.Box2DCamera;

/** The Screen that displays every Entity in the level.
 * @author Carlipoot */
public class GameScreen extends Screen {

    private LevelManager levelManager;
    private Box2DCamera worldCamera;


    /** Creates a new Screen with a ScreenManager and sets all references.
     * @param screenManager the ScreenManager to manage the Screen. */
    public GameScreen(ScreenManager screenManager) {
        super(screenManager);

        levelManager = application.getLevelManager();
        levelManager.setLevel(LevelManager.LEVEL1);

        // Create the world camera
        worldCamera = new Box2DCamera();
        worldCamera.setToOrtho(false, Application.WIDTH, Application.HEIGHT);
    }

    /** Checks inputs and processes accordingly. */
    @Override
    public void handleInput() {

    }

    /** Renders the Screen and all components. */
    @Override
    public void render() {
        clearScreen(Color.WHITE);

        // Render the world with debugger
        levelManager.renderDebug(worldCamera.combined);
    }

    /** Updates the Screen and all components.
     * @param delta the change in time. */
    @Override
    public void update(float delta) {
        worldCamera.update();
        levelManager.update(delta);
    }

    /** Disposes the Screen and all components. */
    @Override
    public void dispose() {

    }

}
