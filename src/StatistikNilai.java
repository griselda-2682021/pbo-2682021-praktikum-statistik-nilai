import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatistikNilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();
        final int SELESAI = -1;
        int nilai;

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                break;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("Ditolak, harus 0-100");
                continue;
            }

            daftar.add(nilai);
        } while (true);

        System.out.println();

        if (daftar.isEmpty()) {
            System.out.println("Tidak ada nilai sah yang dimasukkan.");
            return;
        }

        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        double total = 0;
        for (int x : daftar) {
            total += x;
        }
        double rataRata = total / daftar.size();
        System.out.printf("Rata-rata       : %.2f\n", rataRata);

        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);

        for (int i = 1; i < daftar.size(); i++) {
            int val = daftar.get(i);
            if (val > tertinggi) {
                tertinggi = val;
            }
            if (val < terendah) {
                terendah = val;
            }
        }

        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);

        int diAtasRata2 = 0;
        for (int x : daftar) {
            if (x > rataRata) {
                diAtasRata2++;
            }
        }
        System.out.println("Di atas rata2   : " + diAtasRata2 + " orang");

        int[] jumlahGrade = new int[5];
        for (int x : daftar) {
            if (x >= 80) {
                jumlahGrade[0]++;
            } else if (x >= 70) {
                jumlahGrade[1]++;
            } else if (x >= 60) {
                jumlahGrade[2]++;
            } else if (x >= 50) {
                jumlahGrade[3]++;
            } else {
                jumlahGrade[4]++;
            }
        }

        System.out.print("Distribusi      : ");
        char[] gradeHuruf = {'A', 'B', 'C', 'D', 'E'};
        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(gradeHuruf[i] + "=" + jumlahGrade[i] + " ");
        }
        System.out.println();

        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);

        System.out.println("Terurut         : " + terurut);
        System.out.println("Urutan asli     : " + daftar);
    }
}

    }
}