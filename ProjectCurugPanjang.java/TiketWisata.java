// TiketWisata adalah turunan dari abstract class Tiket
// extends artinya TiketWisata mewarisi atribut dan method dari Tiket
public class TiketWisata extends Tiket {

    // Atribut khusus untuk tiket wisata
    // Isinya bisa WNI atau WNA
    private String kategori;


    // Constructor TiketWisata
    public TiketWisata(String kodeTiket, String namaTiket, double harga,
                       int jumlah, String kategori) {

        // super digunakan untuk memanggil constructor dari class Tiket
        // Data kode, nama, harga dan jumlah dikirim ke class induk
        super(kodeTiket, namaTiket, harga, jumlah);

        // Menyimpan kategori tiket
        this.kategori = kategori;
    }


    // Constructor kosong
    public TiketWisata() {
    }


    // Setter untuk mengubah kategori
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }


    // Getter untuk mengambil kategori
    public String getKategori() {
        return kategori;
    }


    // Mengisi abstract method dari class Tiket
    // Method ini dibuat khusus untuk menampilkan informasi tiket wisata
    public void tampilkanInfo() {

        // Menampilkan informasi tiket wisata
        System.out.println("Tiket Wisata");
        System.out.println("Kategori : " + kategori);
        System.out.println("Nama Tiket : " + getNamaTiket());
        System.out.println("Harga : Rp " + (int)getHarga());
        System.out.println("Jumlah : " + getJumlah());
    }
}