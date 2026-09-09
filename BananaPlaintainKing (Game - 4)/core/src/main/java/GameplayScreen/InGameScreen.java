package GameplayScreen;

import Donkey.game.main;
import GameplayScreen.Object.Platform;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class InGameScreen implements Screen {
    main game;
    Platform platform;
    Player player;

    @Override
    public void show() {

    }

    public InGameScreen(main Game) {
        game = Game;
        setPlatform();
        player = new Player(100f,100f);
    }

    public void setPlatform() {
        float Space = 500f;
        for (int i = 1 ; i < 3 ; i++) {
            platform = new Platform(100f,50f);
        }

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        platform.render(game.shape);
        player.render(game.shape);
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
