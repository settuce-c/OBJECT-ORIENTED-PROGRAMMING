import java.lang.System;
import java.util.Scanner;

public class WarungKebin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Baca jumlah pembeli (N)
        // HINT: Perhatikan input setelah N ini
        int N = scanner.nextInt();
        scanner.nextLine();

        int i = 0;
        while (i < N) {
            // TODO: Baca data pembeli (nama, nomorMeja, saldo)
            // HINT: Perhatikan input setelah data pembeli ini
            String fullname = scanner.nextLine();
            int nomorMeja = scanner.nextInt();
            double saldo = scanner.nextDouble();
            scanner.nextLine();
            
            // TODO: Baca data order makanan (namaMakanan, jumlah, hargaSatuan)
            // HINT: Perhatikan input setelah data order makanan ini
            String namaMakanan = scanner.nextLine();
            int jumlah = scanner.nextInt();
            double hargaSatuan = scanner.nextDouble();
            scanner.nextLine();
            
            // TODO: Buat objek Pembeli dan OrderMakanan
            Pembeli beli = new Pembeli(fullname, nomorMeja, saldo);
            OrderMakanan orderan = new OrderMakanan(namaMakanan, jumlah, hargaSatuan);

            // TODO: Cek apakah pembeli bisa membayar sendiri pesanannya
            boolean bisaBayar;
            if (beli.cekBisaBayar(orderan) == true){
                double sisaSaldo = beli.getSaldo() - orderan.getTotalHarga();
                beli.setSaldo(sisaSaldo);
                bisaBayar = true;
            }
            else {
                bisaBayar = false;
            }
            
            // TODO: Jika bisa bayar, kurangi saldo pembeli
            
            // TODO: Cetak laporan pembeli i
            // HINT: Jika pembeli tidak bisa membayar, tidak perlu tampilkan saldo setelah bayar
            // HINT: Perhatikan lagi format output yang diharapkan

            System.out.printf("=== Pembeli %d ===\n", i+1);
            System.out.println("Nama: " + beli.getNamaPembeli() + " (Meja " + beli.getNomorMeja() + ")");
            System.out.println("Pesanan: " + orderan.getNamaMakanan() + " x " + orderan.getcountMakanan() + " @ " + orderan.getHargaSatuan());
            System.out.println("Total: " + orderan.getTotalHarga());
            if (bisaBayar == true){
                System.out.printf("Bisa Bayar: Bisa\n");
                System.out.println("Saldo setelah bayar: " + beli.getSaldo());
            }
            else {
                System.out.printf("Bisa Bayar: Gak Bisa\n");
            }
            System.out.printf("\n");
            
            i++;
        }

        scanner.close();
    }
}