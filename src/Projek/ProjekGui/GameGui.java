package Projek.ProjekGui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class GameGui extends JFrame {

    // Components
    private JTextArea textArea;
    private JTextField inputField;
    private JButton btnSubmit;

    // Data Game
    private Pemain pemainSaatIni;
    private Game activeGame;
    private int soalIndex = 0;
    private int skorSesi = 0;
    
    // Database Pemain
    private List<Pemain> databasePemain = new ArrayList<>(); 

    public GameGui() {
        // 1. Setup Frame Utama
        setTitle("UMAM IN BORDER LAND");
        setSize(500, 400); // Ukuran window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Biar muncul di tengah layar
       
        setLayout(null); 
        
        // Mengubah warna background window menjadi abu-abu muda seperti contoh
        // getContentPane().setBackground(new Color(230, 230, 230));

        // 2. Setup Area Pertanyaan (TextArea)
        textArea = new JTextArea();
        textArea.setEditable(false);
        // Memberi border/garis tepi tipis agar terlihat seperti kotak terpisah
        textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        // Membungkus textArea dengan ScrollPane biar bisa discroll kalau teks panjang
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        scrollPane.setBounds(20, 20, 445, 200);
        add(scrollPane); 

        // 3. Setup Kolom Jawaban (InputField)
        inputField = new JTextField();
        inputField.setToolTipText("Masukan Jawaban");
        // Mengatur posisi di bawah area pertanyaan
        inputField.setBounds(20, 240, 350, 35);
        add(inputField);

        // 4. Setup Tombol Jawab
        btnSubmit = new JButton("JAWAB");
        // Menghapus warna hijau agar sesuai desain (abu-abu standar tombol)
        btnSubmit.setBackground(null); 
        // Posisi di sebelah kanan input field
        btnSubmit.setBounds(380, 240, 85, 40);
        btnSubmit.addActionListener(e -> prosesJawaban());
        add(btnSubmit);

        // --- AKHIR PERUBAHAN TAMPILAN ---

        // Langsung mulai loop game
        mulaiSesiBaru();
        setVisible(true);
    }


    private void mulaiSesiBaru() {
        String nama = JOptionPane.showInputDialog(this, "Masukkan Nama Peserta Baru:");
        if (nama == null || nama.isEmpty()) nama = "ORANG GILA";
        
        pemainSaatIni = new Pemain(nama);

        String[] options = {"Matematika", "Teka-teki"};
        int pilih = JOptionPane.showOptionDialog(this, "Pilih Arena:", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (pilih == 0) activeGame = new GameMtk();
        else activeGame = new Gametekateki();

        soalIndex = 0;
        skorSesi = 0;
        inputField.setEnabled(true);
        btnSubmit.setEnabled(true);
        
        updateTampilanSoal();
    }

    private void updateTampilanSoal() {
        textArea.setText("=== " + activeGame.getNamaGame() + " ===\n");
        textArea.append("Player Aktif: " + pemainSaatIni.getNama() + "\n\n");
        textArea.append("Soal ke-" + (soalIndex + 1) + ":\n");
        textArea.append(activeGame.getPertanyaan(soalIndex) + "\n");
        inputField.setText("");
        inputField.requestFocus();
    }

    private void prosesJawaban() {
        String jawaban = inputField.getText();
        if (jawaban.isEmpty()) return;

        boolean benar = activeGame.cekJawaban(soalIndex, jawaban);

        if (benar) {
            JOptionPane.showMessageDialog(this, "Benar!");
            skorSesi++;
        } else {
            JOptionPane.showMessageDialog(this, 
        "Salah! Kunci: " + activeGame.getKunci(soalIndex), 
        "PIKIR LAH PAKAI OTAK", 
        JOptionPane.ERROR_MESSAGE);
        }

        soalIndex++;

        if (soalIndex >= activeGame.getJumlahSoal()) {
            gameSelesai();
        } else {
            updateTampilanSoal();
        }
    }

    private void gameSelesai() {
        pemainSaatIni.tambahSkor(skorSesi);
        
        String status = (skorSesi >= 3) ? "HIDUP (Lulus)" : "MATI (Eliminasi)";
        
        databasePemain.add(pemainSaatIni);

        StringBuilder laporan = new StringBuilder();
        laporan.append("=== GAME OVER ===\n");
        laporan.append("Nama: ").append(pemainSaatIni.getNama()).append("\n");
        laporan.append("Status: ").append(status).append("\n");
        laporan.append("Skor: ").append(pemainSaatIni.getSkor()).append("\n\n");
        
        laporan.append("=== RIWAYAT PEMAIN SEBELUMNYA ===\n");
        if (databasePemain.size() > 1) { 
            for (Pemain p : databasePemain) {
                if (p != pemainSaatIni) { 
                    laporan.append("- ").append(p.toString()).append("\n");
                }
            }
        } else {
            laporan.append("(Belum ada korban lain)\n");
        }

        JOptionPane.showMessageDialog(this, laporan.toString());
        
        mulaiSesiBaru();
    }
    
    public static void main(String[] args) {
        new GameGui();
    }
}