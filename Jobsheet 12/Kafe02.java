package Jobsheet12;

import java.util.Scanner;

public class Kafe02 {
    public static void Menu(String namaPelanggan, boolean isMember) {
        System.out.println("Selamat Datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }
        public static int hitungTotalHarga02 (int pilihanMenu, int banyakItem){
            int [] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

            int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
            return hargaTotal;
        }

        public static int hitungDiskon(int total, String kodePromo, boolean isMember) {
            int diskon = 0;

            if (kodePromo.equals("DISKON50")) {
                diskon = total * 50 / 100;
            } else if (kodePromo.equals("DISKON30")) {
                diskon = total * 30 / 100;
            } else {
                System.out.println("Kode promo invalid");
            }

            if (isMember) {
                diskon += total * 10 / 100;
            }

            return diskon;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Menu("Andi", true);

        int totalBayar = 0;

        while (true){
        System.out.print("Masukkan nomor menu (1-6, 0 untuk selesai): ");
        int pilihanMenu = sc.nextInt();

        if (pilihanMenu == 0) {
            break;
        }
        
        if (pilihanMenu < 1 || pilihanMenu > 6) {
            System.out.println("Menu tidak tersedia");
            continue;
        }

        System.out.print("Masukkan jumlah item yang ingin dipesan: ");
        int banyakItem = sc.nextInt();
        totalBayar += hitungTotalHarga02(pilihanMenu, banyakItem);
    }
    System.out.print("Masukkan kode promo (ketik - jika tidak ada): ");
    String kodePromo = sc.next();

    int diskon = hitungDiskon(totalBayar, kodePromo, true);

    System.out.println("Total keseluruhan pesanan Anda  : Rp" + totalBayar);
    System.out.println("Diskon                          : Rp" + diskon);
    System.out.println("Total yang dibayar              : Rp" + (totalBayar - diskon));
    }
}