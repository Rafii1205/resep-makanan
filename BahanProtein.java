package makanan;

// INHERITANCE
public class BahanProtein extends BahanMakanan {

    // ENCAPSULATION
    private String sumber; // hewani / nabati

    public BahanProtein(String nama,
                        double hargaSatuan,
                        String satuan,
                        String sumber) {

        super(nama, hargaSatuan, satuan);
        setSumber(sumber);
    }

    // GETTER
    public String getSumber() {
        return sumber;
    }

    // SETTER + VALIDASI
    public void setSumber(String sumber) {

        if (sumber != null
                && (sumber.equalsIgnoreCase("hewani")
                || sumber.equalsIgnoreCase("nabati"))) {

            this.sumber = sumber;

        } else {
            System.out.println(
                    "Sumber protein harus hewani / nabati!"
            );
        }
    }

    // OVERRIDING
    @Override
    public void tampilkanInfo() {

        System.out.println("\n=== BAHAN PROTEIN ===");

        System.out.println("Nama   : " + getNama());

        System.out.print("Harga  : ");
        tampilkanHarga();

        System.out.println("Sumber : " + sumber);
    }
}
