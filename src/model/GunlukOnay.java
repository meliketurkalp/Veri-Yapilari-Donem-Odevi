package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GunlukOnay {
    final int onayId;
    final int kullaniciId;
    final LocalDate tarih;
    boolean onaylandiMi;
    LocalDateTime onayZamani;

    public GunlukOnay(int onayId, int kullaniciId, LocalDate tarih) {
        this.onayId = onayId;
        this.kullaniciId = kullaniciId;
        this.tarih = tarih;
        this.onaylandiMi = false;
    }
}
