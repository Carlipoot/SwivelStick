package com.carlipoot.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.carlipoot.game.input.Input;
import com.carlipoot.game.manager.InputManager;
import com.carlipoot.game.manager.ScreenManager;

/**
 * The main class that is launched on application startup.
 * <br><br>
 * This is the top most layer of the application. All rendering calls originate from here.
 * @author Carlipoot
 */
public class Application implements ApplicationListener {

	/**
	 * The title of the application.
	 */
	public static final String TITLE = "Swivel Stick";

	/**
	 * The width of the screen.
	 */
	public static final int WIDTH = 480;

	/**
	 * The height of the screen.
	 */
	public static final int HEIGHT = 800;

	/**
	 * The scale of the screen.
	 */
	public static final int SCALE = 1;

	/**
	 * The constant time step used for rendering and updating.
	 */
	public static final float STEP = 1 / 60f;


	private float accumulator;

	private SpriteBatch spriteBatch;
	private OrthographicCamera camera;

	private ScreenManager manager;

	/**
	 * Called on application startup.
	 */
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);

		manager = new ScreenManager(this);

		Gdx.input.setInputProcessor(new InputManager());
	}

	/**
	 * Called when rendering.
	 */
	@Override
	public void render () {
		accumulator += Gdx.graphics.getDeltaTime();

		while (accumulator >= STEP ) {
			accumulator -= STEP;
			manager.update(STEP);
			manager.render();
			Input.update();
		}
	}

	/**
	 * Called on application end. Cleans up all created objects.
	 */
	@Override
	public void dispose() {

	}

	/**
	 * Called on screen resizing.
	 * @param width the new width.
	 * @param height the new height.
	 */
	@Override
	public void resize(int width, int height) {}

	/**
	 * Called when application loses focus.
	 */
	@Override
	public void pause() {}

	/**
	 * Called when the application gains focus.
	 */
	@Override
	public void resume() {}

	/**
	 * Gets the main sprite batch.
	 * @return the sprite batch.
	 */
	public SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}

	/**
	 * Gets the main camera.
	 * @return the camera.
	 */
	public OrthographicCamera getCamera() {
		return camera;
	}
}
