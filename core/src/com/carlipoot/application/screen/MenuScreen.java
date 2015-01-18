package com.carlipoot.application.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.carlipoot.application.manager.ScreenManager;

/**
 * The Screen that displays the main menu.
 * @author Carlipoot
 */
public class MenuScreen extends Screen {

    private BitmapFont font;

    /**
     * Creates a new Screen with a ScreenManager and sets all references.
     *
     * @param screenManager the ScreenManager to manage the Screen.
     */
    public MenuScreen(ScreenManager screenManager) {
        super(screenManager);
        font = new BitmapFont();
    }

    /**
     * Checks inputs and processes accordingly.
     */
    @Override
    public void handleInput() {

    }

    /**
     * Renders the Screen and all components.
     */
    @Override
    public void render() {
        spriteBatch.begin();
        font.draw(spriteBatch, "Main Menu", 20.0f, Gdx.graphics.getHeight() / 2.0f);
        spriteBatch.end();
    }

    /**
     * Updates the Screen and all components.
     *
     * @param delta the change in time.
     */
    @Override
    public void update(float delta) {

    }

    /**
     * Disposes the Screen and all components.
     */
    @Override
    public void dispose() {

    }

}
