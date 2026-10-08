// Class untuk menyimpan data petugas loket
public class Petugas {

    // ID petugas
    private String idPetugas;

    // Nama petugas
    private String nama;

    // Loket tempat petugas melayani
    private String loket;


    // Constructor untuk membuat object petugas
    public Petugas(String idPetugas, String nama, String loket) {

        this.idPetugas = idPetugas;
        this.nama = nama;
        this.loket = loket;
    }


    // Constructor kosong
    public Petugas() {
    }


    // Setter untuk nama petugas
    public void setNama(String nama) {
        this.nama = nama;
    }


    // Setter untuk loket
    public void setLoket(String loket) {
        this.loket = loket;
    }


    // Getter nama
    public String getNama() {
        return nama;
    }


    // Getter loket
    public String getLoket() {
        return loket;
    }


    // Getter ID petugas
    public String getIdPetugas() {
        return idPetugas;
    }
}
