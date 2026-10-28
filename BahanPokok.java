package makanan;

// INHERITANCE
public class BahanPokok extends BahanMakanan {

    // ENCAPSULATION
    private int lamaSimpan; // dalam hari

    public BahanPokok(String nama,
                      double hargaSatuan,
                      String satuan,
                      int lamaSimpan) {

        super(nama, hargaSatuan, satuan);
        setLamaSimpan(lamaSimpan);
    }

    // GETTER
    public int getLamaSimpan() {
        return lamaSimpan;
    }

    // SETTER + VALIDASI
    public void setLamaSimpan(int lamaSimpan) {
        if (lamaSimpan > 0) {
            this.lamaSimpan = lamaSimpan;
        } else {
            System.out.println("Lama simpan harus lebih dari 0 hari!");
        }
    }

    // OVERRIDING
    @Override
    public void tampilkanInfo() {

        System.out.println("\n=== BAHAN POKOK ===");

        System.out.println("Nama        : " + getNama());

        System.out.print("Harga       : ");
        tampilkanHarga();

        System.out.println(
                "Lama Simpan : " + lamaSimpan + " hari"
        );
    }
}
