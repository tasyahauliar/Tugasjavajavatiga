import java.util.ArrayList;
import java.util.Scanner;

public class KeuanganPribadi {

    static ArrayList<Transaksi> transaksiList = new ArrayList<>();//mengganti nama variabel agar lebih mudah dipahami
    private static final String PEMASUKAN = "Pemasukan";
    private static final String PENGELUARAN = "Pengeluaran";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            tampilkanMenu();

            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (pilihan) {
                case 1:
                    tambahTransaksi(scanner);
                    break;
                case 2:
                    lihatRiwayatTransaksi();
                    break;
                case 3:
                    hitungSaldo();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void tampilkanMenu() {//Memisahkan kode yang menampilkan menu
        System.out.println("\nMenu Keuangan Pribadi:");
        System.out.println("1. Tambah Transaksi");
        System.out.println("2. Lihat Riwayat Transaksi");
        System.out.println("3. Hitung Saldo");
        System.out.println("4. Keluar");
    }

    static void tambahTransaksi(Scanner scanner) {
        System.out.println("\nTambah Transaksi:");
        String jenisTransaksi;

        while (true) {
            System.out.print("Jenis Transaksi (Pemasukan/Pengeluaran): ");
            jenisTransaksi = scanner.nextLine();
            if (jenisTransaksi.equalsIgnoreCase(PEMASUKAN) || jenisTransaksi.equalsIgnoreCase(PENGELUARAN)) {
                break;//Mengubah string seperti "Pemasukan" dan "Pengeluaran" menjadi konstanta agar lebih mudah saat diminta
            } else {
                System.out.println("Input tidak valid. Silakan masukkan 'Pemasukan' atau 'Pengeluaran'.");
            }
        }

        System.out.print("Keterangan: ");
        String keterangan = scanner.nextLine();

        System.out.print("Jumlah: ");
        double jumlah = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        Transaksi transaksi = new Transaksi(jenisTransaksi, keterangan, jumlah);
        transaksiList.add(transaksi);
        System.out.println("Transaksi berhasil ditambahkan.");
    }

    static void lihatRiwayatTransaksi() {
        System.out.println("\nRiwayat Transaksi:");
        if (transaksiList.isEmpty()) {
            System.out.println("Tidak ada riwayat transaksi.");
        } else {
            int index = 1;//Menggunakan for-each untuk iterasi yang lebih bersih dan efisien.
            for (Transaksi transaksi : transaksiList) {
                System.out.println(index++ + ". " + transaksi);
            }
        }
    }

    static void hitungSaldo() {
        if (transaksiList.isEmpty()) {
            System.out.println("\nTidak ada transaksi yang tercatat.");
            return;//Menggunakan return lebih awal jika tidak ada transaksi untuk mengurangi level indentasi dan meningkatkan keterbacaan
        }

        double saldo = 0;
        for (Transaksi transaksi : transaksiList) {
            if (transaksi.getJenisTransaksi().equalsIgnoreCase(PEMASUKAN)) {
                saldo += transaksi.getJumlah();
            } else if (transaksi.getJenisTransaksi().equalsIgnoreCase(PENGELUARAN)) {
                saldo -= transaksi.getJumlah();
            }
        }
        System.out.printf("\nSaldo Anda: %.2f\n", saldo);
    }
}

class Transaksi {
    private String jenisTransaksi;
    private String keterangan;
    private double jumlah;

    public Transaksi(String jenisTransaksi, String keterangan, double jumlah) {
        this.jenisTransaksi = jenisTransaksi;
        this.keterangan = keterangan;
        this.jumlah = jumlah;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public double getJumlah() {
        return jumlah;
    }

    @Override
    public String toString() {
        return "Jenis: " + jenisTransaksi + ", Keterangan: " + keterangan + ", Jumlah: " + jumlah;
    }
}
