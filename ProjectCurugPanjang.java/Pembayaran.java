// Class ini digunakan untuk menyimpan data pembayaran
public class Pembayaran {

    // ID pembayaran
    private String idPembayaran;

    // Metode pembayaran, misalnya QRIS atau Cash
    private String metode;

    // Jumlah uang yang dibayarkan
    private double jumlah;


    // Constructor pembayaran
    public Pembayaran(String idPembayaran, String metode, double jumlah) {

        this.idPembayaran = idPembayaran;
        this.metode = metode;
        this.jumlah = jumlah;
    }


    // Constructor kosong
    public Pembayaran() {
    }


    // Setter metode pembayaran
    public void setMetode(String metode) {
        this.metode = metode;
    }


    // Setter jumlah pembayaran
    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }


    // Getter metode pembayaran
    public String getMetode() {
        return metode;
    }


    // Getter jumlah pembayaran
    public double getJumlah() {
        return jumlah;
    }


    // Getter ID pembayaran
    public String getIdPembayaran() {
        return idPembayaran;
    }


    // Method untuk melakukan pembayaran
    public void bayar(double jumlah) {

        // Jumlah pembayaran disimpan
        this.jumlah = jumlah;

        System.out.println("Pembayaran berhasil.");
    }
}
