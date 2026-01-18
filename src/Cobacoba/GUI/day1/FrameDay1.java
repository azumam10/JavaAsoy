package Cobacoba.GUI.day1;

import javax.swing.*;

public class FrameDay1 {
    public static void main(String[] args) {

        // 1. Buat frame
        JFrame frame = new JFrame("Umamis Day");
        frame.setSize(900, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Buat panel (wadah)
        JPanel panel = new JPanel();

        // 3. Buat label + gambar
        ImageIcon image = new ImageIcon("logo2.png");
        JLabel label = new JLabel("Hello World", image, JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        // 4. Buat tombol
        JButton tombol1 = new JButton("Tombol 1");
        JButton tombol2 = new JButton("Tombol 2");

        // 5. Masukkan semua ke panel
        panel.add(label);
        panel.add(tombol1);
        panel.add(tombol2);

        // 6. Masukkan panel ke frame
        frame.add(panel);

        // 7. TAMPILKAN PALING AKHIR
        frame.setVisible(true);
    }
}
