import java.util.ArrayList;

// Class Transaksi digunakan untuk menyimpan data transaksi
// Transaksi menggunakan interface CetakStruk
public class Transaksi implements CetakStruk {

    private String noTransaksi;
    private String tanggal;
    private String jam;
    private String lokasi;
    private double total;

    // Menyimpan semua tiket dalam satu transaksi
    private ArrayList<Tiket> daftarTiket;

    private Pengunjung pengunjung;
    private Petugas petugas;
    private Pembayaran pembayaran;

    // Constructor
    public Transaksi(String noTransaksi, String tanggal, String jam,
                     String lokasi, double total) {

        this.noTransaksi = noTransaksi;
        this.tanggal = tanggal;
        this.jam = jam;
        this.lokasi = lokasi;
        this.total = total;

        daftarTiket = new ArrayList<Tiket>();
    }

    // Constructor kosong
    public Transaksi() {
        daftarTiket = new ArrayList<Tiket>();
    }

    // Menambahkan tiket ke transaksi
    public void addTiket(Tiket tiket) {
        daftarTiket.add(tiket);
    }

    // Menghitung total harga semua tiket
    public double hitungTotal() {

        total = 0;

        for (int i = 0; i < daftarTiket.size(); i++) {

            total = total + daftarTiket.get(i).getSubtotal();
        }

        return total;
    }

    // Setter
    public void setPengunjung(Pengunjung pengunjung) {
        this.pengunjung = pengunjung;
    }

    public void setPetugas(Petugas petugas) {
        this.petugas = petugas;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    // Getter
    public String getNoTransaksi() {
        return noTransaksi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public String getLokasi() {
        return lokasi;
    }

    public double getTotal() {
        return total;
    }

    public Pengunjung getPengunjung() {
        return pengunjung;
    }

    public Petugas getPetugas() {
        return petugas;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public ArrayList<Tiket> getDaftarTiket() {
        return daftarTiket;
    }

    // Method dari interface CetakStruk
    public void cetakStruk() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          TIKET MASUK WISATA");
        System.out.println("             CURUG PANJANG");
        System.out.println("==========================================");

        System.out.println("No Transaksi : " + noTransaksi);
        System.out.println("Tanggal      : " + tanggal);
        System.out.println("Jam          : " + jam);
        System.out.println("Lokasi       : " + lokasi);

        System.out.println("------------------------------------------");

        if (pengunjung != null) {

            System.out.println("Nama         : " + pengunjung.getNama());
            System.out.println(
                "Jenis Kelamin: " + pengunjung.getJenisKelamin()
            );
        }

        if (petugas != null) {

            System.out.println(
                "Petugas      : " + petugas.getNama()
            );

            System.out.println(
                "Loket        : " + petugas.getLoket()
            );
        }

        System.out.println("------------------------------------------");

        // Menampilkan semua tiket
        for (int i = 0; i < daftarTiket.size(); i++) {

            Tiket tiket = daftarTiket.get(i);

            System.out.println(tiket.getNamaTiket());

            System.out.println(
                tiket.getJumlah()
                + " x Rp "
                + (int)tiket.getHarga()
                + " = Rp "
                + (int)tiket.getSubtotal()
            );

            // Mengecek apakah tiket merupakan TiketWisata
            if (tiket instanceof TiketWisata) {

                TiketWisata tw = (TiketWisata)tiket;

                System.out.println(
                    "Kategori     : " + tw.getKategori()
                );
            }

            // Mengecek apakah tiket merupakan TiketKendaraan
            if (tiket instanceof TiketKendaraan) {

                TiketKendaraan tk = (TiketKendaraan)tiket;

                System.out.println(
                    "Kendaraan    : " + tk.getJenisKendaraan()
                );
            }

            System.out.println();
        }

        System.out.println("------------------------------------------");

        System.out.println(
            "TOTAL        : Rp " + (int)hitungTotal()
        );

        if (pembayaran != null) {

            System.out.println(
                "Pembayaran   : " + pembayaran.getMetode()
            );

            System.out.println(
                "Bayar        : Rp "
                + (int)pembayaran.getJumlah()
            );
        }

        System.out.println("==========================================");
        System.out.println("       TERIMA KASIH SUDAH BERKUNJUNG");
        System.out.println("==========================================");
    }
}