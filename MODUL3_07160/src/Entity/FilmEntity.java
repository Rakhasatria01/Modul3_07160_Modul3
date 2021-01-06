package Entity;
import java.util.Date;

public class FilmEntity extends induk {
 
    private int harga;
    private Date tanggaltayang;
    private int index,indexakun;

    public FilmEntity(String nama, int harga,Date tanggaltayang) {
        super.nama = nama;
        this.harga = harga;
        this.tanggaltayang = tanggaltayang;
    }
    public FilmEntity(int index,int indexakun){
        this.index=index;
        this.indexakun=indexakun;
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndexakun() {
        return indexakun;
    }

    public void setIndexakun(int indexakun) {
        this.indexakun = indexakun;
    }

    public Date getTanggaltayang() {
        return tanggaltayang;
    }

    public void setTanggaltayang(Date tanggaltayang) {
        this.tanggaltayang = tanggaltayang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
}
