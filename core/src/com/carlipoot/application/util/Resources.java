package com.carlipoot.application.util;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

/** A utility class that holds the descriptions of all resources.
 * @author Carlipoot */
public class Resources {

    /** An array of all resources */
    public static final Array<AssetDescriptor> resources = new Array<AssetDescriptor>();

    // Textures
    public static final AssetDescriptor playerTexture = new AssetDescriptor("texture\\player.png", Texture.class);
    public static final AssetDescriptor pinTexture = new AssetDescriptor("texture\\pin.png", Texture.class);

    // Animations
    public static final AssetDescriptor pinAnimation = new AssetDescriptor("animation\\pin.png", Texture.class);
    public static final AssetDescriptor exampleAnimation = new AssetDescriptor("animation\\example.png", Texture.class);


    static {
        resources.addAll(
                playerTexture,
                pinTexture,
                pinAnimation,
                exampleAnimation
        );
    }

}
