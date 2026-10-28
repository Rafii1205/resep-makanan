package makanan;

import java.util.Scanner;

public class Main {

    // exception kecil: dilemparkan jika input berakhir (EOF)
    private static class AkhirInput extends RuntimeException {
    }

    // membaca integer dengan aman (input salah tidak membuat error)
    private static int bacaInt(Scanner input, int nilaiDefault) {

        if (input.hasNextInt()) {
            return input.nextInt();
        }

        // berakhirnya input
        if (!input.hasNext()) {
            throw new AkhirInput();
        }

        input.next();
        return nilaiDefault;
    }

    // membuang sisa baris setelah membaca integer
    private static void buangBaris(Scanner input) {
        if (input.hasNextLine()) {
            input.nextLine();
        }
    }

    // membaca teks yang tidak boleh kosong
    private static String bacaTeks(Scanner input, String pesan) {

        String teks = "";

        while (teks.isEmpty()) {

            System.out.print(pesan);

            if (!input.hasNextLine()) {
                throw new AkhirInput();
            }

            teks = input.nextLine().trim();

            if (teks.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
            }
        }

        return teks;
    }

    // menebak daerah resep dari class turunannya
    private static String getDaerah(Resep resep) {

        if (resep instanceof ResepJawa) {
            return "Jawa";
        } else if (resep instanceof ResepSumatera) {
            return "Sumatera";
        } else if (resep instanceof ResepSulawesi) {
            return "Sulawesi";
        }

        return "-";
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // CLASS & OBJECT: object bahan dibuat di dalam method main()
        BahanMakanan beras =
                new BahanPokok("Beras", 15000, "kg", 365);

        BahanMakanan minyakGoreng =
                new BahanPokok("Minyak Goreng", 18000, "liter", 180);

        BahanMakanan tepungTerigu =
                new BahanPokok("Tepung Terigu", 12000, "kg", 120);

        BahanMakanan dagingAyam =
                new BahanProtein("Daging Ayam", 38000, "kg", "hewani");

        BahanMakanan tahu =
                new BahanProtein("Tahu", 6000, "papan", "nabati");

        BahanMakanan ikanBandeng =
                new BahanProtein("Ikan Bandeng", 25000, "ekor", "hewani");

        BahanMakanan cabaiMerah =
                new BumbuDapur("Cabai Merah", 45000, "kg", "pedas");

        BahanMakanan bawangMerah =
                new BumbuDapur("Bawang Merah", 35000, "kg", "gurih");

        BahanMakanan santan =
                new BumbuDapur("Santan", 12000, "liter", "gurih");

        // INHERITANCE + POLIMORFISME DINAMIS:
        // satu array bertipe class induk berisi semua class turunan
        BahanMakanan[] daftarBahan = {
                beras, minyakGoreng, tepungTerigu,
                dagingAyam, tahu, ikanBandeng,
                cabaiMerah, bawangMerah, santan
        };

        // CLASS & OBJECT: object masakan dibuat di dalam method main()
        Masakan sotoAyam =
                new MasakanBerkuah("Soto Ayam", 4, "bening");

        Masakan rendangAyam =
                new MasakanBerkuah("Rendang Ayam", 6, "santan kental");

        Masakan cotoMakassar =
                new MasakanBerkuah("Coto Makassar", 4, "santan");

        Masakan nasiGoreng =
                new MasakanGorengan("Nasi Goreng", 2, "bawang");

        Masakan ayamGorengLengkuas =
                new MasakanGorengan("Ayam Goreng Lengkuas", 4, "kunyit");

        Masakan mieGoreng =
                new MasakanGorengan("Mie Goreng", 2, "kecap");

        Masakan satePadang =
                new MasakanBakar("Sate Padang", 4, "bumbu kacang pedas");

        Masakan ikanBakarRica =
                new MasakanBakar("Ikan Bakar Rica", 3, "rica pedas");

        Masakan ikanBakarManado =
                new MasakanBakar("Ikan Bakar Manado", 3, "dabu-dabu");

        Masakan[] daftarMasakan = {
                sotoAyam, rendangAyam, cotoMakassar,
                nasiGoreng, ayamGorengLengkuas, mieGoreng,
                satePadang, ikanBakarRica, ikanBakarManado
        };

        // HAS-A: resep memakai object masakan dan object bahan
        Resep sotoLamongan =
                new ResepJawa("Resep Soto Ayam Lamongan", sotoAyam,
                        "kuah bening dengan koya khas");

        sotoLamongan.tambahBahan(dagingAyam, 0.5);
        sotoLamongan.tambahBahan(bawangMerah, 0.05);
        sotoLamongan.tambahBahan(cabaiMerah, 0.02);
        sotoLamongan.tambahBahan(minyakGoreng, 0.1);

        sotoLamongan.tambahLangkah(
                "Rebus daging ayam hingga empuk, sisihkan kaldunya."
        );
        sotoLamongan.tambahLangkah(
                "Haluskan bawang merah dan cabai, lalu tumis hingga harum."
        );
        sotoLamongan.tambahLangkah(
                "Masukkan tumisan bumbu ke kaldu, lalu didihkan kembali."
        );
        sotoLamongan.tambahLangkah(
                "Sajikan soto dengan suwiran ayam dan taburan koya."
        );

        Resep nasiGorengJawa =
                new ResepJawa("Resep Nasi Goreng Jawa", nasiGoreng,
                        "manis gurih dengan kecap manis");

        nasiGorengJawa.tambahBahan(beras, 0.5);
        nasiGorengJawa.tambahBahan(tahu, 0.5);
        nasiGorengJawa.tambahBahan(bawangMerah, 0.04);
        nasiGorengJawa.tambahBahan(cabaiMerah, 0.02);
        nasiGorengJawa.tambahBahan(minyakGoreng, 0.05);

        nasiGorengJawa.tambahLangkah(
                "Masak beras menjadi nasi, lalu sisihkan."
        );
        nasiGorengJawa.tambahLangkah(
                "Potong tahu dan haluskan bumbu."
        );
        nasiGorengJawa.tambahLangkah(
                "Tumis bumbu, masukkan nasi dan tahu, aduk rata."
        );
        nasiGorengJawa.tambahLangkah(
                "Tambahkan kecap manis, masak sebentar lalu sajikan."
        );

        Resep ayamGorengResep =
                new ResepJawa("Resep Ayam Goreng Lengkuas",
                        ayamGorengLengkuas,
                        "gurih dengan serundeng lengkuas");

        ayamGorengResep.tambahBahan(dagingAyam, 1);
        ayamGorengResep.tambahBahan(minyakGoreng, 0.5);
        ayamGorengResep.tambahBahan(bawangMerah, 0.05);

        ayamGorengResep.tambahLangkah(
                "Lumuri ayam dengan bumbu halus, diamkan 30 menit."
        );
        ayamGorengResep.tambahLangkah(
                "Ungkep ayam hingga bumbu meresap."
        );
        ayamGorengResep.tambahLangkah(
                "Panaskan minyak, goreng ayam hingga kecokelatan."
        );
        ayamGorengResep.tambahLangkah(
                "Taburi serundeng lengkuas, lalu sajikan."
        );

        Resep rendangResep =
                new ResepSumatera("Resep Rendang Ayam Padang", rendangAyam,
                        "pedas kaya rempah dan santan");

        rendangResep.tambahBahan(dagingAyam, 1);
        rendangResep.tambahBahan(santan, 1);
        rendangResep.tambahBahan(cabaiMerah, 0.1);
        rendangResep.tambahBahan(bawangMerah, 0.1);

        rendangResep.tambahLangkah(
                "Haluskan cabai dan bawang, lalu tumis hingga harum."
        );
        rendangResep.tambahLangkah(
                "Masukkan santan, masak hingga mengeluarkan minyak."
        );
        rendangResep.tambahLangkah(
                "Masukkan ayam, masak dengan api kecil sambil diaduk."
        );
        rendangResep.tambahLangkah(
                "Masak hingga kuah mengental dan berwarna gelap."
        );

        Resep mieGorengAceh =
                new ResepSumatera("Resep Mie Goreng Aceh", mieGoreng,
                        "pedas dengan aroma rempah");

        mieGorengAceh.tambahBahan(tepungTerigu, 0.2);
        mieGorengAceh.tambahBahan(tahu, 0.5);
        mieGorengAceh.tambahBahan(minyakGoreng, 0.05);
        mieGorengAceh.tambahBahan(cabaiMerah, 0.03);
        mieGorengAceh.tambahBahan(bawangMerah, 0.03);

        mieGorengAceh.tambahLangkah(
                "Olahan tepung menjadi mie, rebus lalu tiriskan."
        );
        mieGorengAceh.tambahLangkah(
                "Haluskan bumbu, lalu tumis hingga harum."
        );
        mieGorengAceh.tambahLangkah(
                "Masukkan tahu dan mie, aduk rata."
        );
        mieGorengAceh.tambahLangkah(
                "Masak hingga bumbu meresap, lalu sajikan."
        );

        Resep satePadangResep =
                new ResepSumatera("Resep Sate Padang", satePadang,
                        "kuah kacang pedas yang kental");

        satePadangResep.tambahBahan(dagingAyam, 0.5);
        satePadangResep.tambahBahan(cabaiMerah, 0.05);
        satePadangResep.tambahBahan(bawangMerah, 0.03);

        satePadangResep.tambahLangkah(
                "Potong ayam kecil-kecil, lalu tusuk menjadi sate."
        );
        satePadangResep.tambahLangkah(
                "Rebus bumbu hingga mengental untuk kuah."
        );
        satePadangResep.tambahLangkah(
                "Bakar sate sambil dibalik hingga matang."
        );
        satePadangResep.tambahLangkah(
                "Sajikan sate dengan siraman kuah kental."
        );

        Resep cotoResep =
                new ResepSulawesi("Resep Coto Makassar", cotoMakassar,
                        "santan gurih dengan rempah sangrai");

        cotoResep.tambahBahan(dagingAyam, 0.5);
        cotoResep.tambahBahan(santan, 0.5);
        cotoResep.tambahBahan(bawangMerah, 0.05);
        cotoResep.tambahBahan(cabaiMerah, 0.03);

        cotoResep.tambahLangkah(
                "Sangrai rempah, lalu haluskan."
        );
        cotoResep.tambahLangkah(
                "Rebus ayam bersama rempah hingga empuk."
        );
        cotoResep.tambahLangkah(
                "Tambahkan santan, masak dengan api kecil."
        );
        cotoResep.tambahLangkah(
                "Sajikan coto dengan taburan bawang goreng."
        );

        Resep ikanBakarRicaResep =
                new ResepSulawesi("Resep Ikan Bakar Rica", ikanBakarRica,
                        "pedas segar khas Manado");

        ikanBakarRicaResep.tambahBahan(ikanBandeng, 2);
        ikanBakarRicaResep.tambahBahan(cabaiMerah, 0.05);
        ikanBakarRicaResep.tambahBahan(bawangMerah, 0.03);
        ikanBakarRicaResep.tambahBahan(minyakGoreng, 0.02);

        ikanBakarRicaResep.tambahLangkah(
                "Bersihkan ikan, lalu lumuri bumbu rica."
        );
        ikanBakarRicaResep.tambahLangkah(
                "Diamkan 15 menit agar bumbu meresap."
        );
        ikanBakarRicaResep.tambahLangkah(
                "Bakar ikan sambil diolesi sisa bumbu."
        );
        ikanBakarRicaResep.tambahLangkah(
                "Sajikan ikan bakar selagi panas."
        );

        Resep ikanBakarManadoResep =
                new ResepSulawesi("Resep Ikan Bakar Dabu-Dabu",
                        ikanBakarManado,
                        "sambal dabu-dabu segar");

        ikanBakarManadoResep.tambahBahan(ikanBandeng, 2);
        ikanBakarManadoResep.tambahBahan(cabaiMerah, 0.04);
        ikanBakarManadoResep.tambahBahan(bawangMerah, 0.02);
        ikanBakarManadoResep.tambahBahan(minyakGoreng, 0.02);

        ikanBakarManadoResep.tambahLangkah(
                "Bersihkan ikan, lalu lumuri sedikit minyak."
        );
        ikanBakarManadoResep.tambahLangkah(
                "Bakar ikan hingga matang sambil dibalik."
        );
        ikanBakarManadoResep.tambahLangkah(
                "Campur cabai dan bawang untuk sambal dabu-dabu."
        );
        ikanBakarManadoResep.tambahLangkah(
                "Siram sambal di atas ikan, lalu sajikan."
        );

        Resep[] daftarResep = {
                sotoLamongan, nasiGorengJawa, ayamGorengResep,
                rendangResep, mieGorengAceh, satePadangResep,
                cotoResep, ikanBakarRicaResep, ikanBakarManadoResep
        };

        int pilihan;

        try {

            do {

                System.out.println("\n================================");
                System.out.println(" APLIKASI DAPUR & RESEP MASAKAN ");
                System.out.println("================================");

                System.out.println("1. Lihat Daftar Bahan Makanan");
                System.out.println("2. Lihat Daftar Masakan");
                System.out.println("3. Lihat Daftar Resep per Daerah");
                System.out.println("4. Lihat Detail Resep");
                System.out.println("5. Simulasi Memasak");
                System.out.println("6. Keluar");

                System.out.print("Pilihan : ");
                pilihan = bacaInt(input, -1);
                buangBaris(input);

                switch (pilihan) {

                    // POLIMORFISME DINAMIS: method yang sama,
                    // dijalankan sesuai class turunan masing-masing
                    case 1:

                        for (BahanMakanan bahan : daftarBahan) {
                            bahan.tampilkanInfo();
                        }

                        break;

                    case 2:

                        for (Masakan masakan : daftarMasakan) {
                            masakan.tampilkanInfo();
                        }

                        break;

                    case 3: {

                        System.out.println("\nPilih Daerah:");
                        System.out.println("1. Jawa");
                        System.out.println("2. Sumatera");
                        System.out.println("3. Sulawesi");
                        System.out.print("Pilihan : ");

                        int pilihDaerah = bacaInt(input, -1);
                        buangBaris(input);

                        String daerah;

                        if (pilihDaerah == 1) {
                            daerah = "Jawa";
                        } else if (pilihDaerah == 2) {
                            daerah = "Sumatera";
                        } else if (pilihDaerah == 3) {
                            daerah = "Sulawesi";
                        } else {
                            System.out.println(
                                    "Daerah tidak tersedia."
                            );
                            break;
                        }

                        System.out.println(
                                "\nResep Daerah " + daerah + ":"
                        );

                        for (Resep resep : daftarResep) {

                            if (getDaerah(resep).equals(daerah)) {

                                System.out.println(
                                        "- " + resep.getNamaResep() +
                                                " -> " +
                                                resep.getMasakan()
                                                        .getNamaMasakan()
                                );
                            }
                        }

                        break;
                    }

                    case 4: {

                        System.out.println("\nDaftar Resep:");

                        for (int i = 0; i < daftarResep.length; i++) {

                            System.out.println(
                                    (i + 1) + ". " +
                                            daftarResep[i].getNamaResep() +
                                            " (" +
                                            getDaerah(daftarResep[i]) +
                                            ")"
                            );
                        }

                        System.out.print("Pilih Resep : ");
                        int indeksResep = bacaInt(input, -1);
                        buangBaris(input);

                        if (indeksResep < 1
                                || indeksResep > daftarResep.length) {
                            System.out.println(
                                    "Pilihan tidak tersedia."
                            );
                            break;
                        }

                        Resep resepPilihan =
                                daftarResep[indeksResep - 1];

                        // POLIMORFISME DINAMIS: tampilkanInfo()
                        // versi class turunan yang dijalankan
                        resepPilihan.tampilkanInfo();

                        resepPilihan.tampilkanBahan();
                        resepPilihan.tampilkanLangkah();

                        System.out.println(
                                "\nCatatan: resep ini cukup untuk " +
                                        resepPilihan.getMasakan()
                                                .getPorsiDefault() +
                                        " porsi standar."
                        );

                        int porsiResep = 0;

                        while (porsiResep <= 0) {

                            System.out.print(
                                    "\nBerapa porsi? "
                            );

                            porsiResep = bacaInt(input, 0);
                            buangBaris(input);

                            if (porsiResep <= 0) {
                                System.out.println(
                                        "Jumlah porsi harus lebih dari 0!"
                                );
                            }
                        }

                        // OVERLOADING: hitungTotalBiaya(int porsi)
                        double totalBiaya =
                                resepPilihan.hitungTotalBiaya(porsiResep);

                        System.out.println(
                                "\nTotal estimasi biaya untuk " +
                                        porsiResep + " porsi : " +
                                        BahanMakanan.formatRupiah(totalBiaya)
                        );

                        System.out.println(
                                "Estimasi waktu masak : " +
                                        resepPilihan.getMasakan()
                                                .estimasiWaktu(porsiResep) +
                                        " menit"
                        );

                        break;
                    }

                    case 5: {

                        System.out.println("\nDaftar Masakan:");

                        for (int i = 0; i < daftarMasakan.length; i++) {

                            System.out.println(
                                    (i + 1) + ". " +
                                            daftarMasakan[i]
                                                    .getNamaMasakan()
                            );
                        }

                        System.out.print("Pilih Masakan : ");
                        int indeksMasakan = bacaInt(input, -1);
                        buangBaris(input);

                        if (indeksMasakan < 1
                                || indeksMasakan > daftarMasakan.length) {
                            System.out.println(
                                    "Pilihan tidak tersedia."
                            );
                            break;
                        }

                        Masakan masakanPilihan =
                                daftarMasakan[indeksMasakan - 1];

                        int porsiMasak = 0;

                        while (porsiMasak <= 0) {

                            System.out.print("Jumlah Porsi : ");
                            porsiMasak = bacaInt(input, 0);
                            buangBaris(input);

                            if (porsiMasak <= 0) {
                                System.out.println(
                                        "Jumlah porsi harus lebih dari 0!"
                                );
                            }
                        }

                        // INTERFACE: object class turunan dipakai
                        // lewat reference interface
                        if (!(masakanPilihan instanceof BisaDimasak)) {
                            System.out.println(
                                    "Masakan ini tidak mendukung simulasi."
                            );
                            break;
                        }

                        BisaDimasak proses =
                                (BisaDimasak) masakanPilihan;

                        proses.prosesMasak(porsiMasak);

                        break;
                    }

                    case 6:

                        System.out.println(
                                "Terima kasih."
                        );

                        break;

                    default:

                        System.out.println(
                                "Pilihan tidak tersedia."
                        );
                }

            } while (pilihan != 6);

        } catch (AkhirInput e) {
            System.out.println("\nInput berakhir.");
        }

        input.close();
    }
}
