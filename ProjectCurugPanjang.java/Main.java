import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int pilihan;

        do {

            System.out.println();
            System.out.println("==================================");
            System.out.println("     SISTEM TIKET CURUG PANJANG");
            System.out.println("==================================");
            System.out.println("1. Tambah Transaksi");
            System.out.println("2. Cari Data Pelanggan");
            System.out.println("3. Keluar");
            System.out.println("==================================");
            System.out.print("Pilih menu : ");

            pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 1) {

                tambahTransaksi();

            } else if (pilihan == 2) {

                cariData();

            } else if (pilihan == 3) {

                System.out.println("Program selesai.");

            } else {

                System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 3);
    }

    // Method untuk menambahkan transaksi baru
    public static void tambahTransaksi() {

        System.out.println();
        System.out.println("==================================");
        System.out.println("       TAMBAH TRANSAKSI");
        System.out.println("==================================");

        // Input ID pelanggan
        System.out.print("ID Pelanggan : ");
        String id = input.nextLine();

        // Input nama pelanggan
        System.out.print("Nama         : ");
        String nama = input.nextLine();

        // Input jenis kelamin
        System.out.print("Jenis Kelamin (Pria/Wanita) : ");
        String jenisKelamin = input.nextLine();

        // Membuat object Pengunjung
        Pengunjung pengunjung =
            new Pengunjung(id, nama, jenisKelamin);

        // Membuat object Petugas
        Petugas petugas =
            new Petugas(
                "PT001",
                "NANDAR PRIHADI",
                "POS 1"
            );

        // Mengambil tanggal dan jam otomatis
        LocalDateTime sekarang = LocalDateTime.now();

        DateTimeFormatter formatTanggal =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter formatJam =
            DateTimeFormatter.ofPattern("HH:mm:ss");

        String tanggal =
            sekarang.format(formatTanggal);

        String jam =
            sekarang.format(formatJam);

        // Membuat object Transaksi
        Transaksi transaksi =
            new Transaksi(
                id,
                tanggal,
                jam,
                "Curug Panjang",
                0
            );

        transaksi.setPengunjung(pengunjung);
        transaksi.setPetugas(petugas);

        // ==============================
        // TIKET WNI
        // ==============================

        System.out.print("Jumlah tiket WNI : ");
        int wni = input.nextInt();

        if (wni > 0) {

            TiketWisata tiketWNI =
                new TiketWisata(
                    "TW001",
                    "Tiket Wisata WNI",
                    17000,
                    wni,
                    "WNI"
                );

            transaksi.addTiket(tiketWNI);
        }

        // ==============================
        // TIKET WNA
        // ==============================

        System.out.print("Jumlah tiket WNA : ");
        int wna = input.nextInt();

        if (wna > 0) {

            TiketWisata tiketWNA =
                new TiketWisata(
                    "TW002",
                    "Tiket Wisata WNA",
                    25000,
                    wna,
                    "WNA"
                );

            transaksi.addTiket(tiketWNA);
        }

        // ==============================
        // TIKET R2
        // ==============================

        System.out.print("Jumlah kendaraan R2 : ");
        int r2 = input.nextInt();

        if (r2 > 0) {

            TiketKendaraan tiketR2 =
                new TiketKendaraan(
                    "TK001",
                    "Tiket Kendaraan R2",
                    6000,
                    r2,
                    "R2"
                );

            transaksi.addTiket(tiketR2);
        }

        // ==============================
        // TIKET R4
        // ==============================

        System.out.print("Jumlah kendaraan R4 : ");
        int r4 = input.nextInt();

        if (r4 > 0) {

            TiketKendaraan tiketR4 =
                new TiketKendaraan(
                    "TK002",
                    "Tiket Kendaraan R4",
                    10000,
                    r4,
                    "R4"
                );

            transaksi.addTiket(tiketR4);
        }

        input.nextLine();

        // ==============================
        // PEMBAYARAN
        // ==============================

        System.out.print("Metode Pembayaran : ");
        String metode = input.nextLine();

        // Menghitung total transaksi
        double total = transaksi.hitungTotal();

        Pembayaran pembayaran =
            new Pembayaran(
                "PB001",
                metode,
                total
            );

        transaksi.setPembayaran(pembayaran);

        // Menampilkan struk
        transaksi.cetakStruk();

        // Menyimpan data pelanggan
        simpanDataPelanggan(
            pengunjung,
            tanggal,
            jam,
            wni,
            wna,
            r2,
            r4,
            total,
            metode
        );

        System.out.println();
        System.out.println("Data pelanggan berhasil disimpan.");
    }

    // Method untuk menyimpan data pelanggan
    public static void simpanDataPelanggan(
            Pengunjung pengunjung,
            String tanggal,
            String jam,
            int wni,
            int wna,
            int r2,
            int r4,
            double total,
            String metode) {

        try {

            // true digunakan agar data lama tetap ada
            FileWriter file =
                new FileWriter("data_pelanggan.txt", true);

            // Setiap pelanggan disimpan dalam satu baris
            file.write(
                pengunjung.getIdPengunjung()
                + " | "
                + pengunjung.getNama()
                + " | "
                + pengunjung.getJenisKelamin()
                + " | "
                + tanggal
                + " | "
                + jam
                + " | WNI="
                + wni
                + " | WNA="
                + wna
                + " | R2="
                + r2
                + " | R4="
                + r4
                + " | Total=Rp"
                + (int)total
                + " | Pembayaran="
                + metode
                + "\n"
            );

            file.close();

        } catch (IOException e) {

            System.out.println(
                "Data gagal disimpan."
            );
        }
    }

    // Method untuk mencari data pelanggan
    public static void cariData() {

        System.out.println();
        System.out.println("==================================");
        System.out.println("       CARI DATA PELANGGAN");
        System.out.println("==================================");

        System.out.print("Masukkan ID atau Nama : ");
        String cari = input.nextLine();

        try {

            File file =
                new File("data_pelanggan.txt");

            // Mengecek apakah file sudah ada
            if (!file.exists()) {

                System.out.println(
                    "Belum ada data pelanggan."
                );

                return;
            }

            Scanner baca =
                new Scanner(file);

            boolean ditemukan = false;

            // Membaca data satu per satu
            while (baca.hasNextLine()) {

                String data = baca.nextLine();

                // Pencarian tidak membedakan huruf besar kecil
                if (data.toLowerCase().contains(cari.toLowerCase())) {

                    System.out.println();
                    System.out.println("Data ditemukan:");
                    System.out.println(data);

                    ditemukan = true;
                }
            }

            baca.close();

            if (!ditemukan) {

                System.out.println(
                    "Data pelanggan tidak ditemukan."
                );
            }

        } catch (IOException e) {

            System.out.println(
                "Terjadi kesalahan saat membaca data."
            );
        }
    }
}