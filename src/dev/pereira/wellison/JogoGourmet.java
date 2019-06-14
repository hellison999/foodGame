package dev.pereira.wellison;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoGourmet {

    private static Game game;
    private JPanel rootPanel;
    private JLabel openLine;
    private JButton buttonStart;


    public JogoGourmet() {
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JogoGourmet");
        frame.setMinimumSize(new Dimension(300,100));
        frame.setContentPane(new JogoGourmet().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x,y);
        game = new Game();
        game.setupGame();
    }


}
