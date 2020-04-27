package ru.geekbrains.HW.Java_HW;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;
    public static int fieldSize = 3;
    Map() {
        setBackground(Color.CYAN);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode: %d, size: %d, len: %d\n",
                gameMode, fieldSizeX, winLength);

    }

        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            for (int i = 1; i < fieldSize; i++) {
                g.drawLine(getWidth() * i / fieldSize, 0, getWidth() * i / fieldSize, getHeight());
                g.drawLine(0, getHeight() * i / fieldSize, getWidth(), getHeight() * i / fieldSize);

            }
        }

}
