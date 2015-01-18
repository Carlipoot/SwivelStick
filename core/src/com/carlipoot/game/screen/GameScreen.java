package com.carlipoot.game.screen;

import static com.carlipoot.game.util.B2DHelper.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.utils.Array;
import com.carlipoot.game.Application;
import com.carlipoot.game.input.Input;
import com.carlipoot.game.manager.ScreenManager;

/**
 * The screen that displays all entities in the level.
 * @author Carlipoot
 */
public class GameScreen extends Screen {

    Box2DDebugRenderer debug;
    World world;
    BodyDef bodyDef;
    OrthographicCamera b2dCamera;
    Body body, body2, body3;
    Joint joint;
    RevoluteJointDef jointDef;

    /**
     * Creates a new scene with a scene manager and sets all references.
     *
     * @param screenManager the screen manager to manage the screen.
     */
    public GameScreen(ScreenManager screenManager) {
        super(screenManager);

        debug = new Box2DDebugRenderer();
        world = new World(new Vector2(0.0f, 0f), true);

        // Create Ball
        bodyDef = new BodyDef();
        bodyDef.position.set(toMeters(Application.WIDTH / 2), toMeters(Application.HEIGHT / 2));
        bodyDef.type = BodyDef.BodyType.StaticBody;
        body = world.createBody(bodyDef);

        CircleShape shape2 = new CircleShape();
        shape2.setRadius(toMeters(20));
        FixtureDef fixDef = new FixtureDef();
        fixDef.shape = shape2;
        fixDef.density = 1.0f;

        body.createFixture(fixDef);

        // Create second ball
        bodyDef.position.set(toMeters(Application.WIDTH / 2 + 100), toMeters(Application.HEIGHT / 2));
        body3 = world.createBody(bodyDef);
        body3.createFixture(fixDef);

        // Create Player
        bodyDef.position.set(toMeters(Application.WIDTH / 2), toMeters(Application.HEIGHT / 2 + 50));
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        body2 = world.createBody(bodyDef);

        fixDef.restitution = 0.6f;
        fixDef.friction = 0.01f;
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(toMeters(10), toMeters(25));
        fixDef.shape = shape;
        body2.createFixture(fixDef);

        // Create joint
        jointDef = new RevoluteJointDef();
        jointDef.initialize(body, body2, body.getWorldCenter());
        jointDef.collideConnected = false;
        jointDef.motorSpeed = 5f;
        jointDef.maxMotorTorque = 5f;
        jointDef.enableMotor = true;
        joint = world.createJoint(jointDef);


        // Set data
        body.setUserData("ball");
        body2.setUserData("rec");
        body3.setUserData("ball");

        // Apply initial force
//        body2.applyForceToCenter(10f, 0f, true);

        // Create camera for b2d
        b2dCamera = new OrthographicCamera();
        b2dCamera.setToOrtho(false, toMeters(Application.WIDTH), toMeters(Application.HEIGHT));
    }

    /**
     * Checks inputs and processes accordingly.
     */
    @Override
    public void handleInput() {
        if ( Input.isPressed(Input.SPACEBAR) ) {
            Body ba = joint.getBodyA();
            Body bb = joint.getBodyB();

            world.destroyJoint(joint);

            Array<Body> bodies = new Array<Body>();
            world.getBodies(bodies);

            Body newBody = null;
            for (Body b : bodies) {
                if (b != ba && b != bb) {
                    newBody = b;
                    break;
                }
            }


            if (ba.getUserData().equals("rec")) {
                jointDef.initialize(newBody, ba, newBody.getWorldCenter());
            } else {
                jointDef.initialize(newBody, bb, newBody.getWorldCenter());
            }

            jointDef.collideConnected = false;
            jointDef.motorSpeed = -jointDef.motorSpeed;
//            jointDef.maxMotorTorque = -jointDef.maxMotorTorque;
            jointDef.enableMotor = true;
            joint = world.createJoint(jointDef);
            screenManager.pushScreen(ScreenManager.MENU);
        }
    }

    /**
     * Renders the screen and all components.
     */
    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        debug.render(world, b2dCamera.combined);
    }

    /**
     * Updates the screen and all components.
     *
     * @param delta the change in time.
     */
    @Override
    public void update(float delta) {
        handleInput();
        world.step(delta, 10, 8);
        b2dCamera.update();
    }

    /**
     * Disposes the screen and all components.
     */
    @Override
    public void dispose() {

    }

}
