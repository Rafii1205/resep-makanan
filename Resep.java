package makanan;

// ABSTRACT CLASS
public abstract class Resep {

    // ENCAPSULATION
    private String namaResep;
    private Masakan masakan;            // HAS-A: masakan dari resep ini
    private BahanMakanan[] bahan;       // HAS-A: bahan yang dibutuhkan
    private double[] jumlahBahan;
    private String[] langkah;
    private int banyakBahan;
    private int banyakLangkah;

    // CONSTRUCTOR
    public Resep(String namaResep,
                 Masakan masakan) {

        setNamaResep(namaResep);
        setMasakan(masakan);

        this.bahan = new BahanMakanan[10];
        this.jumlahBahan = new double[10];
        this.langkah = new String[10];
    }

    // GETTER
    public String getNamaResep() {
        return namaResep;
    }

    public Masakan getMasakan() {
        return masakan;
    }

    // SETTER + VALIDASI
    public void setNamaResep(String namaResep) {
        if (namaResep != null && !namaResep.isEmpty()) {
            this.namaResep = namaResep;
        } else {
            System.out.println("Nama resep tidak boleh kosong!");
        }
    }

    public void setMasakan(Masakan masakan) {
        if (masakan != null) {
            this.masakan = masakan;
        } else {
            System.out.println("Masakan tidak boleh kosong!");
        }
    }

    // METHOD KONKRET: tambah bahan + jumlah kebutuhan
    public void tambahBahan(BahanMakanan bahan,
                            double jumlah) {

        if (banyakBahan >= this.bahan.length) {
            System.out.println("Daftar bahan resep sudah penuh!");
            return;
        }

        if (bahan == null || jumlah <= 0) {
            System.out.println("Bahan dan jumlah harus valid!");
            return;
        }

        this.bahan[banyakBahan] = bahan;
        this.jumlahBahan[banyakBahan] = jumlah;
        banyakBahan++;
    }

    // OVERLOADING: tambah bahan tanpa jumlah (dianggap 1)
    public void tambahBahan(BahanMakanan bahan) {
        tambahBahan(bahan, 1);
    }

    // METHOD KONKRET: tambah langkah memasak
    public void tambahLangkah(String langkah) {

        if (banyakLangkah >= this.langkah.length) {
            System.out.println("Daftar langkah resep sudah penuh!");
            return;
        }

        if (langkah != null && !langkah.isEmpty()) {
            this.langkah[banyakLangkah] = langkah;
            banyakLangkah++;
        }
    }

    // METHOD KONKRET: hitung biaya bahan satu resep penuh
    public double hitungTotalBiaya() {

        double total = 0;

        for (int i = 0; i < banyakBahan; i++) {
            total += bahan[i].hitungHarga(jumlahBahan[i]);
        }

        return total;
    }

    // OVERLOADING: hitung biaya untuk beberapa porsi
    // (resep ditulis untuk porsi standar masakannya)
    public double hitungTotalBiaya(int porsi) {

        if (porsi <= 0) {
            return hitungTotalBiaya();
        }

        double porsiStandar = masakan.getPorsiDefault();

        if (porsiStandar <= 0) {
            porsiStandar = 1;
        }

        return hitungTotalBiaya() * porsi / porsiStandar;
    }

    // METHOD KONKRET: tampilkan daftar bahan + subtotal
    public void tampilkanBahan() {

        System.out.println("\nBahan yang dibutuhkan:");

        if (banyakBahan == 0) {
            System.out.println("- (belum ada bahan)");
            return;
        }

        for (int i = 0; i < banyakBahan; i++) {

            double subtotal =
                    bahan[i].hitungHarga(jumlahBahan[i]);

            System.out.println(
                    "- " + bahan[i].getNama() +
                            " " + BahanMakanan.formatJumlah(jumlahBahan[i]) +
                            " " + bahan[i].getSatuan() +
                            " (" + BahanMakanan.formatRupiah(subtotal) + ")"
            );
        }
    }

    // METHOD KONKRET: tampilkan langkah memasak
    public void tampilkanLangkah() {

        System.out.println("\nLangkah memasak:");

        if (banyakLangkah == 0) {
            System.out.println("- (belum ada langkah)");
            return;
        }

        for (int i = 0; i < banyakLangkah; i++) {
            System.out.println((i + 1) + ". " + langkah[i]);
        }
    }

    // ABSTRACT METHOD
    public abstract void tampilkanInfo();
}
