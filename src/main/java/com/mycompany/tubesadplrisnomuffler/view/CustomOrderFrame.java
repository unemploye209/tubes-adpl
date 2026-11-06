
package com.mycompany.tubesadplrisnomuffler.view;

import com.mycompany.tubesadplrisnomuffler.config.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomOrderFrame extends JFrame {

    public CustomOrderFrame() {
        setTitle("Pesanan Kustom - Risno Muffler");
        setSize(500, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        JLabel title = new JLabel("FORM PESANAN KUSTOM");
        title.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel lblIdPesanan = new JLabel("ID Pesanan:");
        JTextField txtIdPesanan = new JTextField();

        JLabel lblDimensi = new JLabel("Dimensi Silencer:");
        JTextField txtDimensi = new JTextField();

        JLabel lblPipa = new JLabel("Jenis Pipa:");
        String[] pilihanPipa = {
            "Stainless Steel", "Besi", "Titanium"
        };
        JComboBox<String> cmbPipa = new JComboBox<>(pilihanPipa);

        JLabel lblMaterial = new JLabel("Material Eksternal:");
        String[] pilihanMaterial = {
            "Stainless Steel", "Carbon", "Titanium"
        };
        JComboBox<String> cmbMaterial = new JComboBox<>(pilihanMaterial);

        JLabel lblHeader = new JLabel("Jenis Header:");
        String[] pilihanHeader = {
            "Standard", "Racing", "Custom"
        };
        JComboBox<String> cmbHeader = new JComboBox<>(pilihanHeader);

        JButton btnPesan = new JButton("Tambah Pesanan");
        JButton btnKembali = new JButton("Kembali");

        btnPesan.addActionListener(e -> {

            String idText = txtIdPesanan.getText().trim();
            String dimensi = txtDimensi.getText().trim();

            if (idText.isEmpty() || dimensi.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "ID pesanan dan dimensi silencer harus diisi!");
                return;
            }

            int idPesanan;

            try {
                idPesanan = Integer.parseInt(idText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "ID pesanan harus berupa angka!");
                return;
            }

            String sql = "INSERT INTO pesanan_kustom "
                    + "(id_pesanan, dimensi_silencer, jenis_pipa, "
                    + "material_eksternal, jenis_header) "
                    + "VALUES (?, ?, ?, ?, ?)";

            Connection connection = DatabaseConnection.getConnection();

            if (connection == null) {
                JOptionPane.showMessageDialog(this,
                        "Koneksi database gagal! Periksa Output NetBeans.");
                return;
            }

            try (connection;
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, idPesanan);
                statement.setString(2, dimensi);
                statement.setString(3, cmbPipa.getSelectedItem().toString());
                statement.setString(4, cmbMaterial.getSelectedItem().toString());
                statement.setString(5, cmbHeader.getSelectedItem().toString());

                statement.executeUpdate();

                JOptionPane.showMessageDialog(this,
                        "Pesanan kustom berhasil disimpan!");

                txtIdPesanan.setText("");
                txtDimensi.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Gagal menyimpan pesanan: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        btnKembali.addActionListener(e -> {
            new MainMenuFrame().setVisible(true);
            dispose();
        });

        panel.add(title);
        panel.add(new JLabel(""));
        panel.add(lblIdPesanan);
        panel.add(txtIdPesanan);
        panel.add(lblDimensi);
        panel.add(txtDimensi);
        panel.add(lblPipa);
        panel.add(cmbPipa);
        panel.add(lblMaterial);
        panel.add(cmbMaterial);
        panel.add(lblHeader);
        panel.add(cmbHeader);
        panel.add(btnPesan);
        panel.add(btnKembali);

        add(panel);
    }
}
