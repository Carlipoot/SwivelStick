package com.carlipoot.application.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/** A convenience class for animations.
 * @author Carlipoot */
public class Animation {

    private com.badlogic.gdx.graphics.g2d.Animation animation;

    private TextureRegion[] animationFrames;
    private Texture textureSheet;

    private int cols;
    private int rows;
    private float duration;

    /** Creates and Animation.
     * @param animationTexture the Animations Texture.
     * @param cols number of columns.
     * @param rows number of rows.
     * @param duration duration for each frame. */
    public Animation(Texture animationTexture, int cols, int rows, float duration) {
        this.textureSheet = animationTexture;
        this.cols = cols;
        this.rows = rows;
        this.duration = duration;

        TextureRegion[][] tmp = TextureRegion.split(
                animationTexture,
                animationTexture.getWidth()/cols,
                animationTexture.getHeight()/rows);

        animationFrames = new TextureRegion[cols * rows];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                animationFrames[index++] = tmp[i][j];
            }
        }

        animation = new com.badlogic.gdx.graphics.g2d.Animation(duration, animationFrames);
    }

    /** Gets the current TextureRegion.
     * @param time total time passed.
     * @return the current TextureRegion. */
    public TextureRegion getTextureRegion(float time) {
        return animation.getKeyFrame(time, true);
    }

}
