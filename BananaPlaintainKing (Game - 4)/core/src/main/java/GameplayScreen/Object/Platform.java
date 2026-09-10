package GameplayScreen.Object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Platform {
    private static final float widthplatform = Gdx.graphics.getWidth() - 200f ;
    private static final float heightplatform = 10f ;
    private Vector2 position;

    public Platform(float x, float y) {
        position = new Vector2(x, y);
    }

    public void render(ShapeRenderer shape) {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.BLUE);
        shape.rect(position.x,position.y,widthplatform,heightplatform);
        shape.end();
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getWidthplatform() {
        return widthplatform;
    }

    public float getHeightplatform() {
        return heightplatform;
    }

}
