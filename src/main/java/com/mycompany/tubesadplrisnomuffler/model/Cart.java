
package com.mycompany.tubesadplrisnomuffler.model;

import java.util.ArrayList;

public class Cart {

    private static ArrayList<String> daftarPesanan = new ArrayList<>();
    private static int totalHarga = 0;

    public static void tambahPesanan(String nama, int harga) {
        daftarPesanan.add(nama + " - Rp" + harga);
        totalHarga += harga;
    }

    public static ArrayList<String> getDaftarPesanan() {
        return daftarPesanan;
    }

    public static int getTotalHarga() {
        return totalHarga;
    }

    public static void kosongkanKeranjang() {
        daftarPesanan.clear();
        totalHarga = 0;
    }

    public static void hapusPesanan(int index) {
        if (index >= 0 && index < daftarPesanan.size()) {
            daftarPesanan.remove(index);
        }
    }
}
