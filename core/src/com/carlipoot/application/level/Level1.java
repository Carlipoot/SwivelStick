package com.carlipoot.application.level;

import com.carlipoot.application.Application;
import com.carlipoot.application.entity.EntityPin;
import com.carlipoot.application.entity.EntityPlayer;
import com.carlipoot.application.manager.LevelManager;

/** The first Level of the game
 * @author Carlipoot */
public class Level1 extends Level {

    /** Creates a new Level with a reference to the LevelManager.
     * @param levelManager the LevelManger reference.*/
    public Level1(LevelManager levelManager) {
        super(levelManager);

        entities.add(new EntityPlayer(levelManager, 150, 200));
        entities.add(new EntityPlayer(levelManager, 200, 400));
        entities.add(new EntityPlayer(levelManager, 250, 800));
        entities.add(new EntityPin(levelManager, Application.WIDTH / 2, 20));
    }
}
