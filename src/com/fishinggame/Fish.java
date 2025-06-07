package com.fishinggame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Fish {
    int x, y, speed;
    BufferedImage sprite;
    Random rand = new Random();

    public Fish() {
        respawn();
    }

    public void respawn() {
        x = rand.nextInt(550);
        y = 220 + rand.nextInt(150);
        speed = 2 + rand.nextInt(3);
        sprite = Assets.fishSprites[rand.nextInt(Assets.fishSprites.length)];
    }

    public void move() {
        x += speed;
        if (x > 600) {
            x = -50;
            y = 220 + rand.nextInt(150);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, 30, 30, null);

    }
}
