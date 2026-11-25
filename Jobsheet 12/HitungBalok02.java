package Jobsheet12;

import java.util.Scanner;

public class HitungBalok02 {
static int hitungLuas(int pjg, int lb) {
        int Luas = pjg * lb;
        return Luas;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.println("=== Balok ke-" + i + "===");
            
        

        System.out.println("Masukkan panjang");
        int p = input.nextInt();

        System.out.println("Masukkan lebar");
        int l = input.nextInt();

        System.out.println("Masukkan tinggi");
        int t = input.nextInt();

        int L = hitungLuas(p, l);
        System.out.println("Luas Persegi Panjang adalah " + L);

        int vol = hitungVolume(t, p, l);
        System.out.println("Volume Balok adalah " + vol);
        System.out.println("Luas Permukaan Balok adalah " + hitungLuasPermukaanBalok(p, l, t));

        }
        input.close();
    }
}