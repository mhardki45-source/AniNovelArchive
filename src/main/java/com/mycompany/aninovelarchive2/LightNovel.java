package com.mycompany.aninovelarchive2;

public class LightNovel extends itemKoleksi implements DapatDinilai, DapatDipinjam {
    private int jumlahVolume;
    private String penulis;
    private double rating = 0;
    private String peminjam = null;

    public LightNovel(String judul, String genre, int tahunRilis, int jumlahVolume, String penulis) {
        super(judul, genre, tahunRilis);
        this.jumlahVolume = jumlahVolume;
        this.penulis = penulis;
    }

    public int getJumlahVolume() {
        return this.jumlahVolume;
    }

    public void setJumlahVolume(int jumlahVolume) {
        this.jumlahVolume = jumlahVolume;
    }

    public String getPenulis() {
        return this.penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public double getRating() {
        return this.rating;
    }

    public String getPeminjam() {
        return this.peminjam;
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[LN]    ");
        super.tampilkanInfo();
        System.out.printf(" | Vol: %d | Penulis: %s", jumlahVolume, penulis);
        System.out.printf(" | Rating: %s | Status: %s%n",
                rating == 0 ? "-" : String.valueOf(rating),
                peminjam == null ? "Tersedia" : "Dipinjam " + peminjam);
    }

    @Override
    public int hitungEstimasiDurasi() {
        int jam = jumlahVolume * 3;
        System.out.println("   -> [Light Novel] Estimasi durasi baca '" + getJudul() + "': "
                + jam + " jam (" + jumlahVolume + " vol x 3 jam)");
        return jam * 60;
    }

    @Override
    public void beriRating(double rating) {
        this.rating = rating;
        System.out.println("   -> [Light Novel] Rating '" + getJudul() + "' diset menjadi " + rating + "/10");
    }

    @Override
    public void prosesPinjam(String peminjam) {
        if (this.peminjam != null) {
            System.out.println("   -> [Light Novel] '" + getJudul() + "' sedang dipinjam oleh " + this.peminjam + ".");
        } else {
            this.peminjam = peminjam;
            System.out.println("   -> [Light Novel] '" + getJudul() + "' berhasil dipinjam oleh " + peminjam + ".");
        }
    }
}
