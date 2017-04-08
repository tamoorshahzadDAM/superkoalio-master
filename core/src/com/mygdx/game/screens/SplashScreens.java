package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Koalio;
import com.mygdx.game.Superkoalio;
import com.mygdx.game.helpers.AssetManager;

/**
 * Created by Tamoor
 */

public class SplashScreens implements Screen {


    //Atributos
    private Stage stage;
    private Label.LabelStyle txtStyle;
    private final Koalio game;
    private Label txtLabel;
    private TextButton play;
    private TextButton exit;
    private TextButton.TextButtonStyle txtButtonStyle;
    private OrthographicCamera camera;


    /**
     * Constructor
     * @param game
     */
    public SplashScreens(final Koalio game) {
        this.game = game; //Inicializo

        //Muestro un log
        Gdx.app.log("Juego", "Pantalla Principal!!");

        //Crea una camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 30, 20);
        camera.update(); //actualiza la camara

        stage = new Stage(); //crea un stage

        // Afegim el fons
        stage.addActor(new Image(AssetManager.background));
        txtButtonStyle = new TextButton.TextButtonStyle();
        txtButtonStyle.font = AssetManager.font;

        //añado el texto para titulo
        txtStyle = new Label.LabelStyle(AssetManager.font, null);


        //Si es primera vez la pantalla principal muestra un mensaje con nombre de juego
        if (Superkoalio.first){

            txtLabel = new Label("Super Koalio", txtStyle);
            stage.addActor(txtLabel);

            //si es esta perdido, (cuando de sae la koala) se cierra el juego imprime, Game over con musica
        }else if (!(Superkoalio.gameState)) {

            txtLabel = new Label("GAME OVER", txtStyle);
            stage.addActor(txtLabel);


            //Si el usuario ha completado el nivel muestra ganado, con musica.
        } else if (Superkoalio.win){
            txtLabel = new Label(" Ganado ", txtStyle);
            stage.addActor(txtLabel);
        }




        //Pongo un boton para empezar a jugar y otro para salir de juego
        Container cont = new Container(txtLabel);
        cont.setTransform(true);
        cont.center();
        cont.setPosition(350, 350);
        cont.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(Actions.scaleTo(1.5f, 1.5f, 1), Actions.scaleTo(1, 1, 1))));

        //Muestro un nombre de  botton y creo una variable.
        play = new TextButton("Play", txtButtonStyle);
        exit = new TextButton("Exit", txtButtonStyle);

        //Cantainer de botton de play
        Container contPlay = new Container(play);

        contPlay.setTransform(true);
        contPlay.center();
        contPlay.setPosition(350, 250);

        //Container de botton de salir
        Container contExit = new Container(exit);

        contExit.setTransform(true);
        contExit.center();
        contExit.setPosition(350, 150);

        //Lo añado en la pantalla
        stage.addActor(cont);
        stage.addActor(contPlay);
        stage.addActor(contExit);


        //les doy funcion a cada botton.
        play.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                SplashScreens.this.game.setScreen(new Superkoalio(game));
            }
        });

        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        Gdx.input.setInputProcessor(stage);


    }



    //Methodoes overides

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        stage.draw();
        stage.act(delta);


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
