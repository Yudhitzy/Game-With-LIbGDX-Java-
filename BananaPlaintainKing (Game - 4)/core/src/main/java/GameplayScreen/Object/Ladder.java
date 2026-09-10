package GameplayScreen.Object;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Ladder {
    Vector2 position;

    final static private float width = 19f;
    final static private float height = 200f;

    public Ladder(float x, float y) {
        position = new Vector2(x, y);
    }

    public void render(ShapeRenderer shape) {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.BROWN);
        shape.rect(position.x, position.y, width, height);
        shape.end();
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
