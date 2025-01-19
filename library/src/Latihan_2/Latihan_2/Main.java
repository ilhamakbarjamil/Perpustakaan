package Latihan_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Mahasiswa> daftarMhs = new ArrayList<>();

    public static void main(String[] args) {
        Main.menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Tambah data Mahasiswa");
            System.out.println("2. Tampil data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan (1-3): ");
            int jawab = scan.nextInt();
            scan.nextLine();

            switch (jawab) {
                case 1:
                    while (true) {
                        System.out.print("Masukkan Nama Mahasiswa: ");
                        String nama = scan.nextLine();
                        System.out.print("Masukkan Nim Mahasiswa: ");
                        String nim = scan.nextLine();
                        System.out.print("Masukkan Jurusan Mahasiswa: ");
                        String jurusan = scan.nextLine();

                        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, jurusan);
                        daftarMhs.add(mahasiswa);
                        break;
                    }
                    break;

                case 2:
                    System.out.println("Data Mahasiswa");
                    
                    if(daftarMhs.isEmpty()){
                        System.out.println("data masih kosong");
                    }else{
                        for(Mahasiswa maha : daftarMhs){
                            System.out.println(maha.tampildataMahasiswa());
                        }
                        System.out.println(Mahasiswa.tampilUniversitas());
                    }
                    break;

                case 3:
                    System.out.println("Program keluar");
                    break;

                default:
                    System.out.println("program error");
                    break;
            }

        }
    }
}
