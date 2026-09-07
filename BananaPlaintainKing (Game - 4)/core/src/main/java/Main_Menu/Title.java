package Main_Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Title {
    private Texture texture;
    private TextureRegion region;
    private Vector2 position;
    private float rotation;
    private float animationTime;
    private float IntroPos;

    private static final float MAX_ROTATION = 8f;
    private static final float ROTATION_SPEED = 2f;

    public Title() {
        IntroPos = 10f;
        try {
            texture = new Texture("Main_MenuUI/TitleUp_MainMenu.png");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (texture != null) {
            region = new TextureRegion(texture);
            position = new Vector2(
                Gdx.graphics.getWidth() / 2f - texture.getWidth() / 2f,
                Gdx.graphics.getHeight() / 2f - texture.getHeight() / 2f + 30f
            );
        }
    }

    public void update(float delta) {
        animationTime += delta;
        rotation = MAX_ROTATION * (float) Math.sin(animationTime * ROTATION_SPEED);

    }

    public void IntroAnimation() {
        float animationDuration = 3f;
        float t = Math.min(1f, animationTime / animationDuration);
        float easedT = t * t * (3 - 2 * t);
        IntroPos = MathUtils.lerp(Gdx.graphics.getBackBufferHeight(), position.y, easedT);
        if (IntroPos < 0f) {
            IntroPos = 0f;
        }
    }

    public void render(SpriteBatch batch) {
        if (texture == null) return;
        IntroAnimation();
        float w = texture.getWidth();
        float h = texture.getHeight();
        batch.draw(region, position.x, position.y + IntroPos, w / 2f, h / 2f, w, h, 1f, 1f, rotation);
    }

    public float getHeight() {
        return texture != null ? texture.getHeight() : 0f;
    }

    public void dispose() {
        if (texture != null) {
            texture.dispose();
        }
    }
}
