package Main_Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.Random;

public class Background {
    private float pisang_summon_interval;
    private ArrayList<Pisang> pisangFalls;
    private float[] PisangInScreen;
    private float[] corFalls;
    private Random random;

    public class Pisang {
        Vector2 positionPisang;
        Texture texturePisang;
        float randomValue;

        public Pisang(float x, float randomVal) {
            texturePisang = new Texture("Main_MenuUI/Pisang.png");
            positionPisang = new Vector2();
            this.positionPisang.x = x;
            this.positionPisang.y = Gdx.graphics.getHeight();
            this.randomValue = randomVal;
        }
        public void renderPisang(SpriteBatch batch) {
            batch.begin();
            batch.draw(texturePisang, positionPisang.x, positionPisang.y);
            batch.end();
        }
    }


    public Background() {
        corFalls = new float[]{0, 50, 180, 400, 900};
        PisangInScreen = new float[corFalls.length];
        pisang_summon_interval = 5f;
        pisangFalls = new ArrayList<>();
        random = new Random();
        
        for (int i = 0; i < PisangInScreen.length; i++) {
            PisangInScreen[i] = -1;
        }
    }

    public Pisang createRandomPisang() {
        int randomIndex = -1;
        float randomValue = -1;
        
        do {
            randomIndex = random.nextInt(corFalls.length);
            randomValue = corFalls[randomIndex];
        } while (PisangInScreen[randomIndex] != -1);
        
        PisangInScreen[randomIndex] = randomValue;
        float xPosition = randomValue * 2;
        return new Pisang(xPosition, randomValue);
    }

    public void render(SpriteBatch batch) {
        float delta = Gdx.graphics.getDeltaTime();

        for (int i = pisangFalls.size() - 1; i >= 0; i--) {
            Pisang x = pisangFalls.get(i);
            x.positionPisang.y -= delta * 400;
            x.renderPisang(batch);

            if (x.positionPisang.y < -Gdx.graphics.getHeight() + 50) {
                for (int j = 0; j < PisangInScreen.length; j++) {
                    if (PisangInScreen[j] == x.randomValue) {
                        PisangInScreen[j] = -1;
                        break;
                    }
                }
                pisangFalls.remove(i);
            }
        }

        if (pisang_summon_interval < 0) {
            pisangFalls.add(createRandomPisang());
            pisang_summon_interval = 1;
        }
        else {
            pisang_summon_interval -= delta;
        }
    }
}
