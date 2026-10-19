package com.mycompany.aninovelarchive2;

public class Anime extends itemKoleksi implements DapatDinilai {
    private int jumlahEpisode;
    private String studio;
    private double rating = 0;

    public Anime(String judul, String genre, int tahunRilis, int jumlahEpisode, String studio) {
        super(judul, genre, tahunRilis);
        this.jumlahEpisode = jumlahEpisode;
        this.studio = studio;
    }

    public int getJumlahEpisode() {
        return this.jumlahEpisode;
    }

    public void setJumlahEpisode(int jumlahEpisode) {
        this.jumlahEpisode = jumlahEpisode;
    }

    public String getStudio() {
        return this.studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public double getRating() {
        return this.rating;
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[ANIME] ");
        super.tampilkanInfo();
        System.out.printf(" | eps: %d | Studio: %s", jumlahEpisode, studio);
        System.out.printf(" | Rating: %s%n", rating == 0 ? "-" : String.valueOf(rating));
    }

    @Override
    public int hitungEstimasiDurasi() {
        int menit = jumlahEpisode * 24;
        System.out.println("   -> [Anime] Estimasi durasi tonton '" + getJudul() + "': "
                + menit + " menit (" + jumlahEpisode + " eps x 24 menit)");
        return menit;
    }

    @Override
    public void beriRating(double rating) {
        this.rating = rating;
        System.out.println("   -> [Anime] Rating '" + getJudul() + "' diset menjadi " + rating + "/10");
    }
}
