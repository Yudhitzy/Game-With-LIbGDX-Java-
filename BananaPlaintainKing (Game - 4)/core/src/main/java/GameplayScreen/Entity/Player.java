package GameplayScreen;

import GameplayScreen.Object.Ladder;
import GameplayScreen.Object.Platform;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

public class Player {
    final static private float width = 30f;
    final static private float height = 56f;
    private Vector2 position;
    private Vector2 velocity;
    private boolean onGround;
    private boolean CanLadder;
    private boolean OnLadder;

    private static final float MOVE_SPEED = 170f;
    private static final float JUMP_VELOCITY = 330f;
    private static final float GRAVITY = -1200f;

    public Player(float x, float y) {
        position = new Vector2(x, y);
        velocity = new Vector2(0,0);
        onGround = false;
        CanLadder = false;
    }


    public void update(float delta, List<Platform> platforms,List<Ladder> ladders) {
        float move = 0f;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) move -= 1f;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) move += 1f;
        position.x += move * MOVE_SPEED * delta;

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && onGround) {
            velocity.y = JUMP_VELOCITY;
            onGround = false;
        }

        CanLadder = false;
        for (Ladder l :ladders) {
            Vector2 pos = l.getPosition();
            float width_ladders = l.getWidth();
            float height_ladders = l.getHeight();
            if (position.x + width > pos.x + 10f && position.x + 10f < pos.x + width_ladders) {
                if (position.y + height > pos.y + 10f && position.y < pos.y + height_ladders + 10f) {
                    CanLadder = true;
                }
            }
        }

        if (CanLadder) {
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                move += 1;
                position.y += move * MOVE_SPEED * delta;
            }
            return;
        }

        velocity.y += GRAVITY * delta;
        float oldY = position.y;
        position.y += velocity.y * delta;
        onGround = false;

        for (Platform p : platforms) {
            float px = p.getPosition().x;
            float py = p.getPosition().y;
            float pw = p.getWidthplatform();
            float ph = p.getHeightplatform();

            boolean overlapX = position.x + width > px && position.x < px + pw;
            if (overlapX) {
                if (oldY >= py + ph && position.y <= py + ph && velocity.y <= 0f) {
                    position.y = py + ph;
                    velocity.y = 0f;
                    onGround = true;
                }
            }
        }

        if (position.y < 0f) {
            position.y = 0f;
            velocity.y = 0f;
            onGround = true;
        }


    }

    public void render(ShapeRenderer shape) {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.GREEN);
        shape.rect(position.x, position.y, width, height);
        shape.end();
    }

}
