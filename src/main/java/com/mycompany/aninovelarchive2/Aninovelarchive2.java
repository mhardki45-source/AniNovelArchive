package com.mycompany.aninovelarchive2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Aninovelarchive2 {

    public static void cariKoleksi(ArrayList<itemKoleksi> daftar, String genre)
            throws KoleksiTidakDitemukanException {
        System.out.println("\n--- Hasil Pencarian Genre: " + genre + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getGenre().equalsIgnoreCase(genre)) {
                daftar.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new KoleksiTidakDitemukanException(
                    "Gagal: Koleksi dengan genre '" + genre + "' tidak terdaftar di sistem.");
        }
    }

    public static void cariKoleksi(ArrayList<itemKoleksi> daftar, int tahun)
            throws KoleksiTidakDitemukanException {
        System.out.println("\n--- Hasil Pencarian Tahun Rilis: " + tahun + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getTahunRilis() == tahun) {
                daftar.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new KoleksiTidakDitemukanException(
                    "Gagal: Koleksi dari tahun " + tahun + " tidak terdaftar di sistem.");
        }
    }

    public static void tampilkanDaftarRingkas(ArrayList<itemKoleksi> daftar) {
        System.out.println();
        for (int i = 0; i < daftar.size(); i++) {
            System.out.println((i + 1) + ". " + daftar.get(i).getJudul());
        }
    }

    public static void validasiRating(double nilai) throws Exception {
        if (nilai < 1 || nilai > 10) {
            throw new Exception("Rating harus antara 1 sampai 10!");
        }
    }

    public static void validasiNomor(int nomor, int jumlah) throws Exception {
        if (nomor < 1 || nomor > jumlah) {
            throw new Exception("Nomor koleksi tidak valid!");
        }
    }

    public static void tambahAnggota(HashMap<String, String> dataAnggota, String npm, String nama)
            throws Exception {
        if (npm == null || npm.trim().isEmpty() || nama == null || nama.trim().isEmpty()) {
            throw new Exception("NPM dan nama anggota tidak boleh kosong!");
        }
        if (dataAnggota.containsKey(npm)) {
            throw new Exception("NPM " + npm + " sudah terdaftar atas nama " + dataAnggota.get(npm) + "!");
        }
        dataAnggota.put(npm, nama);
    }

    public static void isiDataAwal(ArrayList<itemKoleksi> daftar, HashMap<String, String> anggota) {
        try {
            daftar.add(new Anime("Frieren", "Fantasy", 2023, 28, "Madhouse"));
            daftar.add(new Anime("Steins;Gate", "Sci-Fi", 2011, 24, "White Fox"));
            daftar.add(new LightNovel("Re:Zero", "Isekai", 2014, 35, "Tappei Nagatsuki"));
            daftar.add(new LightNovel("Sword Art Online", "Fantasy", 2009, 27, "Reki Kawahara"));
            daftar.add(new Anime("Mushoku Tensei", "Isekai", 2021, 23, "Studio Bind"));

            tambahAnggota(anggota, "2517051001", "Budi Santoso");
            tambahAnggota(anggota, "2517051002", "Siti Aminah");
            tambahAnggota(anggota, "2517051003", "Andi Pratama");
        } catch (Exception e) {
            System.out.println("[ERROR DATA AWAL] " + e.getMessage());
        }
    }

    public static void kelolaAnggota(Scanner scanner, HashMap<String, String> dataAnggota) throws Exception {
        System.out.println("\n-- Kelola Anggota (HashMap) --");
        System.out.println("1. Tambah Anggota Baru");
        System.out.println("2. Cari Anggota via NPM");
        System.out.println("3. Tampilkan Semua Anggota");
        System.out.print("Pilih: ");
        int menuAnggota = scanner.nextInt();
        scanner.nextLine();

        if (menuAnggota == 1) {
            System.out.print("Masukkan NPM (sebagai Key): ");
            String npm = scanner.nextLine();
            System.out.print("Masukkan Nama Lengkap (sebagai Value): ");
            String nama = scanner.nextLine();
            tambahAnggota(dataAnggota, npm, nama);
            System.out.println("Berhasil menambahkan anggota!");
        } else if (menuAnggota == 2) {
            System.out.print("Masukkan NPM yang dicari: ");
            String searchNpm = scanner.nextLine();
            if (dataAnggota.containsKey(searchNpm)) {
                System.out.println("Ditemukan! Nama: " + dataAnggota.get(searchNpm));
            } else {
                System.out.println("Anggota dengan NPM tersebut tidak terdaftar.");
            }
        } else if (menuAnggota == 3) {
            System.out.println("Total Anggota Terdaftar: " + dataAnggota.size());
            for (String keyNpm : dataAnggota.keySet()) {
                System.out.println("- NPM: " + keyNpm + " | Nama: " + dataAnggota.get(keyNpm));
            }
        } else {
            throw new Exception("Opsi menu anggota tidak valid!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<itemKoleksi> daftarKoleksi = new ArrayList<>();
        HashMap<String, String> dataAnggota = new HashMap<>();
        boolean isRunning = true;

        isiDataAwal(daftarKoleksi, dataAnggota);

        System.out.println("=================================================");
        System.out.println("   Selamat Datang di AniNovelArchive.  ");
        System.out.println("=================================================");

        try {
            while (isRunning) {
                System.out.println("\nMENU UTAMA:");
                System.out.println("1. Tambah Judul Baru (Anime / Light Novel)");
                System.out.println("2. Tampilkan Seluruh Koleksi");
                System.out.println("3. Cari Koleksi (Overloading + Custom Exception)");
                System.out.println("4. Beri Rating (Interface DapatDinilai)");
                System.out.println("5. Pinjam Koleksi (Interface DapatDipinjam)");
                System.out.println("6. Demo Semua Aksi (Abstract Method & Interface)");
                System.out.println("7. Kelola Anggota (Demo HashMap)");
                System.out.println("8. Keluar");
                System.out.print("Pilih menu (1-8): ");

                try {
                    int pilihan = scanner.nextInt();
                    scanner.nextLine();

                    switch (pilihan) {
                        case 1 -> {
                            System.out.println("\nPilih Tipe Koleksi:");
                            System.out.println("1. Anime");
                            System.out.println("2. Light Novel");
                            System.out.print("Pilihan: ");
                            int tipe = scanner.nextInt();
                            scanner.nextLine();
                            if (tipe != 1 && tipe != 2) {
                                throw new Exception("Pilihan tipe tidak valid!");
                            }

                            System.out.print("Masukkan Judul: ");
                            String judul = scanner.nextLine();
                            System.out.print("Masukkan Genre: ");
                            String genre = scanner.nextLine();
                            System.out.print("Masukkan Tahun Rilis: ");
                            int tahun = scanner.nextInt();
                            scanner.nextLine();

                            if (tipe == 1) {
                                System.out.print("Masukkan Jumlah Episode: ");
                                int eps = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Masukkan Nama Studio: ");
                                String studio = scanner.nextLine();
                                daftarKoleksi.add(new Anime(judul, genre, tahun, eps, studio));
                                System.out.println("Anime berhasil ditambahkan ke koleksi!");
                            } else {
                                System.out.print("Masukkan Jumlah Volume: ");
                                int vol = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Masukkan Nama Penulis/Author: ");
                                String penulis = scanner.nextLine();
                                daftarKoleksi.add(new LightNovel(judul, genre, tahun, vol, penulis));
                                System.out.println("Light Novel berhasil ditambahkan ke koleksi!");
                            }
                            System.out.println("(Total koleksi sekarang: " + daftarKoleksi.size() + ")");
                        }

                        case 2 -> {
                            System.out.println("\n----------------------------------------------------------------------------------");
                            System.out.printf("DAFTAR KOLEKSI (Total Terdaftar: %d)%n", itemKoleksi.totalKoleksi);
                            System.out.println("----------------------------------------------------------------------------------");
                            if (daftarKoleksi.isEmpty()) {
                                System.out.println("Koleksi masih kosong.");
                            } else {
                                for (int i = 0; i < daftarKoleksi.size(); i++) {
                                    System.out.print((i + 1) + ". ");
                                    daftarKoleksi.get(i).tampilkanInfo();
                                    daftarKoleksi.get(i).hitungEstimasiDurasi();
                                }
                            }
                        }

                        case 3 -> {
                            if (daftarKoleksi.isEmpty()) {
                                System.out.println("Koleksi masih kosong, tambahkan data terlebih dahulu.");
                                break;
                            }
                            try {
                                System.out.println("\nKriteria Pencarian:");
                                System.out.println("1. Berdasarkan Genre (String)");
                                System.out.println("2. Berdasarkan Tahun Rilis (Integer)");
                                System.out.print("Pilih opsi pencarian: ");
                                int opsiCari = scanner.nextInt();
                                scanner.nextLine();

                                if (opsiCari == 1) {
                                    System.out.print("Masukkan Genre yang dicari: ");
                                    String cariGenre = scanner.nextLine();
                                    cariKoleksi(daftarKoleksi, cariGenre);
                                } else if (opsiCari == 2) {
                                    System.out.print("Masukkan Tahun yang dicari: ");
                                    int cariTahun = scanner.nextInt();
                                    scanner.nextLine();
                                    cariKoleksi(daftarKoleksi, cariTahun);
                                } else {
                                    throw new Exception("Opsi pencarian tidak valid!");
                                }
                            } catch (KoleksiTidakDitemukanException e) {
                                System.out.println("[PERINGATAN] " + e.getMessage());
                            } finally {
                                System.out.println("-> [FINALLY] Sesi pencarian selesai dieksekusi.");
                            }
                        }

                        case 4 -> {
                            if (daftarKoleksi.isEmpty()) {
                                System.out.println("Koleksi masih kosong, tambahkan data terlebih dahulu.");
                                break;
                            }
                            tampilkanDaftarRingkas(daftarKoleksi);
                            System.out.print("Pilih nomor koleksi: ");
                            int noRating = scanner.nextInt();
                            scanner.nextLine();
                            validasiNomor(noRating, daftarKoleksi.size());

                            System.out.print("Masukkan rating (1-10): ");
                            double nilai = scanner.nextDouble();
                            scanner.nextLine();
                            validasiRating(nilai);

                            itemKoleksi dipilihRating = daftarKoleksi.get(noRating - 1);
                            if (dipilihRating instanceof DapatDinilai) {
                                ((DapatDinilai) dipilihRating).beriRating(nilai);
                            } else {
                                System.out.println("   -> '" + dipilihRating.getJudul() + "' tidak dapat dinilai.");
                            }
                        }

                        case 5 -> {
                            if (daftarKoleksi.isEmpty()) {
                                System.out.println("Koleksi masih kosong, tambahkan data terlebih dahulu.");
                                break;
                            }
                            tampilkanDaftarRingkas(daftarKoleksi);
                            System.out.print("Pilih nomor koleksi: ");
                            int noPinjam = scanner.nextInt();
                            scanner.nextLine();
                            validasiNomor(noPinjam, daftarKoleksi.size());

                            System.out.print("Masukkan nama peminjam: ");
                            String namaPeminjam = scanner.nextLine();
                            if (namaPeminjam.trim().isEmpty()) {
                                throw new Exception("Nama peminjam tidak boleh kosong!");
                            }
                            itemKoleksi dipilihPinjam = daftarKoleksi.get(noPinjam - 1);
                            if (dipilihPinjam instanceof DapatDipinjam) {
                                ((DapatDipinjam) dipilihPinjam).prosesPinjam(namaPeminjam);
                            } else {
                                System.out.println("   -> '" + dipilihPinjam.getJudul() + "' tidak dapat dipinjam.");
                            }
                        }

                        case 6 -> {
                            System.out.println("\n=== DEMO ABSTRACT METHOD & INTERFACE ===");
                            for (int i = 0; i < daftarKoleksi.size(); i++) {
                                itemKoleksi item = daftarKoleksi.get(i);
                                System.out.println("\n" + (i + 1) + ". " + item.getJudul());
                                item.hitungEstimasiDurasi();
                                if (item instanceof DapatDinilai) {
                                    ((DapatDinilai) item).beriRating(8.5);
                                } else {
                                    System.out.println("   -> Tidak mengimplementasikan DapatDinilai.");
                                }
                                if (item instanceof DapatDipinjam) {
                                    ((DapatDipinjam) item).prosesPinjam("Kaizen");
                                } else {
                                    System.out.println("   -> Tidak mengimplementasikan DapatDipinjam.");
                                }
                            }
                        }

                        case 7 -> kelolaAnggota(scanner, dataAnggota);

                        case 8 -> {
                            isRunning = false;
                            System.out.println("\nTerima kasih telah menggunakan AniNovelArchive!");
                        }

                        default -> System.out.println("Pilihan menu tidak valid. Silakan pilih 1-8.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\n[FATAL ERROR] Input tidak valid! Anda harus memasukkan angka.");
                    scanner.nextLine(); // buang sisa input yang salah
                } catch (Exception e) {
                    System.out.println("\n[ERROR SISTEM] Terjadi kegagalan: " + e.getMessage());
                }
            }
        } finally {
            System.out.println("-> [FINALLY] Program selesai, Scanner ditutup.");
            scanner.close();
        }
    }
}
