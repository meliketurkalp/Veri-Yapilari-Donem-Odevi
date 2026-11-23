# METADS — Bireysel Çalışma Planı ve Hedef Takip Sistemi

**Ders:** Veri Yapıları (2026 Güz Dönemi)  
**Proje Kodu:** VY-005  
**Geliştirme Ortamı:** Java (Eclipse / VS Code), Java Swing

## Proje Özeti
METADS; kullanıcıların ders ve konu bazlı çalışma planları oluşturmasını, gerçekleşen çalışma sürelerini kaydetmesini, günlük/haftalık ilerlemelerini takip etmesini ve hedeflerini arayarak sıralamasını sağlayan bir masaüstü uygulamasıdır. Veriler veritabanı kullanılmadan, proje içinde özel uzantılı metin dosyalarında tutulacak; açılışta bellekteki veri yapılarına yüklenip değişiklik sonrası dosyaya toplu olarak yazılacaktır.

## Mimari ve Paket Yapısı
* **Ana paket:** `tr.edu.inonubm.studyapp` (`METADS_Plan` başlangıç sınıfı)
* **Modeller (`model`):** `Kullanici`, `CalismaPlani`, `CalismaKaydi`, `GunlukOnay`, `SilmeIslemi`
* **Veri Yapıları (`structure`):** `Dugum<T>`, `CiftYonluBagliListe<T>`, `KarmaTablo`, `AgacDugumu`, `IkiliAramaAgaci`, `GorevKuyrugu`, `GeriAlYigini`
* **Servisler (`service`):** `PlanServisi`, `KullaniciServisi`, `KayitServisi`, `GunlukTakipServisi`, `HesaplamaMotoru`, `AramaSiralamaMotoru`, `CalismaPlanlamaMotoru`, `CalismaSirasiServisi`, `DosyaYonetimi`
* **Arayüz (`gui`):** Giriş, kayıt, ana ekran, takvim, gün detayı ve yönetici ekranları

**Genel Akış:** Arayüz ekranları (`Berfin`) işlemleri doğrudan veri yapılarına değil, servis katmanına iletir. `PlanServisi` (`Melike`), `Kayit/Hesaplama` (`Diyar`), `Arama/Sıralama` (`Berfin`) ve `DosyaYonetimi` (`Merve`) ortak `CiftYonluBagliListe` üzerinde çalışır; hızlı erişim `KarmaTablo` (`Merve`), sıralı/kuyruk işlemleri ise ağaç ve kuyruk yapıları (`Ahmet`) ile desteklenir.

## Güncel Görev Dağılımı ve Sorumluluklar

| Üye | Sorumlu Olduğu Sınıflar | Görev Sınırı |
| :--- | :--- | :--- |
| **Melike** | `METADS_Plan`, `CalismaPlani`, `Dugum<T>`, `CiftYonluBagliListe<T>`, `PlanServisi` | Plan işlemlerini yürütür; ortak bağlı liste ve indeks tutarlılığını sağlar. |
| **Diyar** | `Kullanici`, `CalismaKaydi`, `GunlukOnay`, `SilmeIslemi`, `KullaniciServisi`, `KayitServisi`, `GunlukTakipServisi`, `HesaplamaMotoru`, `GeriAlYigini` | Kayıt ilişkilerini, süre/ilerleme hesaplamalarını, günlük onay kurallarını ve geri alma yapısını geliştirir. |
| **Ahmet** | `AgacDugumu`, `IkiliAramaAgaci`, `GorevKuyrugu`, `CalismaSirasiServisi` | Ağaç ve kuyruk veri yapılarının iç işlemlerini ve çalışma sırası akışını geliştirir. |
| **Berfin** | `gui` ekranları, `AramaSiralamaMotoru`, `CalismaPlanlamaMotoru` | Swing ekranlarını servislere bağlar; filtreleme, sıralama ve çalışma sırası önerisini geliştirir. |
| **Merve** | `KarmaTablo` (gerekirse `HashKaydi`), `DosyaYonetimi` | Anahtar/kimlik ile hızlı erişimi, çakışma çözümünü ve metin dosyası kalıcılığını geliştirir. |

## Mevcut Geliştirme Durumu ve Bireysel Katkılar

### Melike — Plan Modeli ve Çift Yönlü Bağlı Liste
* `CalismaPlani.java`: Plan ve kullanıcı kimlikleri (`final int`), ders, konu, hedef süre, `LocalDate` tarih ve açıklama alanları ile doğrulama kontrolleri (`pozitifSayiDogrula`, `zorunluMetinDogrula`, `tarihDogrula`) yazıldı.
* `Dugum.java`: Her model tipiyle çalışabilen jenerik `Dugum<T>` yapısı (`veri`, `onceki`, `sonraki`) oluşturuldu.
* `CiftYonluBagliListe.java`: `bas`, `son` ve `boyut` takibi ile `O(1)` sona ekleme (`ekle`) ve `O(n)` ileri dolaşma (`dolas`) metotları geliştirildi.
* `METADS_Plan.java`: Boş liste dolaşma, örnek plan ekleme/listeleme, bağımsız düğüm kontrolü ve geçersiz süre (`IllegalArgumentException`) denemeleri konsol üzerinden test edildi.
* *Sıradaki adım:* `sil` metodunu tamamlamak, geri bağlantıları test etmek ve `PlanServisi` üzerinden diğer yapılarla entegre etmek.

### Diyar — Kullanıcı, Kayıt, Onay Modelleri ve İlerleme Hesabı
* `Kullanici.java`, `CalismaKaydi.java`, `GunlukOnay.java`: Temel alanlar `int` kimlik ve `LocalDate` standartlarıyla oluşturuldu.
* `Main.java` (1. hafta denemesi): Örnek çalışma kayıtlarının toplam süresi, yüzde ilerleme ve kalan süre hesabı ile `.metads` uzantılı örnek metin dosyası okuma/yazma akışı test edildi.
* *Sıradaki adım:* Geçici diziyi ortak `CiftYonluBagliListe` yapısına bağlamak, `GeriAlYigini` ve servis sınıflarını tamamlamak.

### Ahmet — Doğrusal Arama Denemesi
* `AramaDenemesi.java`: Plan kimliğine göre doğrusal arama denemesi eklendi.
* *Sıradaki adım:* `IkiliAramaAgaci`, `GorevKuyrugu` ve `CalismaSirasiServisi` sınıflarını geliştirip ortak paket yapısına dahil etmek.

### Berfin — Swing Arayüz Ön Çalışması
* `GirisEkrani.java` ve `KayıtEkrani.java`: Java Swing tabanlı temel giriş ve kayıt ekranı bileşenleri oluşturuldu.
* *Sıradaki adım:* Panelleri ortak paket yapısına taşıyıp servis katmanına bağlamak; arama/sıralama motorunu eklemek.

### Merve — Karma Tablo (Hash Table) Denemesi
* `HashTable.java`, `Node.java` ve test `Main.java`: Temel karma tablo yapısı ve düğüm denemesi eklendi.
* *Sıradaki adım:* Karma tabloyu `tr.edu.inonubm.studyapp.structure` paketine uyarlamak ve `DosyaYonetimi` sınıfını tamamlamak.

## Çalıştırma Adımları
1. Depoyu bilgisayarınıza klonlayın ve projeyi Eclipse IDE üzerinden içe aktarın (**File > Import > Existing Projects into Workspace**).
2. Projenin JDK sürümünü (Java 17/21) kontrol edin.
3. Mevcut aşamadaki testleri çalıştırmak için `src/tr/edu/inonubm/studyapp/METADS_Plan.java` (veya ilgili deneme `Main` sınıflarına) sağ tıklayıp **Run As > Java Application** seçeneğini kullanın.

## Yararlanılan Kaynaklar
* Veri Yapıları ders notları, laboratuvar föyleri ve *C & Java ile Veri Yapılarına Giriş* (Olcay Taner Yıldız).
* Proje planlama, Java doğrulama/veri yapısı kavramlarını pekiştirme, hata ayıklama ve README dokümantasyonunu düzenleme süreçlerinde yapay zekâ araçlarından (ChatGPT, Gemini) öğrenme ve rehberlik amaçlı yararlanılmış; kodlar anlaşılarak ve test edilerek projeye dahil edilmiştir.