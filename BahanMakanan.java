package makanan;

// ABSTRACT CLASS
public abstract class BahanMakanan {

    // ENCAPSULATION
    private String nama;
    private double hargaSatuan;
    private String satuan;

    // CONSTRUCTOR
    public BahanMakanan(String nama,
                        double hargaSatuan,
                        String satuan) {

        setNama(nama);
        setHargaSatuan(hargaSatuan);
        setSatuan(satuan);
    }

    // GETTER
    public String getNama() {
        return nama;
    }

    public double getHargaSatuan() {
        return hargaSatuan;
    }

    public String getSatuan() {
        return satuan;
    }

    // SETTER + VALIDASI
    public void setNama(String nama) {
        if (nama != null && !nama.isEmpty()) {
            this.nama = nama;
        } else {
            System.out.println("Nama bahan tidak boleh kosong!");
        }
    }

    public void setHargaSatuan(double hargaSatuan) {
        if (hargaSatuan > 0) {
            this.hargaSatuan = hargaSatuan;
        } else {
            System.out.println("Harga bahan harus lebih dari 0!");
            this.hargaSatuan = 0;
        }
    }

    public void setSatuan(String satuan) {
        if (satuan != null && !satuan.isEmpty()) {
            this.satuan = satuan;
        } else {
            this.satuan = "-";
        }
    }

    // OVERLOADING: hitung harga belanja bahan
    public double hitungHarga(double jumlah) {
        return hargaSatuan * jumlah;
    }

    // OVERLOADING: hitung harga belanja bahan + diskon
    public double hitungHarga(double jumlah,
                              double diskon) {

        double total = hargaSatuan * jumlah;

        return total - (total * diskon / 100);
    }

    // METHOD KONKRET
    public void tampilkanHarga() {

        System.out.println(
                formatRupiah(hargaSatuan) + " / " + satuan
        );
    }

    // STATIC: format harga agar rapi (Rp15.000)
    public static String formatRupiah(double nilai) {

        long bulat = Math.round(nilai);
        String angka = String.valueOf(bulat);
        String hasil = "";

        for (int i = 0; i < angka.length(); i++) {

            hasil += angka.charAt(i);

            int sisa = (angka.length() - 1 - i) % 3;

            if (sisa == 0 && i != angka.length() - 1) {
                hasil += ".";
            }
        }

        return "Rp" + hasil;
    }

    // STATIC: tampilkan jumlah tanpa desimal jika bulat (2.0 -> 2)
    public static String formatJumlah(double nilai) {

        if (nilai == (long) nilai) {
            return String.valueOf((long) nilai);
        }

        return String.valueOf(nilai);
    }

    // ABSTRACT METHOD
    public abstract void tampilkanInfo();
}
