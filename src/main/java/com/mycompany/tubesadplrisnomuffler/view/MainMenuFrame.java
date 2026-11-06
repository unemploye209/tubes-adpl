
package com.mycompany.tubesadplrisnomuffler.view;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    public MainMenuFrame() {
        setTitle("Risno Muffler");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel title = new JLabel("RISNO MUFFLER", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel subtitle = new JLabel("Sistem Pemesanan Knalpot", SwingConstants.CENTER);

        JButton btnKatalog = new JButton("Katalog Produk");
        JButton btnCustom = new JButton("Pesanan Kustom");
        JButton btnKeluar = new JButton("Keluar");

        btnKatalog.addActionListener(e -> {
            new ProductCatalogFrame().setVisible(true);
            dispose();
        });

        btnCustom.addActionListener(e -> {
            new CustomOrderFrame().setVisible(true);
            dispose();
        });

        btnKeluar.addActionListener(e -> {
            System.exit(0);
        });

        panel.add(title);
        panel.add(subtitle);
        panel.add(btnKatalog);
        panel.add(btnCustom);
        panel.add(btnKeluar);

        add(panel);
    }
}
