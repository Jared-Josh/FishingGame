package com.fishinggame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Assets {

public static BufferedImage boatSmall;
public static BufferedImage background;

public static BufferedImage[] fishSprites;

public static void load() {
    try {
        boatSmall = ImageIO.read(Assets.class.getResource("/boat_small.png"));
        background = ImageIO.read(Assets.class.getResource("/background.png"));

        fishSprites = new BufferedImage[]{
                ImageIO.read(Assets.class.getResource("/fish_blue.png")),
                ImageIO.read(Assets.class.getResource("/fish_yellow.png")),
                ImageIO.read(Assets.class.getResource("/fish_green.png")),
                ImageIO.read(Assets.class.getResource("/fish_red.png"))
        };

    } catch (IOException e) {
        e.printStackTrace();
    }
}

}