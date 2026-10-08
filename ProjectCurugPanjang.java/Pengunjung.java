// Class Pengunjung digunakan untuk menyimpan data pelanggan
public class Pengunjung {

    private String idPengunjung;
    private String nama;
    private String jenisKelamin;

    // Constructor
    public Pengunjung(String idPengunjung, String nama, String jenisKelamin) {

        this.idPengunjung = idPengunjung;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
    }

    // Constructor kosong
    public Pengunjung() {
    }

    // Setter
    public void setIdPengunjung(String idPengunjung) {
        this.idPengunjung = idPengunjung;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    // Getter
    public String getIdPengunjung() {
        return idPengunjung;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }
}