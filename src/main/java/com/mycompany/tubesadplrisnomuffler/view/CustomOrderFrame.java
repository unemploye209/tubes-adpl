package com.mycompany.tubesadplrisnomuffler.view;

import javax.swing.*;
import java.awt.*;

public class CustomOrderFrame extends JFrame {

    public CustomOrderFrame() {
        setTitle("Pesanan Kustom - Risno Muffler");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        JLabel title = new JLabel("FORM PESANAN KUSTOM");
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel lblDimensi = new JLabel("Dimensi Silencer:");
        JTextField txtDimensi = new JTextField();

        JLabel lblPipa = new JLabel("Jenis Pipa:");
        String[] pilihanPipa = {"Stainless Steel", "Besi", "Titanium"};
        JComboBox<String> cmbPipa = new JComboBox<>(pilihanPipa);

        JLabel lblMaterial = new JLabel("Material Eksternal:");
        String[] pilihanMaterial = {"Stainless Steel", "Carbon", "Titanium"};
        JComboBox<String> cmbMaterial = new JComboBox<>(pilihanMaterial);

        JLabel lblHeader = new JLabel("Jenis Header:");
        String[] pilihanHeader = {"Standard", "Racing", "Custom"};
        JComboBox<String> cmbHeader = new JComboBox<>(pilihanHeader);

        JButton btnPesan = new JButton("Tambah Pesanan");
        JButton btnKembali = new JButton("Kembali");

        btnPesan.addActionListener(e -> {
            if (txtDimensi.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Dimensi silencer harus diisi!");
            } else {
                JOptionPane.showMessageDialog(this,
                    "Pesanan kustom berhasil dibuat!");
            }
        });

        btnKembali.addActionListener(e -> {
            new MainMenuFrame().setVisible(true);
            dispose();
        });

        panel.add(title);
        panel.add(new JLabel(""));
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
