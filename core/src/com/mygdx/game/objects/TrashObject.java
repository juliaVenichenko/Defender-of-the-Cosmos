package com.mygdx.game.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.GameSettings;

import java.util.Random;

public class TrashObject extends GameObject{
    private static final int paddingHorizontal = 30;
    private int livesLeft;
    public TrashObject(int width, int height, String texturePath, World world) {
        super(
                texturePath,
                width / 2 + paddingHorizontal + (new Random()).nextInt((GameSettings.SCR_WIDTH - 2 * paddingHorizontal - width)),
                GameSettings.SCR_HEIGHT + height / 2,
                width, height,
                GameSettings.TRASH_BIT,
                world
        );
        livesLeft = 1;
        body.setLinearVelocity(new Vector2(0, -GameSettings.TRASH_VELOCITY));
    }
    public boolean isInFrame(){
        return getY() + height / 2 > 0;
    }
    @Override
    public void hit() {
        livesLeft -= 1;
    }
    public boolean isAlive() {
        return livesLeft > 0;
    }
}

