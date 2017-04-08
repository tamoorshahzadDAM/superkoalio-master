package com.mygdx.game.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Tamoor
 */

public class AssetManager {

    public static Texture sheet;
    public static Music music;
    public static BitmapFont font;
    public static TextureRegion background;
    public static Texture koalaTexture;
    public static Sound winner;
    public static Sound gameOver;

    public static void load() {

        //Fons
        sheet = new Texture(Gdx.files.internal("koa.jpg"));
        sheet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        //Musica
        music = Gdx.audio.newMusic(Gdx.files.internal("tune.mp3"));
        music.setVolume(0.2f);
        music.setLooping(true);

        //Font
        FileHandle fontFile = Gdx.files.internal("space.fnt");
        font = new BitmapFont(fontFile, false);
        font.getData().setScale(1.4f);


        //fons de backgroung
        background = new TextureRegion(sheet, 0, 0, 2560, 1600);
        background.flip(false, false);

        //Texturas
        koalaTexture = new Texture("koalio.png");

        //Audio de cuando se gana
        winner = Gdx.audio.newSound(Gdx.files.internal("winner.wav"));
        winner.setVolume(1, 0.4f);
        winner.setLooping(1 ,false);

        //audio cuando se pierde
        gameOver = Gdx.audio.newSound(Gdx.files.internal("gameover.mp3"));
        gameOver.setVolume(1, 0.4f);
        gameOver.setLooping(1 ,false);
    }

    public static void dispose(){
        sheet.dispose();
        music.dispose();
    }

}
