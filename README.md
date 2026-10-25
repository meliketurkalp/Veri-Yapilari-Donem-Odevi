# Veri Yapıları Dönem Ödevi

Veri yapıları dersi 2026 güz dönemi proje ödevi. Ekip, çalışma planlarını ve gerçekleşen çalışma sürelerini takip eden bir Java uygulaması geliştiriyor.

## Şu anki durum

Bu depoda Diyar'ın 1. hafta için hazırladığı çalışan örnek bulunuyor. Örnek konsolda çalışıyor; son uygulamanın arayüzü ve diğer ekip parçaları henüz birleştirilmedi.

## Diyar'ın yaptığı bölüm

- [Kullanici.java](src/model/Kullanici.java): Kullanıcı numarası, adı, bölümü, sınıfı ve rolü gibi bilgileri tutuyor.
- [CalismaKaydi.java](src/model/CalismaKaydi.java): Kayıt numarası, bağlı plan numarası, tarih ve çalışılan dakikayı tutuyor.
- [GunlukOnay.java](src/model/GunlukOnay.java): Kullanıcı numarası, tarih ve günün onay durumunu tutuyor.
- [Main.java](src/model/Main.java): Bu sınıfları kullanan 1. hafta örneği.

Kimlikler int ve oluşturulduktan sonra değişmiyor. Tarihler LocalDate ile tutuluyor. Main.java, for döngüsüyle kayıtları geziyor ve if koşuluyla seçilen plan ve tarihe ait süreleri topluyor. Aynı plana ait 25 ve 35 dakikalık kayıtların toplamı 60 dakika. 90 dakikalık örnek hedefe göre ilerleme %66,7, kalan süre 30 dakika. Başka plana ait deneme kaydı toplama katılmıyor.

Örnek, küçük bir kullanıcı verisini data/ornek-kullanici.metads metin dosyasına yazıp geri okuyor. Dosya program çalıştırılınca oluşur; bu yalnızca ilk hafta gösterimidir.

## Çalıştırma

Java JDK 21 ile VS Code'da src/model/Main.java dosyasını açıp Ctrl+F5 tuşlarına basın. Çıktının sonunda “Dosyadan okunan: Diyar” görünür.

## Birleştirme için sonraki adım

Main.java içindeki planId = 1 ve hedefDakika = 90 geçici örnek değerlerdir. Melike'nin CalismaPlani sınıfı gelince gerçek plan kimliği ve hedef süre oradan alınacak. Örnekteki dizi, ekibin çift yönlü bağlı listesine bağlanacak. Dört veri türünün tamamını kaydeden son dosya yönetimi de ortak modeller ve listeyle birlikte yapılacak.
