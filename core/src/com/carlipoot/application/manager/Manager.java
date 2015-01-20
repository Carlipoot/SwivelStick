package com.carlipoot.application.manager;

import com.carlipoot.application.Application;

/** An abstract class that defines a manager
 * @author Carlipoot */
public abstract class Manager {

    private Application application;

    /** Creates a EntityManager with a reference to the Application.
     * @param application the Application reference. */
    public Manager(Application application) {
        this.application = application;
    }

    /** Gets the Application reference.
     * @return the reference to the Application. */
    public Application getApplication() {
        return application;
    }

}
