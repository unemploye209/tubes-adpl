package com.mycompany.tubesadplrisnomuffler.model;

public class Product {

    private String id;
    private String nama;
    private String jenis;
    private int harga;

    public Product(String id, String nama, String jenis, int harga) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }
}
