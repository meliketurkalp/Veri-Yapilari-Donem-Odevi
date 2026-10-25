package tr.edu.inonubm.studyapp.model;
import java.time.LocalDate;
//import java.util.UTF-8;
/**
 * Kullanıcının ders ve konu bazlı çalışma hedefini temsil eden model sınıfı.
 * @author Melike Türkalp
 */
public class CalismaPlani {
// 1. kapsülleme - Encapsulation: değişkenler private
	// planId ve kullanıcıId değişmeyecek olarak planladı şimdilik. O yüzden final diye kurdum.
    private final int planId;
    private final int kullaniciId;
    
    private String dersAdi;
    private String konu;
    private int hedefSureDakika;
    private LocalDate planTarihi;
    private String aciklama;
    
 // 2. kurucu metod (Constructor): Nesne oluşturulurken ilk değerlerin atanması lazim.
    
    public CalismaPlani(int planId, int kullaniciId,String dersAdi, String konu, int hedefSureDakika,LocalDate planTarihi,String aciklama) {
    	
    	//pozitifSayiDoğrula metodu girişlerin uygun olup olmadığına bakar ve daha sonra id olarak kaydeder.
        this.planId = pozitifSayiDogrula(planId, "Plan ID");
        this.kullaniciId =
                pozitifSayiDogrula(kullaniciId, "Kullanıcı ID");
        
        this.dersAdi = zorunluMetinDogrula(dersAdi, "Ders adı");
        //ders adı metin girişi olarak alınmak zorunda. bu yüzden zorunluMetinDogrula metodu kullanılıyor.
        this.konu = zorunluMetinDogrula(konu, "Konu");
        
        this.hedefSureDakika = pozitifSayiDogrula(hedefSureDakika, "Hedef süre");
        this.planTarihi = tarihDogrula(planTarihi);
        this.aciklama = aciklama;
    }
        //Girişlerin doğru yapılmasını sağlayan şart koşullarını işeren metotlar
        
        private static int pozitifSayiDogrula(int deger, String alanAdi) {
            if (deger <= 0) {
                throw new IllegalArgumentException(
                        alanAdi + " sıfırdan büyük olmalıdır.");
            }

            return deger;
        }
        private static String zorunluMetinDogrula(
                String deger, String alanAdi) {

            if (deger == null || deger.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        alanAdi + " boş bırakılamaz.");
            }

            return deger.trim();
        }

        private static LocalDate tarihDogrula(LocalDate tarih) {
            if (tarih == null) {
                throw new IllegalArgumentException(
                        "Plan tarihi boş bırakılamaz.");
            }

            return tarih;
        
    }
 // 3. GETTER VE SETTER METOTLARI
    // planId değiştirilmez ama kullaniciId (şuanlık )oluşturulduktan sonra değiştirilmez (Setter yazılmaz)
    
    public int getPlanId() { return planId; }
    public int getKullaniciId() { return kullaniciId; }

    public String getDersAdi() { return dersAdi; }
    public void setDersAdi(String dersAdi) 
    {
    	this.dersAdi = zorunluMetinDogrula(dersAdi, "Ders adı");
    }

    public String getKonu() { return konu; }
    public void setKonu(String konu) {
    	this.konu = zorunluMetinDogrula(konu, "Konu");
    }

    public int getHedefSureDakika() { return hedefSureDakika; }
    public void setHedefSureDakika(int hedefSureDakika) {
    	this.hedefSureDakika = pozitifSayiDogrula(hedefSureDakika, "Hedef süre");
    }

    public LocalDate getPlanTarihi() { return planTarihi; }
    public void setPlanTarihi(LocalDate planTarihi) {
    	this.planTarihi = tarihDogrula(planTarihi);
    }

    public String getAciklama() { return aciklama; }
    public void setAciklama(String aciklama) { this.aciklama = aciklama; }
    
 // nesneyi okunabilir biçimde yazdırmak için toString() metodunu Override etmeliyiz 
    @Override
    public String toString() {
        return "Plan [ID=" + planId + ", Kullanıcı=" + kullaniciId + ", Ders=" + dersAdi + 
               ", Konu=" + konu + ", Hedef=" + hedefSureDakika + " dk, Tarih=" + planTarihi + "]";
    }
}




