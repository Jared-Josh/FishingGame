package com.fishinggame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FishingGame extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(20, this);
    int boatX = 250;
    int lineY = 100;
    boolean isFishing = false;
    int score = 0;

    ArrayList<Fish> fishList = new ArrayList<>();

    public FishingGame() {
        JFrame frame = new JFrame("2D Fishing Game");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        setFocusable(true);
        requestFocusInWindow();
        this.addKeyListener(this);
        frame.setResizable(false);
        frame.setVisible(true);
        timer.start();

        for (int i = 0; i < 5; i++) {
            fishList.add(new Fish());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(Assets.background, 0, 0, getWidth(), getHeight(), null);
        g.drawImage(Assets.boatSmall, boatX, 80, 40, 80, null);

        if (isFishing) {
            g.setColor(Color.BLACK);
            g.drawLine(boatX + 20, 100, boatX + 20, lineY);
        }

        for (Fish fish : fishList) {
            fish.draw(g);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isFishing && lineY < 300) {
            lineY += 5;
        }

        for (Fish fish : fishList) {
            fish.move();
        }

        if (isFishing && lineY >= 300) {
            for (Fish fish : fishList) {
                if (Math.abs((boatX + 20) - fish.x) < 30 && Math.abs(lineY - fish.y) < 30) {
                    score++;
                    fish.respawn();
                    break;
                }
            }
            isFishing = false;
            lineY = 100;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyCode()); // Debug
        if (e.getKeyCode() == KeyEvent.VK_LEFT && boatX > 0) boatX -= 10;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && boatX < getWidth() - 40) boatX += 10;
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !isFishing) isFishing = true;
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        Assets.load();
        new FishingGame();
    }
}