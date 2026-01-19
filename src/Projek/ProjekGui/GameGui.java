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
    
    // === INI "BUKU TAMU" NYA ===
    // Java Collection: Nyimpen daftar pemain yang udah mati/selesai
    private List<Pemain> databasePemain = new ArrayList<>(); 

    public GameGui() {
        // Setup Tampilan (Sama kayak sebelumnya)
        setTitle("UMAM IN BORDER LAND");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panelBawah = new JPanel(new BorderLayout());
        inputField = new JTextField();
        btnSubmit = new JButton("JAWAB");
        btnSubmit.setBackground(Color.GREEN);
        btnSubmit.addActionListener(e -> prosesJawaban());
        
        panelBawah.add(inputField, BorderLayout.CENTER);
        panelBawah.add(btnSubmit, BorderLayout.EAST);
        add(panelBawah, BorderLayout.SOUTH);

        // Langsung mulai loop game
        mulaiSesiBaru();
        setVisible(true);
    }

    // Method buat reset dari awal (Ganti Orang)
    private void mulaiSesiBaru() {
        // 1. Input Nama
        String nama = JOptionPane.showInputDialog(this, "Masukkan Nama Peserta Baru:");
        if (nama == null || nama.isEmpty()) nama = "ORANG GILA";
        
        // Bikin Object Pemain BARU (Reset skor, reset identitas)
        pemainSaatIni = new Pemain(nama);

        // 2. Pilih Game
        String[] options = {"Matematika", "Teka-teki"};
        int pilih = JOptionPane.showOptionDialog(this, "Pilih Arena:", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (pilih == 0) activeGame = new GameMtk();
        else activeGame = new Gametekateki();

        // 3. Reset Teknis
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
        "PIKIR LAH PAKAI OTAK", // Judul Pop-up
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
        // 1. Update skor ke pemain
        pemainSaatIni.tambahSkor(skorSesi);
        
        // 2. Tentukan Nasib
        String status = (skorSesi >= 3) ? "HIDUP (Lulus)" : "MATI (Eliminasi)";
        
        // 3. SIMPAN KE BUKU TAMU (Collection)
        // Kita masukin object pemain saat ini ke list global
        databasePemain.add(pemainSaatIni);

        // 4. Tampilkan Laporan Akhir
        StringBuilder laporan = new StringBuilder();
        laporan.append("=== GAME OVER ===\n");
        laporan.append("Nama: ").append(pemainSaatIni.getNama()).append("\n");
        laporan.append("Status: ").append(status).append("\n");
        laporan.append("Skor: ").append(pemainSaatIni.getSkor()).append("\n\n");
        
        laporan.append("=== RIWAYAT PEMAIN SEBELUMNYA ===\n");
        // Looping isi List databasePemain buat ditampilin
        if (databasePemain.size() > 1) { // Lebih dari 1 karena yg baru main udah masuk
            for (Pemain p : databasePemain) {
                // Cek biar ga nampilin diri sendiri lagi (opsional)
                if (p != pemainSaatIni) { 
                    laporan.append("- ").append(p.toString()).append("\n");
                }
            }
        } else {
            laporan.append("(Belum ada korban lain)\n");
        }

        JOptionPane.showMessageDialog(this, laporan.toString());
        
        // 5. Loop balik ke awal buat pemain baru
        mulaiSesiBaru();
    }
    
    public static void main(String[] args) {
        new GameGui();
    }
}