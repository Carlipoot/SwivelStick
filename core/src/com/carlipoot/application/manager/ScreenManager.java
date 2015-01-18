package com.carlipoot.application.manager;

import com.carlipoot.application.Application;
import com.carlipoot.application.screen.*;
import com.carlipoot.application.util.IDHelper;

import java.util.Stack;

/**
 * Manages all screens of the Application.
 * <br><br>
 * This includes creating, rendering, updating and destroying the Screen.
 * @author Carlipoot
 */
public class ScreenManager {

    /**
     * ID for the main menu screen.
     */
    public static final int MENU = IDHelper.nextID();

    /**
     * ID for the level select screen.
     */
    public static final int PLAY = IDHelper.nextID();

    /**
     * ID for the credits screen.
     */
    public static final int CREDIT = IDHelper.nextID();

    /**
     * ID for the game screen.
     */
    public static final int GAME = IDHelper.nextID();


    private Application application;
    private Stack<Screen> screenStack;

    /**
     * Creates a ScreenManager with a reference to the Application.
     * @param application the Application reference.
     */
    public ScreenManager(Application application) {
        this.application = application;
        screenStack = new Stack<Screen>();
        pushScreen(GAME);
    }

    /**
     * Gets the Application reference.
     * @return the reference to the Application.
     */
    public Application getApplication() {
        return application;
    }

    private Screen getScreen(int screen) {
        if ( screen == MENU ) return new MenuScreen(this);
        if ( screen == PLAY ) return new PlayScreen(this);
        if ( screen == CREDIT ) return new CreditScreen(this);
        if ( screen == GAME ) return new GameScreen(this);
        return null;
    }

    /**
     * Removes the most recent Screen.
     */
    public void popScreen() {
        Screen screen = screenStack.pop();
        screen.dispose();
    }

    /**
     * Sets the current Screen to the specified Screen.
     * @param screen the ID of the Screen.
     */
    public void pushScreen(int screen) {
        screenStack.push(getScreen(screen));
    }

    /**
     * Swaps the current Screen to the specified Screen.
     * @param screen the ID of the Screen.
     */
    public void setScreen(int screen) {
        popScreen();
        pushScreen(screen);
    }

    /**
     * Renders the current Screen.
     */
    public void render() {
        screenStack.peek().render();
    }

    /**
     * Updates the current Screen.
     * @param delta the change in time.
     */
    public void update(float delta) {
        screenStack.peek().update(delta);
    }

}
