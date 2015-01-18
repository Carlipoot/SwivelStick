package com.carlipoot.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.carlipoot.game.Application;
import com.carlipoot.game.input.Input;
import com.carlipoot.game.manager.ScreenManager;

/**
 * The screen that displays the main menu.
 * @author Carlipoot
 */
public class MenuScreen extends Screen {

    private BitmapFont font;

    /**
     * Creates a new scene with a scene manager and sets all references.
     *
     * @param screenManager the screen manager to manage the screen.
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
        if ( Input.isPressed(Input.SPACEBAR) ) {
            screenManager.popScreen();
        }
    }

    /**
     * Renders the screen and all components.
     */
    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        font.draw(spriteBatch, "Main Menu Screen!", Application.WIDTH / 2, Application.HEIGHT / 2);
        spriteBatch.end();
    }

    /**
     * Updates the screen and all components.
     *
     * @param delta the change in time.
     */
    @Override
    public void update(float delta) {
        handleInput();
    }

    /**
     * Disposes the screen and all components.
     */
    @Override
    public void dispose() {
        font.dispose();
    }

}
