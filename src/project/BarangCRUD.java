package project;

import java.sql.*;
import java.util.Scanner;

public class BarangCRUD {
    static Scanner sc = new Scanner(System.in);

    // CREATE
    public static void tambahBarang() {
        System.out.print("Nama Barang : ");
        String nama = sc.nextLine();
        System.out.print("Jenis Barang: ");
        String jenis = sc.nextLine();
        System.out.print("Stok Awal   : ");
        int stok = sc.nextInt(); sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO barang (nama_barang, jenis, stok) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, jenis);
            ps.setInt(3, stok);
            ps.executeUpdate();
            System.out.println("Barang berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Error tambah: " + e.getMessage());
        }
    }

    // READ
    public static void lihatBarang() {
        try (Connection conn = DBConnection.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM barang");
            System.out.println("\n--- Daftar Barang Limbah ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id_barang") + " | " +
                                   rs.getString("nama_barang") + " | " +
                                   rs.getString("jenis") + " | Stok: " +
                                   rs.getInt("stok"));
            }
        } catch (Exception e) {
            System.out.println("Error lihat: " + e.getMessage());
        }
    }

    // UPDATE
    public static void updateBarang() {
        System.out.print("ID Barang yang mau diupdate: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Nama Baru : ");
        String nama = sc.nextLine();
        System.out.print("Jenis Baru: ");
        String jenis = sc.nextLine();
        System.out.print("Stok Baru : ");
        int stok = sc.nextInt(); sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE barang SET nama_barang=?, jenis=?, stok=? WHERE id_barang=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, jenis);
            ps.setInt(3, stok);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Barang berhasil diupdate!");
        } catch (Exception e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }

    // DELETE
    public static void hapusBarang() {
        System.out.print("ID Barang yang mau dihapus: ");
        int id = sc.nextInt(); sc.nextLine();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM barang WHERE id_barang=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Barang berhasil dihapus!");
        } catch (Exception e) {
            System.out.println("Error hapus: " + e.getMessage());
        }
    }
}
