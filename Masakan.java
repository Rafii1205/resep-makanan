package makanan;

// ABSTRACT CLASS
public abstract class Masakan {

    // ENCAPSULATION
    private String namaMasakan;
    private int porsiDefault;

    // CONSTRUCTOR
    public Masakan(String namaMasakan,
                   int porsiDefault) {

        setNamaMasakan(namaMasakan);
        setPorsiDefault(porsiDefault);
    }

    // GETTER
    public String getNamaMasakan() {
        return namaMasakan;
    }

    public int getPorsiDefault() {
        return porsiDefault;
    }

    // SETTER + VALIDASI
    public void setNamaMasakan(String namaMasakan) {
        if (namaMasakan != null && !namaMasakan.isEmpty()) {
            this.namaMasakan = namaMasakan;
        } else {
            System.out.println("Nama masakan tidak boleh kosong!");
        }
    }

    public void setPorsiDefault(int porsiDefault) {
        if (porsiDefault > 0) {
            this.porsiDefault = porsiDefault;
        } else {
            System.out.println("Porsi standar harus lebih dari 0!");
            this.porsiDefault = 1;
        }
    }

    // METHOD KONKRET: tampilkan estimasi waktu memasak
    public void tampilkanWaktu(int porsi) {

        System.out.println(
                "Estimasi waktu : " + estimasiWaktu(porsi) + " menit"
        );
    }

    // ABSTRACT METHOD: rumus waktu beda per jenis masakan
    public abstract int estimasiWaktu(int porsi);

    // ABSTRACT METHOD
    public abstract void tampilkanInfo();
}
