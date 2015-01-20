package com.carlipoot.application.manager;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.carlipoot.application.Application;
import com.carlipoot.application.entity.Entity;
import com.carlipoot.application.entity.EntityPin;
import com.carlipoot.application.entity.EntityPlayer;
import com.carlipoot.application.util.Animation;
import com.carlipoot.application.util.IDHelper;
import com.carlipoot.application.util.Resources;

/** Manages all entities of the Application.
 * <br><br>
 * This includes creating, rendering, updating and destroying the Entity.
 * @author Carlipoot */
public class EntityManager extends Manager {

    /** ID for the player. */
    public static final int PLAYER = IDHelper.nextID();

    /** ID for the pin. */
    public static final int PIN = IDHelper.nextID();

    private Array<Entity> entities;
    private SpriteBatch spriteBatch;

    /** Creates a EntityManager with a reference to the Application.
     * @param application the Application reference. */
    public EntityManager(Application application) {
        super(application);

        entities = new Array<Entity>();
        spriteBatch = application.getSpriteBatch();
    }

    private Entity getEntity(int entity) {
        if ( entity == PLAYER ) return new EntityPlayer(this, getTexture(Resources.playerTexture));
        if ( entity == PIN ) return new EntityPin(this, new Animation(getTexture(Resources.exampleAnimation), 6, 5, 0.05f));
        return null;
    }

    private Texture getTexture(AssetDescriptor resource) {
        return (Texture)getApplication().getResourceManager().get(resource);
    }

    /** Creates an Entity with the specified properties.
     * @param entity the ID of the Entity,
     * @param world the World it should be created in.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public void createEntity(int entity, World world, int x, int y) {
        Entity newEntity = getEntity(entity);
        if ( newEntity != null ) {
            entities.add(newEntity);
            newEntity.create(world, x, y);
        }
    }

    /** Renders every Entity. */
    public void render() {
        for ( Entity entity : entities) {
            if ( entity != null ) entity.render(spriteBatch);
        }
    }

    /** Updates every Entity in the Level.
     * @param delta the change in time.*/
    public void update(float delta) {
        for ( Entity entity : entities) {
            if ( entity != null ) entity.update(delta);
        }
    }

    /** Disposes of every Entity. */
    public void disposeEntities() {
        for ( Entity entity : entities) {
            if ( entity != null ) entity.dispose();
        }
    }

}
