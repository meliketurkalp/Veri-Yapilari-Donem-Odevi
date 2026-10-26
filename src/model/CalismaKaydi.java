package model;

import java.time.LocalDate;

public class CalismaKaydi {
    final int kayitId;
    final int planId;
    LocalDate calisilanTarih;
    int gerceklesenSureDakika;
    String aciklama;

    public CalismaKaydi(int kayitId, int planId) {
        this.kayitId = kayitId;
        this.planId = planId;
    }
}
