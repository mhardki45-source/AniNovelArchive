package com.mycompany.aninovelarchive2;

public class RuangArsip {
    private String namaRuangan;
    private int kapasitasServer;

    public RuangArsip(String namaRuangan, int kapasitasServer) {
        this.namaRuangan = namaRuangan;
        this.kapasitasServer = kapasitasServer;
    }

    public void bukaRuangArsip() {
        System.out.println("   -> [" + namaRuangan + "] Berhasil diaktifkan. Kapasitas Server: " + kapasitasServer + " TB.");
    }
}