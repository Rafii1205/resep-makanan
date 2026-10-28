package makanan;

// INHERITANCE
public class BumbuDapur extends BahanMakanan {

    // ENCAPSULATION
    private String rasaDasar; // pedas / manis / gurih

    public BumbuDapur(String nama,
                      double hargaSatuan,
                      String satuan,
                      String rasaDasar) {

        super(nama, hargaSatuan, satuan);
        setRasaDasar(rasaDasar);
    }

    // GETTER
    public String getRasaDasar() {
        return rasaDasar;
    }

    // SETTER + VALIDASI
    public void setRasaDasar(String rasaDasar) {
        if (rasaDasar != null && !rasaDasar.isEmpty()) {
            this.rasaDasar = rasaDasar;
        } else {
            System.out.println("Rasa dasar tidak boleh kosong!");
        }
    }

    // OVERRIDING
    @Override
    public void tampilkanInfo() {

        System.out.println("\n=== BUMBU DAPUR ===");

        System.out.println("Nama       : " + getNama());

        System.out.print("Harga      : ");
        tampilkanHarga();

        System.out.println("Rasa Dasar : " + rasaDasar);
    }
}
