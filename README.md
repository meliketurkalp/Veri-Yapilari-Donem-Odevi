# Veri Yapilari Donem Odevi
Veri yapıları dersi 2026 güz dönemi proje ödevi

#METADS - Bireysel Çalışma Planı ve Hedef Takip Sistemi

| Üye | Sorumluluk | Temel sınıflar |

| Melike | Uygulamanın başlangıç yapısı, ortak bağlı listeler, karma tablo ve plan ekleme/silme/güncelleme işlemleri | METADS_Plan, CalismaPlani, Dugum, CiftYonluBagliListe, KarmaTablo, PlanServisi |

| Diyar | Kullanıcı ve çalışma kayıtları, günlük onay, süre ve ilerleme hesaplama, geri alma işlemleri | Kullanici, CalismaKaydi, GunlukOnay, KullaniciServisi, KayitServisi, GunlukTakipServisi, HesaplamaMotoru, GeriAlYigini |

| Ahmet | Ağaç yapısı, ders/konu/tarih filtreleme, sıralama ve çalışma sırası yönetimi | AgacDugumu, IkiliAramaAgaci, GorevKuyrugu, AramaSiralamaMotoru, CalismaSirasiServisi |

| Berfin | Swing arayüzleri, dosyadan ortak bağlı listelere veri yükleme ve listeleri dolaşarak dosyaya kaydetme | gui paketindeki ekranlar, DosyaYonetimi |

### Ortak Çalışma Düzeni

- Her üye kendi bölümünü geliştirir, test eder ve kendi GitHub hesabıyla depoya aktarır.
- Ekranlar işlemleri servisler üzerinden yürütür; servisler ortak veri yapılarını kullanır.
- Haftalık toplantıda çalışan bölümler birleştirilir ve herkes kendi katkısını açıklar.
- Bu tablo sorumluluk dağılımını gösterir; tamamlanan işler geliştirme sürecinde ayrıca belirtilir.