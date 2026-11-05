public class Main {
    public static void main(String[]args){
        HashTable hTablo= new HashTable(5);

        hTablo.ekle(10,"Merve");
        hTablo.ekle(21,"Melek");
        hTablo.ekle(41,"Hayat");
        hTablo.ekle(4,"Selim");
        hTablo.ekle(55,"Mehmet");
        hTablo.ekle(100,"Türkan");
        hTablo.sil(55);


        System.out.println(hTablo.dizi[0].next.isim);
        //burada 0.indisteki düğümün ardından gelen elemanın ismi yazdırıldı
        //next sayısını arttırıp oradaki başka eleman varsa yazdırabilriz

        //dizi[0].isim yazılsaydı null vericekti çünkü dizinin içerisindeki düğümlerin hepsi null
        //dizi içerisine boş düğüm tanımamızın sebebi ardına yeni eleman ekleyebilmek


    }
}
