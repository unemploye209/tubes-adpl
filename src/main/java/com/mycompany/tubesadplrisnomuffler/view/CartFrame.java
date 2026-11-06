package com.mycompany.tubesadplrisnomuffler.view;

import javax.swing.*;
import java.awt.*;

public class CartFrame extends JFrame {

    public CartFrame() {
        setTitle("Keranjang - Risno Muffler");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("KERANJANG PESANAN");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> daftarPesanan = new JList<>(model);

        JLabel lblTotal = new JLabel("Total Harga: Rp0");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnHapus = new JButton("Hapus Pesanan");
        JButton btnCheckout = new JButton("Checkout");
        JButton btnKembali = new JButton("Kembali");

        btnHapus.addActionListener(e -> {
            int index = daftarPesanan.getSelectedIndex();

            if (index == -1) {
                JOptionPane.showMessageDialog(this,
                    "Pilih pesanan yang ingin dihapus!");
            } else {
                model.remove(index);
                JOptionPane.showMessageDialog(this,
                    "Pesanan berhasil dihapus!");
            }
        });

        btnCheckout.addActionListener(e -> {
            if (model.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Keranjang masih kosong!");
            } else {
                JOptionPane.showMessageDialog(this,
                    "Checkout berhasil!");
                model.clear();
                lblTotal.setText("Total Harga: Rp0");
            }
        });

        btnKembali.addActionListener(e -> {
            new MainMenuFrame().setVisible(true);
            dispose();
        });

        JPanel bawah = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel tombol = new JPanel();

        tombol.add(btnHapus);
        tombol.add(btnCheckout);
        tombol.add(btnKembali);

        bawah.add(lblTotal);
        bawah.add(tombol);

        panel.add(title, BorderLayout.NORTH);
        panel.add(new JScrollPane(daftarPesanan), BorderLayout.CENTER);
        panel.add(bawah, BorderLayout.SOUTH);

        add(panel);
    }
}
