package com.mygame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Panzer {
    private final int size = 64;
    private final int halfSize = size/2;
    // Vector 2 because is 2 dimension lol))))
    private final Vector2 position = new Vector2();
    private final Vector2 angle = new Vector2();


    private Texture texture;
    private TextureRegion textureRegion;

    public Panzer(float x, float y) {
        texture = new Texture("tank_animation_up.png");
        textureRegion = new TextureRegion(texture);
        position.set(x, y);
    }
    public void render(Batch batch){
        batch.draw(
                textureRegion,
                position.x,
                position.y,
                halfSize,
                halfSize,
                size,
                size,
                1,
                1,
                angle.angleDeg() - 90);
    }
    public void dispose(){
        texture.dispose();
    }

    private boolean isItEndOfMap(Vector2 position){
        float tempX = this.position.x + position.x;
        float tempY = this.position.y + position.y;
        if (tempX < 0) return true;
        if (tempY < 50) return true;
        if (tempX >= 1700) return true;
        if (tempY >= 750) return true;
        return false;
    }
    public void move(Vector2 position){
        if (isItEndOfMap(position)) return;
        //changeAnimation(position);
        this.position.add(position);

    }

    private void changeAnimation(Vector2 position) {
        if ( position.x > 0) texture = new Texture("tank_animation_right.png");
        if ( position.x < 0) texture = new Texture("tank_animation_left.png");
        if ( position.y > 0) texture = new Texture("tank_animation_up.png");
        if ( position.y < 0) texture = new Texture("tank_animation_down.png");
    }

    public void rotateMouse(Vector2 mousePosition) {
        angle.set(mousePosition).sub(position.x + halfSize, position.y + halfSize);
    }
}
