package com.carlipoot.application.manager;

import com.badlogic.gdx.assets.AssetManager;
import com.carlipoot.application.Application;
import com.carlipoot.application.util.Resources;

/**
 * Holds all resources used by the Application.
 * @author Carlipoot
 */
public class ResourceManager extends AssetManager {

    private Application application;

    /**
     * Creates a ResourceManager with a reference to the Application.
     * @param application the Application reference.
     */
    public ResourceManager(Application application) {
        super();

        this.application = application;
    }

    /**
     * Loads all resources.
     */
    public void loadAll() {
        load(Resources.player);
    }

}
