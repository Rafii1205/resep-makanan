package makanan;

// INHERITANCE
public class MasakanBerkuah extends Masakan
        implements BisaDimasak {

    // ENCAPSULATION
    private String jenisKuah; // bening / santan / kental

    public MasakanBerkuah(String namaMasakan,
                          int porsiDefault,
                          String jenisKuah) {

        super(namaMasakan, porsiDefault);
        setJenisKuah(jenisKuah);
    }

    // GETTER
    public String getJenisKuah() {
        return jenisKuah;
    }

    // SETTER + VALIDASI
    public void setJenisKuah(String jenisKuah) {
        if (jenisKuah != null && !jenisKuah.isEmpty()) {
            this.jenisKuah = jenisKuah;
        } else {
            System.out.println("Jenis kuah tidak boleh kosong!");
        }
    }

    // OVERRIDING: masakan berkuah butuh perebusan paling lama
    @Override
    public int estimasiWaktu(int porsi) {

        if (porsi <= 0) {
            return 0;
        }

        return 40 + (porsi * 10);
    }

    // OVERRIDING
    @Override
    public void tampilkanInfo() {

        System.out.println("\n=== MASAKAN BERKUAH ===");

        System.out.println(
                "Nama          : " + getNamaMasakan()
        );

        System.out.println(
                "Jenis Kuah    : " + jenisKuah
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
                        " (kuah " + jenisKuah + ") untuk " +
                        porsi + " porsi..."
        );

        System.out.println(
                "[1/4] Menyiapkan bahan dan bumbu."
        );

        System.out.println(
                "[2/4] Merebus air dan bumbu hingga mendidih."
        );

        System.out.println(
                "[3/4] Memasukkan bahan, masak " +
                        estimasiWaktu(porsi) + " menit."
        );

        System.out.println(
                "[4/4] " + getNamaMasakan() +
                        " siap disajikan hangat!"
        );
    }
}
