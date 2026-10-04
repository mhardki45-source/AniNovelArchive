/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aninovelarchive2;

public class LightNovel extends itemKoleksi {
    private int jumlahVolume;
    private String penulis;

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

    @Override
    public void tampilkanInfo() {
        System.out.print("[LN]    ");
        super.tampilkanInfo();
        System.out.printf(" | Vol: %d | Penulis: %s%n", jumlahVolume, penulis);
    }
}
