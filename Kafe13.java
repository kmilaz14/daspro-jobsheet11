import java.util.Scanner;

public class Kafe13 {
    public static void Menu(String namaPelanggan, boolean isMember, String kodePromo){
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }
        if (kodePromo.equals("DISKON50")) {
            System.out.println("Berikan diskon 50%.");
        } else if (kodePromo.equals("DISKON30")) {
            System.out.println("Berikan diskon 30%.");
        } else {
            System.out.println("Kode invalid.");
        }

        System.out.println("=====MENU RESTO KAFE=====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappucino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("=========================");
        System.out.println("Silahkan pilih menu yang Anda inginkan");
    }
    public static int hitungTotalHarga13(int pilihanMenu, int banyakItem, boolean isMember, String kodePromo){
        int[]hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};
        int hargaTotal = hargaItems[pilihanMenu-1]*banyakItem;
        if (isMember==true){
            hargaTotal *= 0.9;
        }
        if (kodePromo.equals("DISKON50")) {
            hargaTotal *= 0.5;
        } else if (kodePromo.equals("DISKON30")) {
            hargaTotal *= 0.7;
        }
        return hargaTotal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String kodePromo = "DISKON30";
        boolean isMember = true;
        Menu("Andi", isMember, kodePromo);

        int totalKeseluruhan = 0;
        String orderan;
        do {
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan: ");
            int pilihanMenu = sc.nextInt();
    
            while (pilihanMenu<1 || pilihanMenu>6) {
                System.out.println("Pilihan menu tidak valid. Silahkan maasukkan nomor menu yang benar (1-6): ");
                pilihanMenu = sc.nextInt();
            }
            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();
    
            int totalHarga = hitungTotalHarga13(pilihanMenu, banyakItem, isMember, kodePromo);
            System.out.println("Total harga untuk pesanan Anda: Rp " + totalHarga);

            totalKeseluruhan += totalHarga;

            System.out.print("Apakah Anda ingin memesan lagi? (ya/tidak): ");
            orderan = sc.next();
        } while (orderan.equalsIgnoreCase("ya"));

        System.out.println("Total keseluruhan pesanan Anda: Rp " + totalKeseluruhan);
       
    }
}

