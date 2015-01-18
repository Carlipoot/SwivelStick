package com.carlipoot.application.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.Application;
import com.carlipoot.application.manager.EntityManager;
import com.carlipoot.application.manager.ScreenManager;

import static com.carlipoot.application.util.B2DHelper.toMeters;

/**
 * The Screen that displays every Entity in the level.
 * @author Carlipoot
 */
public class GameScreen extends Screen {

    private EntityManager entityManager;
    private OrthographicCamera worldCamera;

    private Box2DDebugRenderer worldRenderer;
    private World world;

    /**
     * Creates a new Screen with a ScreenManager and sets all references.
     *
     * @param screenManager the ScreenManager to manage the Screen.
     */
    public GameScreen(ScreenManager screenManager) {
        super(screenManager);

        entityManager = application.getEntityManager();

        // Create the world camera
        worldCamera = new OrthographicCamera();
        worldCamera.setToOrtho(false, toMeters(Application.WIDTH), toMeters(Application.HEIGHT));

        // Create the world renderer
        worldRenderer = new Box2DDebugRenderer();

        // New world with no gravity and renderer
        world = new World(new Vector2(0.0f, 0.0f), true);
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
        clearScreen(Color.WHITE);

        // Render the world
        worldRenderer.render(world, worldCamera.combined);
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
