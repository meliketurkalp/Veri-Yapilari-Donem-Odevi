package tr.edu.inonubm.studyapp;

import java.time.LocalDate;
import tr.edu.inonubm.studyapp.model.CalismaPlani;
import tr.edu.inonubm.studyapp.structure.Dugum;
import tr.edu.inonubm.studyapp.structure.CiftYonluBagliListe;

public class METADS_Plan {

    public static void main(String[] args) {

    	CalismaPlani plan = new CalismaPlani(
    	        1,
    	        1,
    	        "Veri Yapıları",
    	        "Çift yönlü bağlı liste",
    	        90,
    	        LocalDate.of(2026, 10, 26),
    	        "Ortak örnek plan"
    	);
    	
    	CiftYonluBagliListe<CalismaPlani> planlar =
    	        new CiftYonluBagliListe<>();

    	// Boş listeyi dolaşmak hata oluşturmamalı.
    	planlar.dolas();

    	// Mevcut planı listeye eklenir
    	planlar.ekle(plan);

    	//ikinci bir deneme planı ekledim.
    	CalismaPlani ikinciPlan = new CalismaPlani(
    	        2,
    	        1,
    	        "Veri Yapıları",
    	        "Yığın",
    	        30,
    	        LocalDate.of(2026, 10, 26),
    	        "İkinci örnek plan"
    	);

    	planlar.ekle(ikinciPlan);

    	System.out.println("Listedeki planlar:");
    	planlar.dolas();
    	
    	System.out.println("\nTek düğüm denemesi:");
    	
    	Dugum<CalismaPlani> dugum = new Dugum<>(plan);

    	System.out.println(dugum.getVeri());
    	System.out.println(dugum.getOnceki());
    	System.out.println(dugum.getSonraki());

    	System.out.println("\nModel ve doğrulama denemesi:");
        System.out.println(plan);
        
        // try- catch test sonucunu görmek için deneme (daha sonra silinebilir)

        try {
            plan.setHedefSureDakika(0);
        } catch (IllegalArgumentException hata) {
            System.out.println(hata.getMessage());
        }

        System.out.println(
                "Planın hedef süresi: " + plan.getHedefSureDakika());
    }
}
/*
 * GELİŞTİRME NOTU:
Sona ekleme O(1): son referansı sayesinde listenin sonunu aramıyoruz; sabit sayıda bağlantı değiştiriyoruz.
Dolaşma O(n): Her düğüme bir kez uğruyoruz.
Çift yönlü olma sebebi: Her düğüm hem önceki hem sonraki düğüme referans tutuyor.
Bu denemenin kapsamı: Boş listeyi dolaşmayı, ilk eklemeyi, dolu listeye eklemeyi ve ileri dolaşmayı deniyoruz. 
Silme ve geri dolaşma henüz bu adımın içinde değil.

BEKLENEN ÇIKTI:
Listedeki planlar:
Plan [ID=1, Kullanıcı=1, Ders=Veri Yapıları, Konu=Çift yönlü bağlı liste, Hedef=90 dk, Tarih=2026-10-26]
Plan [ID=2, Kullanıcı=1, Ders=Veri Yapıları, Konu=Yığın, Hedef=30 dk, Tarih=2026-10-26]

Tek düğüm denemesi:
Plan [ID=1, Kullanıcı=1, Ders=Veri Yapıları, Konu=Çift yönlü bağlı liste, Hedef=90 dk, Tarih=2026-10-26]
null
null

Model ve doğrulama denemesi:
Plan [ID=1, Kullanıcı=1, Ders=Veri Yapıları, Konu=Çift yönlü bağlı liste, Hedef=90 dk, Tarih=2026-10-26]
Hedef süre sıfırdan büyük olmalıdır.
Planın hedef süresi: 90
  
 */
