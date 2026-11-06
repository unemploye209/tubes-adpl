
package com.mycompany.tubesadplrisnomuffler.model;

public class CustomOrder {

    private String dimensiSilencer;
    private String jenisPipa;
    private String materialEksternal;
    private String jenisHeader;
    private int harga;

    public CustomOrder(String dimensiSilencer, String jenisPipa,
            String materialEksternal, String jenisHeader, int harga) {

        this.dimensiSilencer = dimensiSilencer;
        this.jenisPipa = jenisPipa;
        this.materialEksternal = materialEksternal;
        this.jenisHeader = jenisHeader;
        this.harga = harga;
    }

    public String getDimensiSilencer() {
        return dimensiSilencer;
    }

    public String getJenisPipa() {
        return jenisPipa;
    }

    public String getMaterialEksternal() {
        return materialEksternal;
    }

    public String getJenisHeader() {
        return jenisHeader;
    }

    public int getHarga() {
        return harga;
    }
}
