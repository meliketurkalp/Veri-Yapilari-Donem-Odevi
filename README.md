
# METADS — Bireysel Çalışma Planı ve Hedef Takip Sistemi

**Veri Yapıları Dersi · 2026 Güz Dönemi Projesi**

METADS; kullanıcıların çalışma planlarını, gerçekleşen çalışma sürelerini ve hedeflerine yönelik ilerlemelerini takip etmelerini amaçlar.

Proje Java ile Eclipse ortamında geliştirilmektedir. Kullanıcı arayüzü Swing ile hazırlanacaktır. Mevcut aşamada model ve veri yapısı denemeleri konsol üzerinden yürütülmektedir.

## Proje yapısı

- **Ana paket:** `tr.edu.inonubm.studyapp`
- **Başlangıç sınıfı:** `METADS_Plan`
- **Modeller:** `tr.edu.inonubm.studyapp.model`
- **Veri yapıları:** `tr.edu.inonubm.studyapp.structure`

## Görev dağılımı

Aşağıdaki dağılım sorumlulukları belirtir. Planlanan bütün sınıfların tamamlandığı anlamına gelmez.
Görev dağılımı, üyelerin geri bildirimleri dikkate alınarak Melike tarafından yapay zekâ desteğiyle hazırlanmıştır. Ekip kararlarıyla güncellenebilir.

| Üye | Sorumluluk |

| **Melike** | Başlangıç yapısı, ortak bağlı listeler, karma tablo ve plan işlemleri |

| **Diyar** | Kullanıcılar, çalışma kayıtları, günlük onay, hesaplama ve geri alma |

| **Ahmet** | Ağaç yapısı, arama, filtreleme, sıralama ve çalışma sırası |

| **Berfin** | Swing arayüzleri ve dosya yükleme/kaydetme işlemleri |


### Sorumlu olunan sınıflar

**Melike:** `METADS_Plan`, `CalismaPlani`, `Dugum`, `CiftYonluBagliListe`, `KarmaTablo`, `PlanServisi`

**Diyar:** `Kullanici`, `CalismaKaydi`, `GunlukOnay`, `KullaniciServisi`, `KayitServisi`, `GunlukTakipServisi`, `HesaplamaMotoru`, `GeriAlYigini`

**Ahmet:** `AgacDugumu`, `IkiliAramaAgaci`, `GorevKuyrugu`, `AramaSiralamaMotoru`, `CalismaSirasiServisi`

**Berfin:** `gui` paketindeki ekranlar ve `DosyaYonetimi`

## İlk hafta geliştirme notları — Melike

Bu bölüm yerel ortamda oluşturulan ve çalıştırılan kodları açıklar. Diğer üyelerin katkıları ve ortak uygulama sonuçları ayrıca eklenecektir.

#### CalismaPlani.java

Bir çalışma planının şu bilgilerini taşır:

- Plan ve kullanıcı kimliği
- Ders adı ve konu
- Hedef çalışma süresi
- Plan tarihi
- Açıklama

Kurucu nesnenin başlangıç değerlerini alır. Getter metotları bilgileri okumak, setter metotları değiştirilebilir alanları güncellemek için kullanılır.

Plan ve kullanıcı kimlikleri `final` tanımlanmıştır; oluşturulduktan sonra değiştirilemez.

**Doğrulama yardımcıları:**

- `pozitifSayiDogrula`: Kimliklerin ve hedef sürenin sıfırdan büyük olmasını kontrol eder.
- `zorunluMetinDogrula`: Ders ve konunun boş olmamasını kontrol eder; baştaki ve sondaki boşlukları temizler.
- `tarihDogrula`: Tarihin `null` olmamasını kontrol eder.

Açıklama isteğe bağlıdır. `toString()` planın okunabilir biçimde yazdırılmasını sağlar.

Kimlik benzersizliği ve kullanıcının sistemde bulunması gibi servis düzeyindeki kontroller henüz tamamlanmamıştır.

### Dugum.java

`Dugum<T>`, farklı model tipleriyle kullanılabilen jenerik düğüm sınıfıdır.

- `veri`: Taşınan nesneye referans tutar.
- `onceki`: Önceki düğüme referans tutar.
- `sonraki`: Sonraki düğüme referans tutar.

Kurucu veriyi alır; bağlantılar başlangıçta `null` olur. Alanlara getter/setter metotları üzerinden erişilir.

Düğüme bir plan verilmesi, planın kopyasının oluşturulması anlamına gelmez. Düğüm mevcut plan nesnesine referans tutar.

### CiftYonluBagliListe.java

Liste, düğümleri ve aralarındaki bağlantıları yönetir.

- `bas`: İlk düğümü gösterir.
- `son`: Son düğümü gösterir.
- `boyut`: Düğüm sayısını tutar.

**`ekle(T veri)` — Sona ekleme**

`ekle(T veri)` listenin sonuna ekleme yapar:

1. Veriyi taşıyan yeni bir düğüm oluşturulur.
2. Liste boşsa `bas` ve `son` aynı düğümü gösterir.
3. Liste boş değilse eski son ile yeni düğüm arasında ileri ve geri bağlantılar kurulur.
4. `son`, yeni düğümü gösterecek şekilde güncellenir.
5. Her iki durumda da `boyut` bir artırılır.

**`dolas()` — İleri dolaşma**

`dolas()` ileri yönde dolaşır:

1. Geçici referans başlangıçta `bas` düğümünü gösterir.
2. Geçici referans `null` olmadığı sürece düğümün verisi yazdırılır.
3. Geçici referans sonraki düğüme ilerletilir.
4. Son düğüm de yazdırıldıktan sonra geçici referans `null` olur ve döngü biter.

**Zaman maliyetleri:**

- Sona ekleme: **O(1)** — son düğümü aramak gerekmez.
- Dolaşma: **O(n)** — her düğüm ziyaret edilir. Konsola yazdırmanın maliyeti ayrıca taşınan veriye bağlıdır.

### METADS_Plan.java

`main(String[] args)` metodunu içeren başlangıç sınıfıdır.

Mevcut aşamada örnek planları oluşturur; liste, bağımsız düğüm ve model doğrulama denemelerini çalıştırır.

Ortak verilerin bütün servislere bağlanması henüz tamamlanmamıştır.

## Çalıştırılan denemeler

| Deneme |  Gözlenen sonuç |


- Boş listeyi dolaşma: Hata veya veri çıktısı oluşmadı.
- İki plan ekleyip dolaşma: Planlar eklenme sırasıyla yazdırıldı.
- Bağımsız düğüm oluşturma: Plan bilgileri ve iki `null` bağlantı yazdırıldı.
- Hedef süreyi `0` yapma: `IllegalArgumentException` yakalandı.
- Geçersiz güncellemeden sonra süreyi okuma: Önceki hedef süre olan 90 dakika korundu.

Denemelerde kullanıcı kimliği `1` olan kullanıcı için iki örnek plan oluşturulmuştur:

- **Plan 1:** Çift yönlü bağlı liste, 90 dakika.
- **Plan 2:** Yığın, 30 dakika.
- **Her iki planın tarihi:** 26 Ekim 2026.

Konsoldaki tekrarlar farklı denemelerde aynı planın yazdırılmasından kaynaklanır. Bağımsız düğümün iki bağlantısının `null` olması beklenen durumdur.

Bu kontroller bütün olası durumları kapsamaz. Geri bağlantılar henüz bağımsız bir geri dolaşma denemesiyle doğrulanmamıştır.

Örnek veriler bellekte oluşturulmaktadır. Dosyadan yükleme ve kalıcı kaydetme bu denemeye bağlanmamıştır.

## Çalıştırma

1. Projeyi Eclipse’te açın.
2. Projenin JDK yapılandırmasını kontrol edin.
3. Dosyaları kaydedin ve derleme hatalarını giderin.
4. `METADS_Plan.java` üzerinde **Run As → Java Application** seçin.
5. Sonuçları **Console** bölümünden inceleyin.

## Sıradaki işler

- Bağlı listenin `sil(T veri)` metodunu tamamlamak.
- Geri bağlantıları ayrıca sınamak.
- `KarmaTablo` ve `PlanServisi` sınıflarını geliştirmek.
- Ortak veri yapılarını ilgili servislere bağlamak.
- Ekip kodlarını birleştirip birlikte çalıştırmak.
- Dosya işlemlerini ve GUI akışlarını bütünleştirmek.

## Ortak çalışma düzeni

- Her üye kendi bölümünü geliştirir, test eder ve kendi GitHub hesabıyla depoya aktarır.
- Ekranlar işlemleri servisler üzerinden yürütür; servisler ortak veri yapılarını kullanır.
- Haftalık toplantıda çalışan bölümler birleştirilir ve herkes kendi katkısını açıklar.
- Bütünleştirme sonrasında kod yeniden çalıştırılır; eksikler ve hatalar kaydedilir.
- Her üye tamamladığı işleri ve deneme sonuçlarını README’ye ekler.
- Ortak dosyalar düzenlenirken ekip üyeleri birbirini bilgilendirir.

## Alınan yardım

Melike, görev dağılımını belirlemek ve readme kısmını oluşturmak için yapay zekadan yaralanmıştır.

Doğrulamaların geliştirilmesinde; `Dugum`, bağlı listede ekleme/dolaşma ve başlangıç denemelerinde ChatGPT ve Gemini kod örnekleri ile açıklamalarından yararlanılmıştır.

Diğer üyeler kendi çalışmalarında yararlandıkları kaynakları ve destekleri ayrıca belirtecektir.

## İlk hafta geliştirme notları — Diyar

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

