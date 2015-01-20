package com.carlipoot.application.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.carlipoot.application.manager.EntityManager;
import com.carlipoot.application.model.Model;
import com.carlipoot.application.util.Animation;
import com.carlipoot.application.util.Box2DHelper;

/** An abstract class that defines an entity.
 * @author Carlipoot */
public abstract class Entity extends Actor implements Disposable {

    /** A reference to the EntityManager. */
    protected EntityManager entityManager;

    /** A reference the Body created in the World. */
    protected Body body;

    /** The Model that creates the Entity in the World. */
    protected Model model;

    /** The Texture of the Entity. */
    protected Texture texture;

    /** The Animation of the Entity. */
    protected Animation animation;

    /** Creates an Entity with a reference to the EntityManager.
     * @param entityManager the LevelManager reference.
     * @param texture the Texture for the Entity. */
    public Entity(EntityManager entityManager, Texture texture) {
        this.entityManager = entityManager;
        this.texture = texture;

        setSize(texture.getWidth(), texture.getHeight());
        setOrigin(texture.getWidth() / 2, texture.getHeight() / 2);
    }

    /** Creates an Entity with a reference to the EntityManager.
     * @param entityManager the LevelManager reference.
     * @param animation the Animation for the Entity. */
    public Entity(EntityManager entityManager, Animation animation) {
        this.entityManager = entityManager;
        this.animation = animation;

        setSize(animation.getTextureRegion().getRegionWidth(), animation.getTextureRegion().getRegionHeight());
        setOrigin(animation.getTextureRegion().getRegionWidth() / 2, animation.getTextureRegion().getRegionHeight() / 2);
    }

    /** Sets the Body reference to the Entity.
     * @param body the reference to the Body. */
    public void setBody(Body body) {
        this.body = body;
    }

    /** Draw the Entity.
     * @param spriteBatch the SpriteBatch used to draw it.
     * @param texture the Texture to draw. */
    public void draw(SpriteBatch spriteBatch, Texture texture) {
        spriteBatch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation(), 0, 0, texture.getWidth(), texture.getHeight(), false, false );
    }

    /** Draw the Entity.
     * @param spriteBatch the SpriteBatch used to draw it.
     * @param texture the TextureRegion to draw. */
    public void draw(SpriteBatch spriteBatch, TextureRegion texture) {
        spriteBatch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    /** Renders the Entity.
     * @param spriteBatch the SpriteBatch used for rendering. */
    public void render(SpriteBatch spriteBatch) {
        if ( texture != null ) draw(spriteBatch, texture);
        else if ( animation != null ) draw(spriteBatch, animation.getTextureRegion());
    }

    /** Creates the Entity in the given World.
     * @param world the World to create the Entity in.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public abstract void create(World world, float x, float y);


    /** Updates the Entity.
     * @param delta the change in time. */
    public void update(float delta) {
        if ( body != null ) {
            setPosition(Box2DHelper.toPixels(body.getPosition().x) - getWidth() / 2, Box2DHelper.toPixels(body.getPosition().y) - getHeight() / 2);
            setRotation(body.getAngle() * MathUtils.radiansToDegrees);
        }

        if ( animation != null ) {
            animation.update(delta);
        }
    }

    /** Disposes of all objects. */
    @Override
    public void dispose() {
        if ( body != null )  body.getWorld().destroyBody(body);
    }

}
