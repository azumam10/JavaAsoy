package Cobacoba.GUI.day1;

import javax.swing.*;

public class Step2_MenuSimulasi {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Menu Game");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnMtk = new JButton("Game Matematika");
        JButton btnTeka = new JButton("Game Teka-Teki");

        btnMtk.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Game Matematika dipilih");
        });

        btnTeka.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Game Teka-Teki dipilih");
        });

        JPanel panel = new JPanel();
        panel.add(btnMtk);
        panel.add(btnTeka);

        frame.add(panel);
        frame.setVisible(true);
    }
}

