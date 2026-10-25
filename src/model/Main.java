package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        Kullanici kisi = new Kullanici(1);
        kisi.kullaniciAdi = "diyar";
        kisi.ad = "Diyar";
        kisi.rol = "KULLANICI";

        // Bu numara, Melike'nin CalismaPlani sinifi baglanana kadar ornektir.
        int ornekPlanId = 1;
        LocalDate ornekTarih = LocalDate.of(2026, 10, 26);

        CalismaKaydi birinciKayit = new CalismaKaydi(1, ornekPlanId);
        birinciKayit.calisilanTarih = ornekTarih;
        birinciKayit.gerceklesenSureDakika = 25;

        CalismaKaydi ikinciKayit = new CalismaKaydi(2, ornekPlanId);
        ikinciKayit.calisilanTarih = ornekTarih;
        ikinciKayit.gerceklesenSureDakika = 35;

        // Baska plana ait bu kayit toplama alinmamali.
        CalismaKaydi baskaPlaninKaydi = new CalismaKaydi(3, 2);
        baskaPlaninKaydi.calisilanTarih = ornekTarih;
        baskaPlaninKaydi.gerceklesenSureDakika = 100;

        CalismaKaydi[] kayitlar = {
            birinciKayit, ikinciKayit, baskaPlaninKaydi
        };

        int toplamDakika = 0;
        for (CalismaKaydi kayit : kayitlar) {
            if (kayit.planId == ornekPlanId
                    && ornekTarih.equals(kayit.calisilanTarih)) {
                toplamDakika += kayit.gerceklesenSureDakika;
            }
        }

        int hedefDakika = 90;
        double ilerlemeYuzdesi = toplamDakika * 100.0 / hedefDakika;
        int kalanDakika = Math.max(0, hedefDakika - toplamDakika);

        GunlukOnay gunlukOnay = new GunlukOnay(1, kisi.kullaniciId, ornekTarih);

        System.out.println("Kullanici: " + kisi.ad + " (ID: " + kisi.kullaniciId + ")");
        System.out.println("Plan ID: " + ornekPlanId);
        System.out.println("Tarih: " + ornekTarih);
        System.out.println("Toplam: " + toplamDakika + " dakika");
        System.out.printf("Ilerleme: %.1f%%%n", ilerlemeYuzdesi);
        System.out.println("Kalan: " + kalanDakika + " dakika");

        if (gunlukOnay.onaylandiMi) {
            System.out.println("Gunluk onay: Onaylandi");
        } else {
            System.out.println("Gunluk onay: Bekliyor");
        }

        // Ilk hafta icin kucuk bir metin dosyasi yazma/okuma ornegi.
        Path dosya = Path.of("data", "ornek-kullanici.metads");
        Files.createDirectories(dosya.getParent());
        String satir = kisi.kullaniciId + "|" + kisi.kullaniciAdi + "|" + kisi.ad;
        Files.writeString(dosya, satir, StandardCharsets.UTF_8);

        String[] alanlar = Files.readString(dosya, StandardCharsets.UTF_8).split("\\|", -1);
        if (alanlar.length != 3) {
            throw new IOException("Ornek kullanici dosyasi beklenen bicimde degil.");
        }
        Kullanici dosyadanYuklenen = new Kullanici(Integer.parseInt(alanlar[0]));
        dosyadanYuklenen.kullaniciAdi = alanlar[1];
        dosyadanYuklenen.ad = alanlar[2];
        System.out.println("Dosyadan okunan: " + dosyadanYuklenen.ad);
    }
}
