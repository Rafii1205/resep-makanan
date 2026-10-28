package makanan;

// INHERITANCE
public class MasakanGorengan extends Masakan
        implements BisaDimasak {

    // ENCAPSULATION
    private String bumbuUtama; // kunyit / kecap / bawang

    public MasakanGorengan(String namaMasakan,
                           int porsiDefault,
                           String bumbuUtama) {

        super(namaMasakan, porsiDefault);
        setBumbuUtama(bumbuUtama);
    }

    // GETTER
    public String getBumbuUtama() {
        return bumbuUtama;
    }

    // SETTER + VALIDASI
    public void setBumbuUtama(String bumbuUtama) {
        if (bumbuUtama != null && !bumbuUtama.isEmpty()) {
            this.bumbuUtama = bumbuUtama;
        } else {
            System.out.println("Bumbu utama tidak boleh kosong!");
        }
    }

    // OVERRIDING: gorengan paling cepat matang
    @Override
    public int estimasiWaktu(int porsi) {

        if (porsi <= 0) {
            return 0;
        }

        return 15 + (porsi * 5);
    }

    // OVERRIDING
    @Override
    public void tampilkanInfo() {

        System.out.println("\n=== MASAKAN GORENGAN ===");

        System.out.println(
                "Nama          : " + getNamaMasakan()
        );

        System.out.println(
                "Bumbu Utama   : " + bumbuUtama
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
                        " (bumbu " + bumbuUtama + ") untuk " +
                        porsi + " porsi..."
        );

        System.out.println(
                "[1/4] Menyiapkan bahan dan bumbu."
        );

        System.out.println(
                "[2/4] Memanaskan minyak di wajan."
        );

        System.out.println(
                "[3/4] Menggoreng hingga kecokelatan, sekitar " +
                        estimasiWaktu(porsi) + " menit."
        );

        System.out.println(
                "[4/4] " + getNamaMasakan() +
                        " siap disajikan!"
        );
    }
}
