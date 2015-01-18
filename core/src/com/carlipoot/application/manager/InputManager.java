package com.carlipoot.application.manager;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import static com.carlipoot.application.input.Input.SPACEBAR;
import static com.carlipoot.application.input.Input.setInput;

/** Manages input from the device and/or peripherals, and redirects it to the Application for handling.
 * @author Carlipoot */
public class InputManager extends InputAdapter {

    /** Called when a key is pressed.
     * @param keycode the key that is pushed.
     * @return whether the key press was processed. */
    @Override
    public boolean keyDown (int keycode) {
        if ( keycode == Input.Keys.SPACE ) {
            setInput(SPACEBAR, true);
        }

        return true;
    }

    /** Called when a key is released.
     * @param keycode the key that is released.
     * @return whether the key release was processed. */
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
