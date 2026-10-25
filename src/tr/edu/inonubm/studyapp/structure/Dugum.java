package tr.edu.inonubm.studyapp.structure;

/**
 * Çift yönlü bağlı listede veri ve bağlantıları tutar.
 *
 * @param <T> Düğümün taşıdığı veri tipi
 * @author Melike Türkalp
 */

public class Dugum<T> {

    private T veri;
    private Dugum<T> onceki;
    private Dugum<T> sonraki;

    public Dugum(T veri) {
        this.veri = veri;
        this.onceki = null;
        this.sonraki = null;
    }

    public T getVeri() {
        return veri;
    }

    public void setVeri(T veri) {
        this.veri = veri;
    }

    public Dugum<T> getOnceki() {
        return onceki;
    }

    public void setOnceki(Dugum<T> onceki) {
        this.onceki = onceki;
    }

    public Dugum<T> getSonraki() {
        return sonraki;
    }

    public void setSonraki(Dugum<T> sonraki) {
        this.sonraki = sonraki;
    }
}
/*
 * Dugum<T>, veriyi ve çift yönlü bağlantıları tutan sınıfım. 
 * T sayesinde aynı düğüm tasarımını farklı model tipleriyle kullanabiliyorum. 
 * veri taşınan nesneye, 
 * onceki ve sonraki ise komşu düğümlere referans tutuyor. 
 * Yeni düğümün bağlantıları başlangıçta null; bunları 
 * bağlı listenin ekleme ve silme metotları düzenleyecek. 
 * Çalışma planının bilgilerini modelde, bağlantılarını düğümde tutarak sorumlulukları ayırıyorum
 */