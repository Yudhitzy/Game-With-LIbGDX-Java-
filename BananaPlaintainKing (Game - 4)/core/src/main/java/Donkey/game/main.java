package Donkey.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import Main_Menu.MainMenu;
import Main_Menu.Title;



/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class main extends Game {

    public SpriteBatch batch;

    public BitmapFont Setfont;
    public ShapeRenderer shape;

    public Title title;


    @Override
    public void create() {
        batch = new SpriteBatch();
        Setfont = new BitmapFont();
        shape = new ShapeRenderer();
        title = new Title();
        this.setScreen(new MainMenu(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        if (title != null) {
            title.dispose();
        }
        batch.dispose();
        Setfont.dispose();
    }
}
