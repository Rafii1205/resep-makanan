package makanan;

// INHERITANCE
public class MasakanBakar extends Masakan
        implements BisaDimasak {

    // ENCAPSULATION
    private String saus; // kecap / pedas / dabu-dabu

    public MasakanBakar(String namaMasakan,
                        int porsiDefault,
                        String saus) {

        super(namaMasakan, porsiDefault);
        setSaus(saus);
    }

    // GETTER
    public String getSaus() {
        return saus;
    }

    // SETTER + VALIDASI
    public void setSaus(String saus) {
        if (saus != null && !saus.isEmpty()) {
            this.saus = saus;
        } else {
            System.out.println("Saus tidak boleh kosong!");
        }
    }

    // OVERRIDING: masakan bakar butuh waktu sedang
    @Override
    public int estimasiWaktu(int porsi) {

        if (porsi <= 0) {
            return 0;
        }

        return 25 + (porsi * 8);
    }

    // OVERRIDING
    @Override
    public void tampilkanInfo() {

        System.out.println("\n=== MASAKAN BAKAR ===");

        System.out.println(
                "Nama          : " + getNamaMasakan()
        );

        System.out.println(
                "Saus          : " + saus
        );

        System.out.println(
                "Porsi Standar : " + getPorsiDefault() + " porsi"
        );
    }

    // OVERRIDING METHOD INTERFACE
    @Override
    public void prosesMasak(int porsi) {

        if (porsi <= 0) {
            System.out.println(
                    "Jumlah porsi harus lebih dari 0!"
            );
            return;
        }

        System.out.println(
                "\n>> Memasak " + getNamaMasakan() +
                        " (saus " + saus + ") untuk " +
                        porsi + " porsi..."
        );

        System.out.println(
                "[1/4] Menyiapkan bahan dan tusukan."
        );

        System.out.println(
                "[2/4] Menyiapkan bara api / panggangan."
        );

        System.out.println(
                "[3/4] Membakar sambil diolesi saus, " +
                        estimasiWaktu(porsi) + " menit."
        );

        System.out.println(
                "[4/4] " + getNamaMasakan() +
                        " siap disajikan!"
        );
    }
}
