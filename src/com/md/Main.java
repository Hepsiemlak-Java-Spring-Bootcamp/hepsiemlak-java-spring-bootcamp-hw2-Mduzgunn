package com.md;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EstateFactory estateFactory = new EstateFactory();
        EstateSupplier estateSupplierEv=estateFactory.createEstate("ev");
        EstateSupplier estateSupplierAraba=estateFactory.createEstate("araba");
        estateSupplierAraba.estateType();
        estateSupplierEv.estateType();

        List<Kullanici> kullaniciListesi = new ArrayList<Kullanici>();

        Kullanici kullanici1 = new Kullanici("Kurumsal", "Fatma", "fatma@gmail.com");
        kullaniciListesi.add(kullanici1);
        kullanici1.mesajKutusu = prepareMesajKutusu();
        Kullanici kullanici2 = new Kullanici("Bireysel", "Hayriye", "hayriye@gmail.com");
        kullaniciListesi.add(kullanici2);
        kullanici2.mesajKutusu = prepareMesajKutusu();
        Kullanici kullanici3 = new Kullanici("Bireysel", "Ayse", "ayse.sari@gmail.com");
        kullaniciListesi.add(kullanici3);
        kullanici3.mesajKutusu = prepareMesajKutusu();

        List<Ilan> ilanListesi = new ArrayList<>();
        ilanListesi.add(prepareIlan("ilan 1", kullanici1));
        ilanListesi.add(prepareIlan("ilan 2", kullanici2));
        ilanListesi.add(prepareIlan("ilan 3", kullanici3));
        ilanListesi.add(prepareIlan("ilan 4", kullanici3));

        kullanici1.favoriIlanlar.add(ilanlar().get(0));
        kullanici2.favoriIlanlar.add(ilanlar().get(0));
        kullanici3.favoriIlanlar.add(ilanlar().get(2));
        kullanici3.favoriIlanlar.add(ilanlar().get(1));

        kullanici1.mesajKutusu.add(prepareMesajKutusu().get(0));
        kullanici1.mesajKutusu.add(prepareMesajKutusu().get(1));
        kullanici2.mesajKutusu.add(prepareMesajKutusu().get(0));
        kullanici3.mesajKutusu.add(prepareMesajKutusu().get(0));

        System.out.println(prepareMesajKutusu());

        System.out.println(" MESAJ BAŞLIK=> " + prepareMesajKutusu().get(1).baslik + " ALICI=> " +  prepareMesajKutusu().get(1).getAlici().isim + " GÖNDEREN=> " +  prepareMesajKutusu().get(1).getGonderici().isim);
        System.out.println(" MESAJ BAŞLIK=> " + prepareMesajKutusu().get(0).baslik + " ALICI=> " +  prepareMesajKutusu().get(0).getAlici().isim + " GÖNDEREN=> " +  prepareMesajKutusu().get(0).getGonderici().isim);


        favoriIlanlar(kullaniciAra(kullaniciListesi, "Fatma"));

        System.out.println("kullanıcı1 favori ilanları=> " + kullanici1.favoriIlanlar);
        System.out.println("kullanıcı3 favori ilanları=> " + kullanici3.getFavoriIlanlar());

        for (GayrimenkulEv gayrimenkul: gayrimenkuller())
            if (gayrimenkul.getFiyat()<3000&&gayrimenkul.getOdaSayisi()=="2+1"||gayrimenkul.getOdaSayisi()=="3+1"){
                System.out.println(gayrimenkul.getIl()+" "+ gayrimenkul.getIlce() +" "+gayrimenkul.getOdaSayisi() +" "+ gayrimenkul.getFiyat());
            }
    }
    private static Kullanici kullaniciAra(List<Kullanici> kullaniciListesi, String isim) {
        Kullanici kullanicii = kullaniciListesi.get(0);
        for (Kullanici kullanici : kullaniciListesi) {
            if (kullanici.isim.equals(isim)) {
                kullanicii = kullanici;
            }
        }
        return kullanicii;
    }

    private static void favoriIlanlar(Kullanici kullanici) {
        System.out.println(kullanici.isim + " (" + kullanici.getEmail() + ") kullanıcısının favori ilanları şu şekilde: \n");
        for (Ilan ilan : kullanici.favoriIlanlar) {
            System.out.println(ilan.getBaslik() + "\n" + ilan.getBaslik() + "  " + ilan.getOlusturulmaTarihi()   + "  " + ilan.getFiyat() + "\n");
        }
    }

    private static List<Mesaj> prepareMesajKutusu() {
        List<Mesaj> mesajKutusu = new ArrayList<>();
        mesajKutusu.add(new Mesaj("baslik1", new Kullanici("gönderen", "gönderen alıcı","gönderıcı@mail"),new Kullanici("alici","alıcı kullanıcı","denme@alici")));
        mesajKutusu.add(new Mesaj("baslik 2 deneme", new Kullanici("gönderen2", "gönderen alıcı2","gönderıcı2@mail"),new Kullanici("alici2","alıcı kullanıcı 2","denme2@alici")));
        return mesajKutusu;
    }
    private static List<Ilan> ilanlar() {
        List<Ilan> ilanList = new ArrayList<>();
        ilanList.add(new Ilan("baslik1"));
        ilanList.add(new Ilan("deneme"));
        ilanList.add(new Ilan("selam"));
        return ilanList;
    }
    private static Ilan prepareIlan(String baslik, Kullanici kullanici) {
        Ilan ilan = new Ilan();
        ilan.setBaslik(baslik);
        ilan.setKullanici(kullanici);
        return ilan;
    }
    private static List<GayrimenkulEv> gayrimenkuller() {
        List<GayrimenkulEv> gayrimenkulList = new ArrayList<>();
        gayrimenkulList.add(new GayrimenkulEv("İstanbul","Beşiktaş","Ev","3+1",125,3,2000));
        gayrimenkulList.add(new GayrimenkulEv("İstanbul","Sefaköy","Villa","2+1",225,4,2500));
        gayrimenkulList.add(new GayrimenkulEv("İstanbul","Merkez","Villa","4+1",225,4,2500));
        gayrimenkulList.add(new GayrimenkulEv("İstanbul","Bebek","Ev","1+1",325,5,4000));
        return gayrimenkulList;

    }


}