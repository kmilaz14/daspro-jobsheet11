import java.util.Scanner;

public class Kubus13 {
    public static int hitungVolume(int s){
        return s*s*s;
    }
    public static int hitungLuasPermukaan(int s){
        return 6*(s*s);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan panjang sisi kubus: ");
        int s = input.nextInt();
        int vol = hitungVolume(s);
        int luasPermukaan= hitungLuasPermukaan(s);

        System.out.println("Volume kubus adalah: " + vol);
        System.out.println("Luas Permukaan kubus adalah: " + luasPermukaan);
    }
}
