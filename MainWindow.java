package ru.geekbrains.HW.Java_HW;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private static final int WIN_HEIGHT = 400;
    private static final int WIN_WIDTH = 700;
    private static final int X_POS = 1100;
    private static final int Y_POS = 200;
    private SettingsWindow settingsWindow;
    private Map map = new Map();
    private JLabel greetings;

    MainWindow(){
        setBounds(X_POS, Y_POS, WIN_WIDTH, WIN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Game");
        JButton startButton = new JButton("Start");
        startButton.setBackground(Color.green);
        startButton.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 20 ));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });
        JButton exitButton= new JButton("Exit");
        exitButton.setBackground(Color.red);
        exitButton.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 20 ));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        greetings = new JLabel("WELCOME TO TIC-TAC-TOE");
        greetings.setFont(new Font("Arial", Font.BOLD , 30 ));
        greetings.setHorizontalAlignment(SwingConstants.CENTER);
        greetings.setBackground(Color.PINK);
        greetings.setOpaque(true);
        JPanel smPanel = new JPanel();
        smPanel.setLayout(new GridLayout(1,2));
        smPanel.add(startButton);
        smPanel.add(exitButton);
        settingsWindow = new SettingsWindow(this);

        add (greetings);
        add (smPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
    void startGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        add (map);
        greetings.setVisible(false);
        map.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);


    }


}
