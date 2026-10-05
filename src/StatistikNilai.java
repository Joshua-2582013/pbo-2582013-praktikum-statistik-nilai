import java.util.ArrayList;
import java.util.Scanner;

public class StatistikNilai {
    static final int SELESAI= -1; /* Memberi nama untuk angka -1, dan kalau -1 ditulis maka program selesai */
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int nilai;

        do {
            // daftar = nama variabel, isinya kumpulan nilai (tipe ArrayList)
            // .size() = method (perintah) milik daftar, hasilnya jumlah isi daftar saat ini
            // pakai size() karena jumlah isi daftar = nilai yang sudah tersimpan,
            // jadi nomor berikutnya = size() + 1 (tidak perlu variabel penghitung sendiri)
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) { /* dalam satu putaran, kalau begini... skip dan lanjutkan */
                continue;
            }
            if (nilai < 0 || nilai > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
                /* logika bahwa nilai gaboleh kurang dari 0 ATAU lebih dari 100 */
            }
            daftar.add(nilai);
        } while (nilai != SELESAI);

        if (daftar.isEmpty()) {
            System.out.println("Tidak ada nilai yang dimasukkan.");
            return;
        }

        System.out.println();
        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        int total = 0; /* buat celengan mulai dari 0 dgn nama total */
        for (int n : daftar) { /* artinya setiap n di dalam daftar */
            total = total + n; /* lakukan ini */
        }

        double rata = (double) total / daftar.size(); /* perhitungan rata caranya variabel total dibagi daftar size */
        /* dibuat double biar java ga membulatkan kebawah */

        /* 2f%n" artinya tampilkan desimal dengan 2 angka di belakang koma dan ganti baris */
        System.out.printf("Rata-rata       : %.2f%n", rata);

        // tertinggi dan terendah dimulai dari nilai pertama di daftar (get(0)), bukan 0.
        // Kalau terendah dimulai dari 0, tidak ada nilai yang lebih kecil dari 0,
        // jadi hasilnya salah terus. Nilai pertama pasti ada di daftar, jadi aman.
        int tertinggi = daftar.get(0);
        for (int i = 1; i < daftar.size(); i++) {
            if (daftar.get(i) > tertinggi) {
                tertinggi = daftar.get(i);
            }
        }
        System.out.println("Tertinggi       : " + tertinggi);

        int terendah = daftar.get(0);
        for (int i = 1; i < daftar.size(); i++) {
            if (daftar.get(i) < terendah) {
                terendah = daftar.get(i);
            }
        }
        System.out.println("Terendah        : " + terendah);

    }
}
