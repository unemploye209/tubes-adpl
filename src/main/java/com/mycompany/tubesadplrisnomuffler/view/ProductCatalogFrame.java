
package com.mycompany.tubesadplrisnomuffler.view;

import com.mycompany.tubesadplrisnomuffler.model.Cart;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductCatalogFrame extends JFrame {

    public ProductCatalogFrame() {
        setTitle("Katalog Produk - Risno Muffler");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel title = new JLabel("KATALOG PRODUK KNALPOT");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        String[] kolom = {"ID", "Nama Produk", "Jenis", "Harga"};

        Object[][] data = {
            {"P001", "RM Street Classic", "Standard", 350000},
            {"P002", "RM Racing Short", "Racing", 450000},
            {"P003", "RM Titanium Series", "Titanium", 650000},
            {"P004", "RM Carbon Edition", "Carbon", 750000},
            {"P005", "RM Full Racing", "Racing", 950000}
        };

        DefaultTableModel model = new DefaultTableModel(data, kolom);
        JTable tabel = new JTable(model);

        JButton btnTambah = new JButton("Tambah ke Keranjang");
        JButton btnKeranjang = new JButton("Lihat Keranjang");
        JButton btnKembali = new JButton("Kembali");

        btnTambah.addActionListener(e -> {
            int baris = tabel.getSelectedRow();

            if (baris == -1) {
                JOptionPane.showMessageDialog(this,
                    "Pilih produk terlebih dahulu!");
            } else {
                String nama = tabel.getValueAt(baris, 1).toString();
                int harga = Integer.parseInt(
                    tabel.getValueAt(baris, 3).toString()
                );

                Cart.tambahPesanan(nama, harga);

                JOptionPane.showMessageDialog(this,
                    "Produk berhasil ditambahkan!");
            }
        });

        btnKeranjang.addActionListener(e -> {
            new CartFrame().setVisible(true);
            dispose();
        });

        btnKembali.addActionListener(e -> {
            new MainMenuFrame().setVisible(true);
            dispose();
        });

        JPanel bawah = new JPanel();
        bawah.add(btnTambah);
        bawah.add(btnKeranjang);
        bawah.add(btnKembali);

        panel.add(title, BorderLayout.NORTH);
        panel.add(new JScrollPane(tabel), BorderLayout.CENTER);
        panel.add(bawah, BorderLayout.SOUTH);

        add(panel);
    }
}
