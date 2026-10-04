/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aninovelarchive2;

public class itemKoleksi {
    private String judul;
    private String genre;
    private int tahunRilis;

    public static int totalKoleksi = 0;

    public itemKoleksi(String judul, String genre, int tahunRilis) {
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
}