package com.mycompany.aninovelarchive2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aninovelarchive2 {

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

    public static void isiDataAwal(ArsipManager manager) {
        try {
            manager.tambahKoleksi(new Anime("Frieren", "Fantasy", 2023, 28, "Madhouse"));
            manager.tambahKoleksi(new Anime("Steins;Gate", "Sci-Fi", 2011, 24, "White Fox"));
            manager.tambahKoleksi(new LightNovel("Re:Zero", "Isekai", 2014, 35, "Tappei Nagatsuki"));
            manager.tambahKoleksi(new LightNovel("Sword Art Online", "Fantasy", 2009, 27, "Reki Kawahara"));
            manager.tambahKoleksi(new Anime("Mushoku Tensei", "Isekai", 2021, 23, "Studio Bind"));

            manager.tambahAnggota(new Anggota("2517051001", "Budi Santoso"));
            manager.tambahAnggota(new Anggota("2517051002", "Siti Aminah"));
            manager.tambahAnggota(new Anggota("2517051003", "Andi Pratama"));
        } catch (Exception e) {
            System.out.println("[ERROR DATA AWAL] " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArsipManager arsipManager = new ArsipManager("AniNovel Archive System");
        boolean isRunning = true;

        arsipManager.bukaSistem();
        isiDataAwal(arsipManager);

        System.out.println("=================================================");
        System.out.println("   Selamat Datang di AniNovelArchive (Modul 10)  ");
        System.out.println("=================================================");

        try {
            while (isRunning) {
                System.out.println("\nMENU UTAMA:");
                System.out.println("1. Tambah Koleksi Baru (Anime / Light Novel)");
                System.out.println("2. Tampilkan Seluruh Koleksi");
                System.out.println("3. Cari Koleksi (Custom Exception)");
                System.out.println("4. Kelola Anggota (Demo HashMap & Agregasi)");
                System.out.println("5. Peminjaman Koleksi (Demo Association)");
                System.out.println("6. Beri Rating (Interface DapatDinilai)");
                System.out.println("7. Keluar");
                System.out.print("Pilih menu (1-7): ");

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
                                arsipManager.tambahKoleksi(new Anime(judul, genre, tahun, eps, studio));
                            } else {
                                System.out.print("Masukkan Jumlah Volume: ");
                                int vol = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Masukkan Nama Penulis/Author: ");
                                String penulis = scanner.nextLine();
                                arsipManager.tambahKoleksi(new LightNovel(judul, genre, tahun, vol, penulis));
                            }
                        }

                        case 2 -> {
                            System.out.println("\n----------------------------------------------------------------------------------");
                            System.out.printf("DAFTAR KOLEKSI (Total Terdaftar: %d)%n", itemKoleksi.totalKoleksi);
                            System.out.println("----------------------------------------------------------------------------------");
                            arsipManager.lihatSemuaKoleksi();
                        }

                        case 3 -> {
                            if (arsipManager.getJumlahKoleksi() == 0) {
                                System.out.println("Koleksi masih kosong.");
                                break;
                            }
                            System.out.print("Masukkan Genre yang dicari: ");
                            String cariGenre = scanner.nextLine();
                            try {
                                arsipManager.cariKoleksi(cariGenre);
                            } catch (KoleksiTidakDitemukanException e) {
                                System.out.println("[PERINGATAN] " + e.getMessage());
                            }
                        }

                        case 4 -> {
                            System.out.println("\n-- Kelola Anggota (Agregasi) --");
                            System.out.println("1. Tambah Anggota");
                            System.out.println("2. Cari Anggota");
                            System.out.println("3. Lihat Semua Anggota");
                            System.out.print("Pilih: ");
                            int menuA = scanner.nextInt();
                            scanner.nextLine();

                            if (menuA == 1) {
                                System.out.print("Masukkan NPM: ");
                                String npm = scanner.nextLine();
                                System.out.print("Masukkan Nama: ");
                                String nama = scanner.nextLine();
                                arsipManager.tambahAnggota(new Anggota(npm, nama));
                            } else if (menuA == 2) {
                                System.out.print("NPM yg dicari: ");
                                arsipManager.cariAnggota(scanner.nextLine());
                            } else if (menuA == 3) {
                                arsipManager.lihatSemuaAnggota();
                            } else {
                                System.out.println("Pilihan tidak valid.");
                            }
                        }

                        case 5 -> {
                            System.out.println("\n-- Sistem Peminjaman (Demo Association) --");
                            System.out.print("Masukkan NPM Peminjam: ");
                            String inputNpm = scanner.nextLine();
                            Anggota peminjam = arsipManager.getAnggota(inputNpm);

                            if (peminjam == null) {
                                System.out.println("Gagal: Anggota dengan NPM tersebut belum terdaftar!");
                            } else if (arsipManager.getJumlahKoleksi() == 0) {
                                System.out.println("Gagal: Belum ada koleksi yang bisa dipinjam.");
                            } else {
                                arsipManager.lihatSemuaKoleksi();
                                System.out.print("Pilih Nomor Koleksi yg ingin dipinjam: ");
                                int noKoleksi = scanner.nextInt() - 1;
                                scanner.nextLine();

                                if (noKoleksi >= 0 && noKoleksi < arsipManager.getJumlahKoleksi()) {
                                    itemKoleksi itemPinjam = arsipManager.getKoleksiInt(noKoleksi);
                                    TransaksiPeminjaman.prosesPinjam(peminjam, itemPinjam);
                                } else {
                                    System.out.println("Nomor koleksi tidak valid!");
                                }
                            }
                        }

                        case 6 -> {
                            if (arsipManager.getJumlahKoleksi() == 0) {
                                System.out.println("Koleksi masih kosong.");
                                break;
                            }
                            arsipManager.lihatSemuaKoleksi();
                            System.out.print("Pilih nomor koleksi untuk diberi rating: ");
                            int noRating = scanner.nextInt() - 1;
                            scanner.nextLine();
                            validasiNomor(noRating + 1, arsipManager.getJumlahKoleksi());

                            System.out.print("Masukkan rating (1-10): ");
                            double nilai = scanner.nextDouble();
                            scanner.nextLine();
                            validasiRating(nilai);

                            itemKoleksi dipilihRating = arsipManager.getKoleksiInt(noRating);
                            if (dipilihRating instanceof DapatDinilai) {
                                ((DapatDinilai) dipilihRating).beriRating(nilai);
                            } else {
                                System.out.println("   -> Item ini tidak dapat dinilai.");
                            }
                        }

                        case 7 -> {
                            isRunning = false;
                            System.out.println("\nTerima kasih telah menggunakan AniNovelArchive!");
                        }

                        default -> System.out.println("Pilihan menu tidak valid. Silakan pilih 1-7.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\n[FATAL ERROR] Input tidak valid! Anda harus memasukkan angka.");
                    scanner.nextLine();
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