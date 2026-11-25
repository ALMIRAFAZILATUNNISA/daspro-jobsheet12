public class RekapLaundry02 {

    static String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
    static int[] harga = {6000, 8000, 5000, 12000};
    static String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};

    // Fungsi untuk menginputkan data berat cucian (diisi sesuai tabel)
    static int[][] inputData() {
        int[][] data = {
            {12, 15, 10, 18, 20, 25},   // Cuci Kering
            {20, 18, 22, 15, 30, 35},   // Cuci Setrika
            {8, 5, 10, 7, 6, 12},       // Setrika Saja
            {3, 6, 2, 5, 8, 10}         // Express
        };
        return data;
    }

    // Fungsi untuk menampilkan seluruh data dalam bentuk tabel
    static void tampilTabel(int[][] data) {
        System.out.printf("%-14s%10s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf("%8s", h);
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-14s%10d", layanan[i], harga[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%8d", data[i][j]);
            }
            System.out.println();
        }
    }

    // Fungsi total berat cucian satu layanan selama 6 hari
    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int berat : data[idxLayanan]) {
            total += berat;
        }
        return total;
    }

    // Fungsi menampilkan layanan dengan total cucian tertinggi
    static void tampilLayananTertinggi(int[][] data) {
        int idxMax = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idxMax)) {
                idxMax = i;
            }
        }
        System.out.println("Layanan dengan cucian tertinggi: " + layanan[idxMax]
                + " (" + totalPerLayanan(data, idxMax) + " kg)");
    }

    // Fungsi yang mengembalikan indeks hari dengan total cucian terbesar
    static int hariTersibuk(int[][] data) {
        int idxMax = 0;
        int totalMax = -1;
        for (int j = 0; j < data[0].length; j++) {
            int total = 0;
            for (int i = 0; i < data.length; i++) {
                total += data[i][j];
            }
            if (total > totalMax) {
                totalMax = total;
                idxMax = j;
            }
        }
        return idxMax;
    }

    // Fungsi menghitung dan menampilkan pendapatan tiap layanan dan totalnya
    static void tampilPendapatan(int[][] data) {
        int totalSemua = 0;
        for (int i = 0; i < data.length; i++) {
            int pendapatan = totalPerLayanan(data, i) * harga[i];
            System.out.println(layanan[i] + ": Rp" + pendapatan);
            totalSemua += pendapatan;
        }
        System.out.println("Total pendapatan: Rp" + totalSemua);
    }

    public static void main(String[] args) {
        int[][] data = inputData();

        System.out.println();
        tampilTabel(data);

        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.println("Total " + layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        System.out.println();
        tampilLayananTertinggi(data);

        int idxHari = hariTersibuk(data);
        System.out.println("Hari tersibuk: " + hari[idxHari]);

        System.out.println();
        tampilPendapatan(data);
    }
}