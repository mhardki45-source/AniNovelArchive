package com.mycompany.aninovelarchive2;

public abstract class itemKoleksi {
    private String judul;
    private String genre;
    private int tahunRilis;

    public static int totalKoleksi = 0;

    public itemKoleksi(String judul, String genre, int tahunRilis) throws Exception {
        if (judul == null || judul.trim().isEmpty()) {
            throw new Exception("Judul tidak boleh kosong!");
        }
        if (genre == null || genre.trim().isEmpty()) {
            throw new Exception("Genre tidak boleh kosong!");
        }
        if (tahunRilis <= 1900) {
            throw new Exception("Tahun rilis tidak valid (harus lebih dari 1900)!");
        }
        this.judul = judul;
        this.genre = genre;
        this.tahunRilis = tahunRilis;
        totalKoleksi++;
    }

    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTahunRilis() {
        return this.tahunRilis;
    }

    public void setTahunRilis(int tahunRilis) {
        if (tahunRilis > 1900) {
            this.tahunRilis = tahunRilis;
        }
    }

    public void tampilkanInfo() {
        System.out.printf("Judul: %-25s | Genre: %-12s | Tahun: %d", judul, genre, tahunRilis);
    }

    public abstract int hitungEstimasiDurasi();
}
