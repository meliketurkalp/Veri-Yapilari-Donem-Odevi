public class HashTable {
    Node dizi[];
    int size;
    public HashTable(int size){
        this.size=size;
        dizi=new Node[size];

        for(int i=0; i<size;i++){ //for döngüsü dizinin içerisindeki ilk değerleri atamasını yapıyor
            dizi[i]=new Node();
        }
    }
    int indexUret(int key){ //eleman eklerken dizinin indis numarasına göre ekliyoruz bu yüzden dizi boyutuna göre mod aldık
        return key % size;
    }

    void ekle(int key,String isim){
        int index = indexUret(key);

        Node eleman =new Node(key,isim);
        Node temp= dizi[index];

        while(temp.next!=null)//ilgili bağlı listenin sonuna ekleme yaptı
            temp=temp.next;

        temp.next=eleman;

        System.out.println(eleman.isim +" eklendi");
    }

    void sil(int key){
        //düğümün hangi dizide bulunduğunu bulmalıyız
        int indis=indexUret(key);
        Node temp=dizi[indis];//dizinin içindeki null sayısı
        Node temp2=dizi[indis];//silme işlemi için gerkeli

        if(temp.next==null){//dizide eleman yok demektir
            System.out.println(key+ " numaralı kayıt yok");
        }else if(temp.next.next==null&& temp.next.next.key==key){//dizinin bulunduğu idniste bir tane düğüm var demektir
            //silmek istediğimiz düğümün bu düğüm olduğunu söyledik
            temp.next=null;
            System.out.println(key+ "silindi");
        }else {
            while(temp.next!=null){
                if(temp.key==key){
                    temp2.next=temp.next;
                    System.out.println(key+  " silindi");
                }

                temp2=temp;
                temp=temp.next;
            }

        }



    }
}
