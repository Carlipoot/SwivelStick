package com.carlipoot.game.manager;

import static com.carlipoot.game.input.Input.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

/**
 * Manages input from the device and/or peripherals, and redirects it to the application for handling.
 * @author Carlipoot
 */
public class InputManager extends InputAdapter {

    /**
     * Called when a key is pressed.
     * @param keycode the key that is pushed.
     * @return whether the key press was processed.
     */
    @Override
    public boolean keyDown (int keycode) {
        if ( keycode == Input.Keys.SPACE ) {
            setInput(SPACEBAR, true);
        }

        return true;
    }

    /**
     * Called when a key is released.
     * @param keycode the key that is released.
     * @return whether the key release was processed.
     */
    @Override
    public boolean keyUp (int keycode) {
        if ( keycode == Input.Keys.SPACE ) {
            setInput(SPACEBAR, false);
        }

        return true;
    }

    @Override
    public boolean touchDown (int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp (int screenX, int screenY, int pointer, int button) {
        return false;
    }

}
