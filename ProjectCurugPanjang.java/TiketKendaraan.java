// TiketKendaraan adalah turunan dari abstract class Tiket
// extends artinya TiketKendaraan mewarisi atribut dan method dari Tiket
public class TiketKendaraan extends Tiket {

    // Atribut khusus untuk tiket kendaraan
    // Isinya bisa R2 atau R4
    private String jenisKendaraan;


    // Constructor TiketKendaraan
    public TiketKendaraan(String kodeTiket, String namaTiket, double harga,
                          int jumlah, String jenisKendaraan) {

        // Memanggil constructor dari class Tiket
        // Data kode, nama, harga dan jumlah berasal dari class induk
        super(kodeTiket, namaTiket, harga, jumlah);

        // Menyimpan jenis kendaraan
        this.jenisKendaraan = jenisKendaraan;
    }


    // Constructor kosong
    public TiketKendaraan() {
    }


    // Setter untuk mengubah jenis kendaraan
    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }


    // Getter untuk mengambil jenis kendaraan
    public String getJenisKendaraan() {
        return jenisKendaraan;
    }


    // Mengisi abstract method dari class Tiket
    // Method ini dibuat khusus untuk menampilkan informasi kendaraan
    public void tampilkanInfo() {

        // Menampilkan informasi tiket kendaraan
        System.out.println("Tiket Kendaraan");
        System.out.println("Jenis Kendaraan : " + jenisKendaraan);
        System.out.println("Nama Tiket : " + getNamaTiket());
        System.out.println("Harga : Rp " + (int)getHarga());
        System.out.println("Jumlah : " + getJumlah());
    }
}