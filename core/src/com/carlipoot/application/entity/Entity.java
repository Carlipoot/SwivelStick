package com.carlipoot.application.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.carlipoot.application.Application;
import com.carlipoot.application.manager.LevelManager;
import com.carlipoot.application.manager.ResourceManager;
import com.carlipoot.application.model.Model;
import com.carlipoot.application.util.Box2DHelper;

/** An abstract class that defines an entity.
 * @author Carlipoot */
public abstract class Entity extends Actor implements Disposable {

    /** A reference to the LevelManager. */
    protected LevelManager levelManager;

    /** A reference to the ResourceManager. */
    protected ResourceManager resourceManager;

    /** A reference the Body created in the World. */
    protected Body body;

    /** The Model that creates the Entity in the World. */
    protected Model model;

    /** The Texture of the Entity. */
    protected Texture texture;

    /** The TextureRegion of the Entity. */
    protected TextureRegion textureRegion;

    private Application application;

    /** Creates an Entity with a reference to the LevelManager at the specified position.
     * @param levelManager the LevelManager reference.
     * @param x the horizontal position.
     * @param y the vertical position. */
    public Entity(LevelManager levelManager, int x, int y) {
        this.levelManager = levelManager;
        application = levelManager.getApplication();
        resourceManager = application.getResourceManager();

        setPosition(x, y);
        body = null;
        model = null;
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
        if ( getTexture() != null ) draw(spriteBatch, getTexture());
        else if ( getTextureRegion() != null ) draw(spriteBatch, getTextureRegion());
    }

    /** Creates the Entity in the given World.
     * @param world the World to create the Entity in. */
    public abstract void create(World world);

    /** Gets the Texture of the Entity.
     * @return the Texture of the Entity*/
    public Texture getTexture() {
        return texture;
    }

    /** Gets the TextureRegion of the Entity.
     * @return the TextureRegion of the Entity*/
    public TextureRegion getTextureRegion() {
        return textureRegion;
    }

    /** Sets the Texture of the entity.
     * @param texture the Texture.*/
    public void setTexture(Texture texture) {
        if ( texture != null ) {
            this.texture = texture;
            setSize(texture.getWidth(), texture.getHeight());
            setOrigin(texture.getWidth() / 2, texture.getHeight() / 2);
        }
    }

    /** Sets the TextureRegion of the entity.
     * @param textureRegion the TextureRegion.*/
    public void setTextureRegion(TextureRegion textureRegion) {
        if ( textureRegion != null ) {
            this.textureRegion = textureRegion;
            setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
            setOrigin(textureRegion.getRegionWidth() / 2, textureRegion.getRegionHeight() / 2);
        }
    }

    /** Updates the Entity.
     * @param delta the change in time. */
    public void update(float delta) {
        if ( body != null ) {
            setPosition(Box2DHelper.toPixels(body.getPosition().x) - getWidth() / 2, Box2DHelper.toPixels(body.getPosition().y) - getHeight() / 2);
            setRotation(body.getAngle() * MathUtils.radiansToDegrees);
        }
    }

    /** Disposes of all objects. */
    @Override
    public void dispose() {
        levelManager.getWorld().destroyBody(body);
    }

}
