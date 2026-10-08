// Class Tiket adalah abstract class
// Class ini menjadi class induk untuk TiketWisata dan TiketKendaraan
// Abstract class tidak dibuat object secara langsung
public abstract class Tiket {

    // Atribut untuk menyimpan kode tiket
    private String kodeTiket;

    // Atribut untuk menyimpan nama tiket
    private String namaTiket;

    // Atribut untuk menyimpan harga satu tiket
    private double harga;

    // Atribut untuk menyimpan jumlah tiket yang dibeli
    private int jumlah;


    // Constructor dengan parameter
    // Constructor ini dipakai untuk langsung mengisi data tiket
    public Tiket(String kodeTiket, String namaTiket, double harga, int jumlah) {

        // Memasukkan nilai parameter ke atribut
        this.kodeTiket = kodeTiket;
        this.namaTiket = namaTiket;
        this.harga = harga;
        this.jumlah = jumlah;
    }


    // Constructor kosong
    public Tiket() {
    }


    // Abstract method
    // Method ini belum memiliki isi di class Tiket
    // Class turunan harus membuat isi dari method ini
    public abstract void tampilkanInfo();


    // Setter untuk mengubah kode tiket
    public void setKodeTiket(String kodeTiket) {
        this.kodeTiket = kodeTiket;
    }


    // Setter untuk mengubah nama tiket
    public void setNamaTiket(String namaTiket) {
        this.namaTiket = namaTiket;
    }


    // Setter untuk mengubah harga tiket
    public void setHarga(double harga) {
        this.harga = harga;
    }


    // Setter untuk mengubah jumlah tiket
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }


    // Getter untuk mengambil kode tiket
    public String getKodeTiket() {
        return kodeTiket;
    }


    // Getter untuk mengambil nama tiket
    public String getNamaTiket() {
        return namaTiket;
    }


    // Getter untuk mengambil harga tiket
    public double getHarga() {
        return harga;
    }


    // Getter untuk mengambil jumlah tiket
    public int getJumlah() {
        return jumlah;
    }


    // Method untuk menghitung subtotal
    // Rumusnya harga dikali jumlah
    public double getSubtotal() {
        return harga * jumlah;
    }
}