package com.mycompany.aninovelarchive2;

import java.util.Scanner;

public class Aninovelarchive2 {

    public static void cariKoleksi(itemKoleksi[] daftar, int jumlah, String genre) {
        System.out.println("\n--- Hasil Pencarian Genre: " + genre + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getGenre().equalsIgnoreCase(genre)) {
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Koleksi dengan genre tersebut tidak ditemukan.");
        }
    }

    public static void cariKoleksi(itemKoleksi[] daftar, int jumlah, int tahun) {
        System.out.println("\n--- Hasil Pencarian Tahun Rilis: " + tahun + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getTahunRilis() == tahun) {
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Koleksi dari tahun tersebut tidak ditemukan.");
        }
    }

    public static void tampilkanDaftarRingkas(itemKoleksi[] daftar, int jumlah) {
        System.out.println();
        for (int i = 0; i < jumlah; i++) {
            System.out.println((i + 1) + ". " + daftar[i].getJudul());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        itemKoleksi[] daftarKoleksi = new itemKoleksi[15];
        int jumlahKoleksi = 0;
        boolean isRunning = true;

        daftarKoleksi[jumlahKoleksi++] = new Anime("Frieren", "Fantasy", 2023, 28, "Madhouse");
        daftarKoleksi[jumlahKoleksi++] = new Anime("Steins;Gate", "Sci-Fi", 2011, 24, "White Fox");
        daftarKoleksi[jumlahKoleksi++] = new LightNovel("Re:Zero", "Isekai", 2014, 35, "Tappei Nagatsuki");
        daftarKoleksi[jumlahKoleksi++] = new LightNovel("Sword Art Online", "Fantasy", 2009, 27, "Reki Kawahara");

        System.out.println("=================================================");
        System.out.println("   Selamat Datang di AniNovelArchive.  ");
        System.out.println("=================================================");

        while (isRunning) {
            System.out.println("\nMENU UTAMA:");
            System.out.println("1. Tambah Judul Baru (Anime / Light Novel)");
            System.out.println("2. Tampilkan Seluruh Koleksi");
            System.out.println("3. Cari Koleksi (Method Overloading)");
            System.out.println("4. Beri Rating (Interface DapatDinilai)");
            System.out.println("5. Pinjam Koleksi (Interface DapatDipinjam)");
            System.out.println("6. Demo Semua Aksi (Abstract Method & Interface)");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu (1-7): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahKoleksi < daftarKoleksi.length) {
                        System.out.println("\nPilih Tipe Koleksi:");
                        System.out.println("1. Anime");
                        System.out.println("2. Light Novel");
                        System.out.print("Pilihan: ");
                        int tipe = scanner.nextInt();
                        scanner.nextLine();

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

                            daftarKoleksi[jumlahKoleksi] = new Anime(judul, genre, tahun, eps, studio);
                            jumlahKoleksi++;
                            System.out.println("Anime berhasil ditambahkan ke koleksi!");
                        } else if (tipe == 2) {
                            System.out.print("Masukkan Jumlah Volume: ");
                            int vol = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Nama Penulis/Author: ");
                            String penulis = scanner.nextLine();

                            daftarKoleksi[jumlahKoleksi] = new LightNovel(judul, genre, tahun, vol, penulis);
                            jumlahKoleksi++;
                            System.out.println("Light Novel berhasil ditambahkan ke koleksi!");
                        } else {
                            System.out.println("Pilihan tipe tidak valid.");
                        }
                    } else {
                        System.out.println("Kapasitas penyimpanan koleksi sudah penuh!");
                    }
                    break;

                case 2:
                    System.out.println("\n----------------------------------------------------------------------------------");
                    System.out.printf("DAFTAR KOLEKSI (Total Terdaftar: %d)%n", itemKoleksi.totalKoleksi);
                    System.out.println("----------------------------------------------------------------------------------");
                    if (jumlahKoleksi == 0) {
                        System.out.println("Koleksi masih kosong.");
                    } else {
                        for (int i = 0; i < jumlahKoleksi; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarKoleksi[i].tampilkanInfo();
                            daftarKoleksi[i].hitungEstimasiDurasi();
                        }
                    }
                    break;

                case 3:
                    if (jumlahKoleksi == 0) {
                        System.out.println("Koleksi masih kosong, tambahkan data terlebih dahulu.");
                        break;
                    }
                    System.out.println("\nKriteria Pencarian:");
                    System.out.println("1. Berdasarkan Genre (String)");
                    System.out.println("2. Berdasarkan Tahun Rilis (Integer)");
                    System.out.print("Pilih opsi pencarian: ");
                    int opsiCari = scanner.nextInt();
                    scanner.nextLine();

                    if (opsiCari == 1) {
                        System.out.print("Masukkan Genre yang dicari: ");
                        String cariGenre = scanner.nextLine();
                        cariKoleksi(daftarKoleksi, jumlahKoleksi, cariGenre);
                    } else if (opsiCari == 2) {
                        System.out.print("Masukkan Tahun yang dicari: ");
                        int cariTahun = scanner.nextInt();
                        scanner.nextLine();
                        cariKoleksi(daftarKoleksi, jumlahKoleksi, cariTahun);
                    } else {
                        System.out.println("Opsi pencarian tidak valid.");
                    }
                    break;

                case 4:
                    if (jumlahKoleksi == 0) {
                        System.out.println("Koleksi masih kosong, tambahkan data terlebih dahulu.");
                        break;
                    }
                    tampilkanDaftarRingkas(daftarKoleksi, jumlahKoleksi);
                    System.out.print("Pilih nomor koleksi: ");
                    int noRating = scanner.nextInt();
                    scanner.nextLine();
                    if (noRating < 1 || noRating > jumlahKoleksi) {
                        System.out.println("Nomor tidak valid.");
                        break;
                    }
                    System.out.print("Masukkan rating (1-10): ");
                    double nilai = scanner.nextDouble();
                    scanner.nextLine();
                    if (nilai < 1 || nilai > 10) {
                        System.out.println("Rating harus antara 1 sampai 10.");
                        break;
                    }
                    itemKoleksi dipilihRating = daftarKoleksi[noRating - 1];
                    if (dipilihRating instanceof DapatDinilai) {
                        ((DapatDinilai) dipilihRating).beriRating(nilai);
                    } else {
                        System.out.println("   -> '" + dipilihRating.getJudul() + "' tidak dapat dinilai.");
                    }
                    break;

                case 5:
                    if (jumlahKoleksi == 0) {
                        System.out.println("Koleksi masih kosong, tambahkan data terlebih dahulu.");
                        break;
                    }
                    tampilkanDaftarRingkas(daftarKoleksi, jumlahKoleksi);
                    System.out.print("Pilih nomor koleksi: ");
                    int noPinjam = scanner.nextInt();
                    scanner.nextLine();
                    if (noPinjam < 1 || noPinjam > jumlahKoleksi) {
                        System.out.println("Nomor tidak valid.");
                        break;
                    }
                    System.out.print("Masukkan nama peminjam: ");
                    String namaPeminjam = scanner.nextLine();
                    itemKoleksi dipilihPinjam = daftarKoleksi[noPinjam - 1];
                    if (dipilihPinjam instanceof DapatDipinjam) {
                        ((DapatDipinjam) dipilihPinjam).prosesPinjam(namaPeminjam);
                    } else {
                        System.out.println("   -> '" + dipilihPinjam.getJudul() + "' tidak dapat dipinjam.");
                    }
                    break;

                case 6:
                    System.out.println("\n=== DEMO ABSTRACT METHOD & INTERFACE ===");
                    for (int i = 0; i < jumlahKoleksi; i++) {
                        itemKoleksi item = daftarKoleksi[i];
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
                    break;

                case 7:
                    isRunning = false;
                    System.out.println("\nTerima kasih telah menggunakan AniNovelArchive!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid. Silakan pilih 1-7.");
            }
        }
        scanner.close();
    }
}
