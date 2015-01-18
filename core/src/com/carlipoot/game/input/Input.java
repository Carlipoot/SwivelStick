package com.carlipoot.game.input;

/**
 * The state of the inputs handled by the application.
 * @author Carlipoot
 */
public class Input {

    private static boolean[] input;
    private static boolean[] prevInput;

    private static final int NUM_INPUT = 2;

    /**
     * ID of the spacebar key.
     */
    public static final int SPACEBAR = 0;

    /**
     * ID of the touch gesture.
     */
    public static final int TOUCH = 1;

    static {
        input = new boolean[NUM_INPUT];
        prevInput = new boolean[NUM_INPUT];
    }

    /**
     * Updates the input states.
     */
    public static void update() {
        for ( int i = 0; i < NUM_INPUT; i++ ) {
            prevInput[i] = input[i];
        }
    }

    /**
     * Is the input currently active.
     * @param id the ID of the input.
     * @return whether the input is currently pressed down.
     */
    public static boolean isDown(int id) {
        return input[id];
    }

    /**
     * Is the input pressed. This activates only once and deactivates when let go.
     * @param id the ID of the input.
     * @return whether the input is pressed once.
     */
    public static boolean isPressed(int id) {
        return input[id] && !prevInput[id];
    }

    /**
     * Sets the current state of the input.
     * @param id the ID of the input.
     * @param state the state of the input.
     */
    public static void setInput(int id, boolean state) {
        input[id] = state;
    }

}
