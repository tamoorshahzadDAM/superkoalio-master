package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.helpers.AssetManager;
import com.mygdx.game.screens.SplashScreens;


/**
 * Created by Tamoor
 */
public class Koalio extends Game {

    @Override
    public void create() {
        AssetManager.load();
        setScreen(new SplashScreens(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetManager.dispose();
    }
}