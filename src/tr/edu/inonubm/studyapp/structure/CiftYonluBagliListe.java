package tr.edu.inonubm.studyapp.structure;

/**
 * Verileri çift yönlü bağlı düğümlerde tutar.
 *
 * @param <T> Listede taşınacak veri tipi
 * @author Melike Türkalp
 */
public class CiftYonluBagliListe<T> {

    private Dugum<T> bas;
    private Dugum<T> son;
    private int boyut;

    public CiftYonluBagliListe() {
        this.bas = null;
        this.son = null;
        this.boyut = 0;
    }
    /* yeni bri liste oluşurken henüzz düğüm yok
     * ilk düğüm yok -> bas = null
     * son dügüm yok -> son = null
     * eleman sayısı = 0
     */
    
    public void ekle(T veri) {
    	/*
    	 * CalismaPlani verilerini alan metot.
    	 */
    	
        Dugum<T> yeniDugum = new Dugum<>(veri);
        
        /*liste boşsa tek bir düğüm tanımlanır. 
         * baş ve son aynı düğümde  referans tutar.
         * liste boş değilse son düğümün sonraki bağını yeni düğüme bağlayacağız.
         * yeni düğümün önceki bağını mevcut son düğüme bağlayacağız.
         */


        if (bas == null) {
            bas = yeniDugum;
            son = yeniDugum;
        } else {
            son.setSonraki(yeniDugum);
            yeniDugum.setOnceki(son);
            son = yeniDugum;
        }

        boyut++;
    }
 /* dolaşırken geçici kullanmamızın sebebi liste başını korumak. 
  * liste boşsa başlangıç null olur. döngü çalışmaz.
  * Başlangıçta hem bas hem gecici birinci düğümü gösterir.
  * gecici değişkenini bir sonraki düğüme geçirir.
  */
    public void dolas() {

        Dugum<T> gecici = bas;

        while (gecici != null) {
            System.out.println(gecici.getVeri());
            gecici = gecici.getSonraki();
        }
    }
}