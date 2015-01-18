package com.carlipoot.application.manager;

import com.carlipoot.application.Application;

/**
 * Manages all entities in the application.
 * @author Carlipoot
 */
public class EntityManager {

    private Application application;

    /**
     * Creates an EntityManager with a reference to the Application.
     * @param application the Application reference.
     */
    public EntityManager(Application application) {
        this.application = application;
    }

    /**
     * Gets the Application reference.
     * @return the reference to the Application.
     */
    public Application getApplication() {
        return application;
    }

}
