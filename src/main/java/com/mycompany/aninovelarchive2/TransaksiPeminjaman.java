package com.mycompany.aninovelarchive2;

public class TransaksiPeminjaman {
    public static void prosesPinjam(Anggota anggota, itemKoleksi koleksi) {
        System.out.println("\n--------------------------------------------------");
        System.out.println("            STRUK TRANSAKSI PEMINJAMAN            ");
        System.out.println("--------------------------------------------------");
        System.out.println("Peminjam : " + anggota.getNama() + " (NPM: " + anggota.getNpm() + ")");
        System.out.println("Item     : " + koleksi.getJudul() + " (" + koleksi.getGenre() + ")");
        System.out.println("Status   : Berhasil dicatat di sistem arsip.");
        
        if (koleksi instanceof DapatDipinjam) {
            ((DapatDipinjam) koleksi).prosesPinjam(anggota.getNama());
        } else {
            System.out.println("   -> Item ini tidak mendukung peminjaman fisik/digital.");
        }
        System.out.println("--------------------------------------------------");
    }
}
