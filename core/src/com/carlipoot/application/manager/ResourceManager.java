package com.carlipoot.application.manager;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.carlipoot.application.util.Resources;

/** Holds all resources used by the Application.
 * @author Carlipoot */
public class ResourceManager extends AssetManager {

    /** Creates a ResourceManager */
    public ResourceManager() {
        super();
    }

    /** Loads all resources. */
    public void loadAll() {
        if ( Resources.resources == null ) return;

        for (AssetDescriptor resource : Resources.resources ) {
            load(resource);
        }

        finishLoading();
    }

}
