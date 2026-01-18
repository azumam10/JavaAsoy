package Pert1;

import javax.swing.*;
import java.awt.*;

public class KalkulatorLuasGUI extends JFrame {

    private JComboBox<String> pilihanBangun;
    private JPanel inputPanel;
    private JTextArea hasilArea;

    public KalkulatorLuasGUI() {
        setTitle("Kalkulator Luas Bangun Datar");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Dropdown pilihan bangun datar
        String[] bangun = {"Persegi", "Persegi Panjang", "Segitiga", "Lingkaran", "Trapesium"};
        pilihanBangun = new JComboBox<>(bangun);
        pilihanBangun.addActionListener(e -> updateInputPanel());

        add(pilihanBangun, BorderLayout.NORTH);

        // Panel input
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 5, 5));
        add(inputPanel, BorderLayout.CENTER);

        // Area hasil
        hasilArea = new JTextArea();
        hasilArea.setEditable(false);
        hasilArea.setMargin(new Insets(10, 10, 10, 10));
        add(new JScrollPane(hasilArea), BorderLayout.SOUTH);

        // Default tampilkan input pertama
        updateInputPanel();

        setVisible(true);
    }

    private void updateInputPanel() {
        inputPanel.removeAll();
        String pilihan = (String) pilihanBangun.getSelectedItem();

        switch (pilihan) {
            case "Persegi":
                buatInputPersegi();
                break;
            case "Persegi Panjang":
                buatInputPersegiPanjang();
                break;
            case "Segitiga":
                buatInputSegitiga();
                break;
            case "Lingkaran":
                buatInputLingkaran();
                break;
            case "Trapesium":
                buatInputTrapesium();
                break;
        }

        inputPanel.revalidate();
        inputPanel.repaint();
    }

    private void buatInputPersegi() {
        JTextField sisiField = new JTextField();
        JButton hitungBtn = new JButton("Hitung");

        inputPanel.add(new JLabel("Sisi:"));
        inputPanel.add(sisiField);
        inputPanel.add(hitungBtn);

        hitungBtn.addActionListener(e -> {
            try {
                double sisi = Double.parseDouble(sisiField.getText());
                double luas = sisi * sisi;
                hasilArea.setText("Luas Persegi = " + luas);
            } catch (NumberFormatException ex) {
                showError();
            }
        });
    }

    private void buatInputPersegiPanjang() {
        JTextField panjangField = new JTextField();
        JTextField lebarField = new JTextField();
        JButton hitungBtn = new JButton("Hitung");

        inputPanel.add(new JLabel("Panjang:"));
        inputPanel.add(panjangField);
        inputPanel.add(new JLabel("Lebar:"));
        inputPanel.add(lebarField);
        inputPanel.add(hitungBtn);

        hitungBtn.addActionListener(e -> {
            try {
                double p = Double.parseDouble(panjangField.getText());
                double l = Double.parseDouble(lebarField.getText());
                double luas = p * l;
                hasilArea.setText("Luas Persegi Panjang = " + luas);
            } catch (NumberFormatException ex) {
                showError();
            }
        });
    }

    private void buatInputSegitiga() {
        JTextField alasField = new JTextField();
        JTextField tinggiField = new JTextField();
        JButton hitungBtn = new JButton("Hitung");

        inputPanel.add(new JLabel("Alas:"));
        inputPanel.add(alasField);
        inputPanel.add(new JLabel("Tinggi:"));
        inputPanel.add(tinggiField);
        inputPanel.add(hitungBtn);

        hitungBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(alasField.getText());
                double t = Double.parseDouble(tinggiField.getText());
                double luas = 0.5 * a * t;
                hasilArea.setText("Luas Segitiga = " + luas);
            } catch (NumberFormatException ex) {
                showError();
            }
        });
    }

    private void buatInputLingkaran() {
        JTextField rField = new JTextField();
        JButton hitungBtn = new JButton("Hitung");

        inputPanel.add(new JLabel("Jari-jari:"));
        inputPanel.add(rField);
        inputPanel.add(hitungBtn);

        hitungBtn.addActionListener(e -> {
            try {
                double r = Double.parseDouble(rField.getText());
                double luas = Math.PI * r * r;
                hasilArea.setText("Luas Lingkaran = " + luas);
            } catch (NumberFormatException ex) {
                showError();
            }
        });
    }

    private void buatInputTrapesium() {
        JTextField aField = new JTextField();
        JTextField bField = new JTextField();
        JTextField tField = new JTextField();
        JButton hitungBtn = new JButton("Hitung");

        inputPanel.add(new JLabel("Sisi Atas (a):"));
        inputPanel.add(aField);
        inputPanel.add(new JLabel("Sisi Bawah (b):"));
        inputPanel.add(bField);
        inputPanel.add(new JLabel("Tinggi:"));
        inputPanel.add(tField);
        inputPanel.add(hitungBtn);

        hitungBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                double t = Double.parseDouble(tField.getText());
                double luas = 0.5 * (a + b) * t;
                hasilArea.setText("Luas Trapesium = " + luas);
            } catch (NumberFormatException ex) {
                showError();
            }
        });
    }

    private void showError() {
        JOptionPane.showMessageDialog(this,
                "Input tidak valid! Harap masukkan angka.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        // Set Look & Feel agar mirip dengan OS
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Tidak dapat mengatur system look and feel, menggunakan default.");
        }

        // Jalankan aplikasi
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KalkulatorLuasGUI();
            }
        });
    }
}
