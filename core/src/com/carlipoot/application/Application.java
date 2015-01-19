package com.carlipoot.application;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.carlipoot.application.input.Input;
import com.carlipoot.application.manager.InputManager;
import com.carlipoot.application.manager.LevelManager;
import com.carlipoot.application.manager.ResourceManager;
import com.carlipoot.application.manager.ScreenManager;

/** The main class that is launched on Application startup.
 * <br><br>
 * This is the top most layer of the Application. All rendering calls originate from here.
 * @author Carlipoot */
public class Application implements ApplicationListener {

	/** The title of the Application. */
	public static final String TITLE = "Swivel Stick";

	/** The width of the screen. */
	public static final int WIDTH = 480;

	/** The height of the screen. */
	public static final int HEIGHT = 800;

	/** The scale of the screen. */
	public static final int SCALE = 1;

	/** The constant time step used for rendering and updating. */
	public static final float STEP = 1.0f / 60.0f;

	private float accumulator;

	private OrthographicCamera camera;
	private SpriteBatch spriteBatch;
	private World world;

	private InputManager inputManager;
	private LevelManager levelManager;
	private ResourceManager resourceManager;
	private ScreenManager screenManager;

	/** Called on Application startup. */
	@Override
	public void create () {
		// Initialise variables
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
		spriteBatch = new SpriteBatch();
		world = new World(new Vector2(0.0f, -1.0f), true);

		inputManager = new InputManager();
		levelManager = new LevelManager(this, world);
		resourceManager = new ResourceManager(this);
		screenManager = new ScreenManager(this);

		// Process variables
		Gdx.input.setInputProcessor(inputManager);
		resourceManager.loadAll();
		screenManager.pushScreen(ScreenManager.GAME);
	}

	/** Called when rendering. */
	@Override
	public void render () {
		accumulator += Gdx.graphics.getDeltaTime();

		while (accumulator >= STEP ) {
			accumulator -= STEP;
			screenManager.update(STEP);
			screenManager.render();
			Input.update();
		}
	}

	/** Called on Application end. Cleans up all created objects. */
	@Override
	public void dispose() {

	}

	/** Called on screen resizing.
	 * @param width the new width.
	 * @param height the new height. */
	@Override
	public void resize(int width, int height) {}

	/** Called when Application loses focus. */
	@Override
	public void pause() {}

	/** Called when the Application gains focus. */
	@Override
	public void resume() {}


	/** Gets the OrthographicCamera.
	 * @return the OrthographicCamera. */
	public OrthographicCamera getCamera() {
		return camera;
	}

	/** Gets the main SpriteBatch.
	 * @return the SpriteBatch. */
	public SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}

	/** Gets the main World.
	 * @return the World. */
	public World getWorld() {
		return world;
	}

	/** Gets the LevelManager.
	 * @return the LevelManager. */
	public LevelManager getLevelManager() {
		return levelManager;
	}

	/** Gets the ResourceManager.
	 * @return the ResourceManager. */
	public ResourceManager getResourceManager() {
		return resourceManager;
	}

	/** Gets the ScreenManager.
	 * @return the ScreenManager. */
	public ScreenManager getScreenManager() {
		return screenManager;
	}

}
