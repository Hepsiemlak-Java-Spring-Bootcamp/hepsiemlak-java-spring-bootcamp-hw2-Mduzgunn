package com.md;

public class GayrimenkulAraba implements EstateSupplier {
    private String il;
    private String ilce;
    private int fiyat;

    public GayrimenkulAraba(String il, String ilce, int fiyat) {
        this.il = il;
        this.ilce = ilce;
        this.fiyat = fiyat;
    }

    public GayrimenkulAraba() {
        System.out.println("gayrimenkul tipi araba");
    }

    @Override
    public void estateType() {
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }


}
