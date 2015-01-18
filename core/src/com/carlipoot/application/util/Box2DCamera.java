package com.carlipoot.application.util;

import com.badlogic.gdx.graphics.OrthographicCamera;

import static com.carlipoot.application.util.Box2DHelper.toMeters;

/** A convenient OrthographicCamera made for Box2D.
 * @author Carlipoot */
public class Box2DCamera extends OrthographicCamera {

    public Box2DCamera() {
        super();
    }

    public void setToOrtho (boolean yDown, int viewportWidth, int viewportHeight) {
        super.setToOrtho(yDown, toMeters(viewportWidth), toMeters(viewportHeight));
    }

}
