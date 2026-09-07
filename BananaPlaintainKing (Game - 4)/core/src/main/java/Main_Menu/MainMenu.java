package Main_Menu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import Donkey.game.main;

public class MainMenu implements Screen {
    private main game;
    private Vector2 StarTextPos;
    private Background background;

    @Override
    public void show() {
        System.out.println("Screen ON : MainMenu");
        background = new Background();
        StarTextPos = new Vector2(
            Gdx.graphics.getWidth() / 2 - 200f/2,
            Gdx.graphics.getHeight() / 2 - game.title.getHeight() / 3);
    }

    public MainMenu(main game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        background.render(game.batch);
        game.title.update(delta);
        game.batch.begin();
        game.title.render(game.batch);
        game.batch.end();

        game.shape.begin(ShapeRenderer.ShapeType.Filled);
        game.shape.setColor(Color.BLUE);
        game.shape.rect(
            StarTextPos.x,
            StarTextPos.y,
            200f,50f);
        game.shape.end();

        if (Gdx.input.justTouched()) {
            if ((Gdx.input.getX() > StarTextPos.x && Gdx.input.getX() < StarTextPos.x + 200)
                &&
                (Gdx.input.getY() > StarTextPos.y)) {
                System.out.println("Warping GamePlay");
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        this.game.dispose();
    }
}
