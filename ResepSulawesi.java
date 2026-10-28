package makanan;

// INHERITANCE
public class ResepSulawesi extends Resep {

    // ENCAPSULATION
    private String ciriKhas;

    public ResepSulawesi(String namaResep,
                         Masakan masakan,
                         String ciriKhas) {

        super(namaResep, masakan);
        setCiriKhas(ciriKhas);
    }

    // GETTER
    public String getCiriKhas() {
        return ciriKhas;
    }

    // SETTER + VALIDASI
    public void setCiriKhas(String ciriKhas) {
        if (ciriKhas != null && !ciriKhas.isEmpty()) {
            this.ciriKhas = ciriKhas;
        } else {
            System.out.println("Ciri khas tidak boleh kosong!");
        }
    }

    // OVERRIDING
    @Override
    public void tampilkanInfo() {

        System.out.println("\n=== RESEP SULAWESI ===");

        System.out.println(
                "Nama Resep : " + getNamaResep()
        );

        System.out.println(
                "Ciri Khas  : " + ciriKhas
        );

        System.out.println(
                "Masakan    : " + getMasakan().getNamaMasakan()
        );
    }
}
