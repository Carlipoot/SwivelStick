package com.carlipoot.application.manager;

import com.badlogic.gdx.utils.Array;
import com.carlipoot.application.Application;
import com.carlipoot.application.entity.Entity;

/** Manages all entities in the application.
 * @author Carlipoot */
public class EntityManager {

    private Application application;

    private Array<Entity> entities;

    /** Creates an EntityManager with a reference to the Application.
     * @param application the Application reference. */
    public EntityManager(Application application) {
        this.application = application;

        entities = new Array<Entity>();
    }

    /** Gets the Application reference.
     * @return the reference to the Application. */
    public Application getApplication() {
        return application;
    }

    /** Adds Entity to the EntityManager.
     * @param entity the Entity to manage. */
    public void add(Entity entity) {
        entities.add(entity);
    }

    /** Removes Entity from the EntityManager.
     * @param entity the Entity to remove. */
    public void remove(Entity entity) {
        entity.dispose();
        entities.removeValue(entity, true);
    }

    /** Updates every Entity. */
    public void update(float delta) {
        for ( Entity entity : entities ) {
            if ( entity != null ) entity.update(delta);
        }
    }

}
