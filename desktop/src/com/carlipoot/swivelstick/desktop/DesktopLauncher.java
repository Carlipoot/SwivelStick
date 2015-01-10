package com.carlipoot.swivelstick.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.carlipoot.swivelstick.SwivelStick;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Swivel Stick";
		config.width = 480;
		config.height = 800;

		new LwjglApplication(new SwivelStick(), config);
	}
}
