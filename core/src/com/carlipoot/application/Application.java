package com.carlipoot.application;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.carlipoot.application.input.Input;
import com.carlipoot.application.manager.EntityManager;
import com.carlipoot.application.manager.InputManager;
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

	private SpriteBatch spriteBatch;
	private OrthographicCamera camera;

	private EntityManager entityManager;
	private ResourceManager resourceManager;
	private ScreenManager screenManager;

	/** Called on Application startup. */
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);

		entityManager = new EntityManager(this);
		resourceManager = new ResourceManager(this);
		screenManager = new ScreenManager(this);

		Gdx.input.setInputProcessor(new InputManager());
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

	/** Gets the EntityManager.
	 * @return the EntityManager. */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/** Gets the ResourceManager.
	 * @return the ResourceManager. */
	public ResourceManager getResourceManager() {
		return resourceManager;
	}

	/** Gets the main SpriteBatch.
	 * @return the SpriteBatch. */
	public SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}

	/** Gets the OrthographicCamera.
	 * @return the OrthographicCamera. */
	public OrthographicCamera getCamera() {
		return camera;
	}

}
