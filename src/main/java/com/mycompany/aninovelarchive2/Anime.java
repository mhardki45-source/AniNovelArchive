/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aninovelarchive2;

public class Anime extends itemKoleksi {
    private int jumlahEpisode;
    private String studio;

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

    @Override
    public void tampilkanInfo() {
        System.out.print("[ANIME] ");
        super.tampilkanInfo();
        System.out.printf(" | eps: %d | Studio: %s%n", jumlahEpisode, studio);
    }
}