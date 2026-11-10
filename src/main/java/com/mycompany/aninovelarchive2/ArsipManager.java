package com.mycompany.aninovelarchive2;

import java.util.ArrayList;
import java.util.HashMap;

public class ArsipManager {
    private String namaSistem;
    private RuangArsip ruangArsipUtama;
    private ArrayList<itemKoleksi> daftarKoleksi;
    private HashMap<String, Anggota> dataAnggota;

    public ArsipManager(String namaSistem) {
        this.namaSistem = namaSistem;
        this.ruangArsipUtama = new RuangArsip("Ruang Server & Arsip Utama", 100);
        this.daftarKoleksi = new ArrayList<>();
        this.dataAnggota = new HashMap<>();
    }

    public void bukaSistem() {
        System.out.println("\n*** Menginisialisasi Sistem: " + namaSistem + " ***");
        ruangArsipUtama.bukaRuangArsip();
    }

    public void tambahKoleksi(itemKoleksi k) {
        daftarKoleksi.add(k);
        System.out.println("Sukses! Koleksi baru ditambahkan. (Total Koleksi: " + daftarKoleksi.size() + ")");
    }

    public void tambahAnggota(Anggota a) {
        dataAnggota.put(a.getNpm(), a);
        System.out.println("Berhasil menambahkan anggota: " + a.getNama() + " (" + a.getNpm() + ")");
    }

    public void lihatSemuaKoleksi() {
        if (daftarKoleksi.isEmpty()) {
            System.out.println("Belum ada koleksi yang tersimpan.");
        } else {
            for (int i = 0; i < daftarKoleksi.size(); i++) {
                System.out.print((i + 1) + ". ");
                daftarKoleksi.get(i).tampilkanInfo();
            }
        }
    }

    public void cariKoleksi(String genre) throws KoleksiTidakDitemukanException {
        System.out.println("\n--- Hasil Pencarian Genre: " + genre + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < daftarKoleksi.size(); i++) {
            if (daftarKoleksi.get(i).getGenre().equalsIgnoreCase(genre)) {
                daftarKoleksi.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new KoleksiTidakDitemukanException("Gagal: Koleksi dengan genre '" + genre + "' tidak terdaftar.");
        }
    }

    public void cariAnggota(String npm) {
        if (dataAnggota.containsKey(npm)) {
            Anggota a = dataAnggota.get(npm);
            System.out.println("Ditemukan! NPM: " + a.getNpm() + " | Nama: " + a.getNama());
        } else {
            System.out.println("Anggota dengan NPM tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaAnggota() {
        System.out.println("Total Anggota Terdaftar: " + dataAnggota.size());
        for (Anggota a : dataAnggota.values()) {
            System.out.println("- NPM: " + a.getNpm() + " | Nama: " + a.getNama());
        }
    }

    public Anggota getAnggota(String npm) {
        return dataAnggota.get(npm);
    }

    public itemKoleksi getKoleksiInt(int index) {
        return daftarKoleksi.get(index);
    }

    public int getJumlahKoleksi() {
        return daftarKoleksi.size();
    }
}