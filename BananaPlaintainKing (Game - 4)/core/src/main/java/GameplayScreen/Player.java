package GameplayScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Player {
    final static private float width = 30f;
    final static private float height = 56f;
    private Vector2 position;



    public Player(float x, float y) {
        position = new Vector2(x, y);
    }

    public void CheckPlatform() {

    }


    public void render(ShapeRenderer shape) {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.GREEN);
        shape.rect(position.x, position.y, width, height);
        shape.end();
    }
}
