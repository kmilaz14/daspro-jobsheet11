import java.util.Scanner;

public class PenjualanCafe {

    static int[][] penjualan = {
        {20, 20, 25, 20, 10, 60, 10}, 
        {30, 80, 40, 10, 15, 20, 25}, 
        {5, 9, 20, 25, 10, 5, 45},   
        {50, 8, 17, 18, 10, 30, 6},   
        {15, 10, 16, 15, 10, 10, 55}  
    };

    static String[] menu = {"Kopi", "Teh", "Es Degan", "Roti Bakar", "Gorengan"};

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean program = true;

        while (program) {
            System.out.println("\n------ Menu ------");
            System.out.println("1. Input Data Penjualan");
            System.out.println("2. Tampilkan Semua Data");
            System.out.println("3. Tampilkan Penjualan Tertinggi");
            System.out.println("4. Tampilkan Rata-rata Penjualan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    inputData(sc);
                    break;
                case 2:
                    tampilkanSemuaData();
                    break;
                case 3:
                    penjualanTertinggi();
                    break;
                case 4:
                    rataRataPenjualan();
                    break;
                case 5:
                    program = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void inputData(Scanner sc) {
        System.out.println("\nPilih menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }
        System.out.print("Pilih menu (1-5): ");
        int pilihanMenu = sc.nextInt() - 1;

        if (pilihanMenu < 0 || pilihanMenu >= menu.length) {
            System.out.println("Menu tidak valid!");
            return;
        }

        System.out.print("Masukkan hari (1-7): ");
        int hari = sc.nextInt() - 1;

        if (hari < 0 || hari >= 7) {
            System.out.println("Hari tidak valid!");
            return;
        }

        System.out.print("Masukkan jumlah penjualan: ");
        int jmlhBaru = sc.nextInt();
        penjualan[pilihanMenu][hari] = jmlhBaru;

        System.out.println("Data berhasil diperbarui!");
    }

    static void tampilkanSemuaData() {
        System.out.println("\nData Penjualan:");
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i] + ": ");
            for (int j = 0; j < penjualan[i].length; j++) {
                System.out.print(penjualan[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void penjualanTertinggi() {
        int maksimalPenjualan = 0;
        String menuTertinggi = "";

        for (int i = 0; i < menu.length; i++) {
            int totalPenjualan = 0;
            for (int j = 0; j < penjualan[i].length; j++) {
                totalPenjualan += penjualan[i][j];
            }
            if (totalPenjualan > maksimalPenjualan) {
                maksimalPenjualan = totalPenjualan;
                menuTertinggi = menu[i];
            }
        }

        System.out.println("\nMenu dengan penjualan tertinggi: " + menuTertinggi + " dengan " + maksimalPenjualan + " penjualan.");
    }

    static void rataRataPenjualan() {
        System.out.println("\nRata-rata Penjualan:");
        for (int i = 0; i < menu.length; i++) {
            int totalPenjualan = 0;
            for (int j = 0; j < penjualan[i].length; j++) {
                totalPenjualan += penjualan[i][j];
            }
            double rataRata = (double) totalPenjualan / penjualan[i].length;
            System.out.println(menu[i] + ": " + rataRata);
        }
    }
}