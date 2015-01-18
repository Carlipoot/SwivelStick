package com.carlipoot.application.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.carlipoot.application.Application;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Application.TITLE;
		config.width = Application.WIDTH * Application.SCALE;
		config.height = Application.HEIGHT * Application.SCALE;

		new LwjglApplication(new Application(), config);
	}
}
