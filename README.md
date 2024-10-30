# KEUANGAN PRIBADI

/**
* Kelas KeuanganPribadi digunakan untuk menyimpan dan mengelola informasi keuangan pribadi,
* termasuk pemasukan dan pengeluaran.
  */
  public class KeuanganPribadi {

  // Atribut untuk menyimpan total pemasukan dan pengeluaran
  private double pemasukan; // Total pemasukan
  private double pengeluaran; // Total pengeluaran

  /**
    * Konstruktor default untuk kelas KeuanganPribadi.
    * Menginisialisasi pemasukan dan pengeluaran dengan nilai 0.
      */
      public KeuanganPribadi() {
      this.pemasukan = 0.0;
      this.pengeluaran = 0.0;
      }

  /**
    * Metode untuk menambahkan pemasukan.
    *
    * @param jumlah Jumlah pemasukan yang akan ditambahkan.
    *               Harus lebih besar dari 0.
  */
  public void tambahPemasukan(double jumlah) {
  if (jumlah > 0) {
  this.pemasukan += jumlah; // Menambahkan jumlah ke pemasukan
  } else {
  System.out.println("Jumlah pemasukan harus lebih besar dari 0.");
  }
  }

  /**
    * Metode untuk menambahkan pengeluaran.
    *
    * @param jumlah Jumlah pengeluaran yang akan ditambahkan.
    *               Harus lebih besar dari 0.
  */
  public void tambahPengeluaran(double jumlah) {
  if (jumlah > 0) {
  this.pengeluaran += jumlah; // Menambahkan jumlah ke pengeluaran
  } else {
  System.out.println("Jumlah pengeluaran harus lebih besar dari 0.");
  }
  }

  /**
    * Metode untuk menghitung sisa saldo.
    *
    * @return Sisa saldo setelah dikurangi pengeluaran dari pemasukan.
      */
      public double hitungSaldo() {
      return this.pemasukan - this.pengeluaran; // Menghitung saldo
      }

  /**
    * Metode untuk mendapatkan total pemasukan.
    *
    * @return Total pemasukan saat ini.
      */
      public double getTotalPemasukan() {
      return this.pemasukan; // Mengembalikan total pemasukan
      }

  /**
    * Metode untuk mendapatkan total pengeluaran.
    *
    * @return Total pengeluaran saat ini.
      */
      public double getTotalPengeluaran() {
      return this.pengeluaran; // Mengembalikan total pengeluaran
      }

  /**
    * Metode untuk menampilkan ringkasan keuangan pribadi.
      */
      public void tampilkanRingkasan() {
      System.out.println("=== Ringkasan Keuangan Pribadi ===");
      System.out.println("Total Pemasukan: " + this.getTotalPemasukan());
      System.out.println("Total Pengeluaran: " + this.getTotalPengeluaran());
      System.out.println("Sisa Saldo: " + this.hitungSaldo());
      }

  // Metode lain dan implementasi yang diperlukan...
  }
