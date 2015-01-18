package com.carlipoot.game.manager;

import com.carlipoot.game.Application;
import com.carlipoot.game.screen.*;
import java.util.Stack;

/**
 * Manages all screens of the application.
 * <br><br>
 * This includes creating, rendering, updating and destroying the screens.
 * @author Carlipoot
 */
public class ScreenManager {

    private Application application;

    private Stack<Screen> screenStack;

    /**
     * ID for the main menu screen.
     */
    public static final int MENU = 10000;

    /**
     * ID for the level select screen.
     */
    public static final int PLAY = 10001;

    /**
     * ID for the credits screen.
     */
    public static final int CREDIT = 10002;

    /**
     * ID for the level screen.
     */
    public static final int LEVEL = 10003;

    /**
     * Creates a screen manager with a reference to the application.
     * @param application the application reference.
     */
    public ScreenManager(Application application) {
        this.application = application;
        screenStack = new Stack<Screen>();
        pushScreen(LEVEL);
    }

    /**
     * Gets the application reference.
     * @return the reference to the application.
     */
    public Application getApplication() {
        return application;
    }

    private Screen getScreen(int screen) {
        if ( screen == MENU ) return new MenuScreen(this);
        if ( screen == PLAY ) return new PlayScreen(this);
        if ( screen == CREDIT ) return new CreditScreen(this);
        if ( screen == LEVEL ) return new GameScreen(this);
        return null;
    }

    /**
     * Removes the most recent screen.
     */
    public void popScreen() {
        Screen screen = screenStack.pop();
        screen.dispose();
    }

    /**
     * Sets the current screen to the specified screen.
     * @param screen the ID of the screen.
     */
    public void pushScreen(int screen) {
        screenStack.push(getScreen(screen));
    }

    /**
     * Swaps the current screen to the specified screen.
     * @param screen the ID of the screen.
     */
    public void setScreen(int screen) {
        popScreen();
        pushScreen(screen);
    }

    /**
     * Renders the current screen.
     */
    public void render() {
        screenStack.peek().render();
    }

    /**
     * Updates the current screen.
     * @param delta the change in time.
     */
    public void update(float delta) {
        screenStack.peek().update(delta);
    }

}
