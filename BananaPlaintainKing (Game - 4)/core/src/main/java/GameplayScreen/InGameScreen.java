package GameplayScreen;

import Donkey.game.main;
import GameplayScreen.Object.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class InGameScreen implements Screen {
    main game;
    Platform platform;
    Ladder ladder;
    Player player;
    ArrayList<Ladder> ladders;
    ArrayList<Platform> platforms;

    @Override
    public void show() {

    }

    public InGameScreen(main Game) {
        game = Game;
        ladders = new ArrayList<>();
        platforms = new ArrayList<>();
        setMap();
        player = new Player(100f,100f);
    }

    public void setMap() {
        float Space = 0;
        //Set Plaform
        for (int i = 1 ; i < 4 ; i++) {
            platform = new Platform(100f,50f + Space);
            platforms.add(platform);
            Space += 190f;
        }
        Space = 0;
        //Set ladder
        boolean zigzag = true;
        float x_ladder = 200f;
        float setXLadder = 0f;
        for (int i = 1 ; i < 4 ; i++) {
            if (zigzag) {
                setXLadder = Gdx.graphics.getWidth() - x_ladder;
                zigzag = false;
            } else {
                 setXLadder = x_ladder ;
                 zigzag = true;
            }
            ladder = new Ladder(setXLadder,50f + Space);
            Space += 190f;
            ladders.add(ladder);
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        player.update(delta, platforms,ladders);
        for (Platform platform : platforms) {
            platform.render(game.shape);
        }
        for  (Ladder ladder : ladders) {
            ladder.render(game.shape);
        }
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
        game.dispose();
    }
}
