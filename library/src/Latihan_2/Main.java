package Latihan_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Scanner scan = new Scanner(System.in);
    ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        Main anjay = new Main();
        anjay.menu();
    }

    public void menu(){

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Tambah data mahasiswa");
            System.out.println("2. Tampil data mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih (1-3): ");
            int jawaban = scan.nextInt();
            scan.nextLine();

            switch (jawaban) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scan.nextLine();
                    
                    String nim;
                    do {
                        System.out.print("Masukkan Nim Mahasiswa: ");
                        nim = scan.nextLine();

                        if(nim.length() != 15){
                            System.out.println("Nim harus 15 karakter");
                        }
                    } while (nim.length() != 15);

                    System.out.print("Masukkan Jurusan mahasiswa: ");
                    String jurusan = scan.nextLine();

                    Mahasiswa mahasiswa = new Mahasiswa(nama, nim, jurusan);
                    dataMahasiswa.add(mahasiswa);
                    
                    break;
                case 2:
                    System.out.println("Menu daftar mahasiswa\n");
                    if(dataMahasiswa.isEmpty()){
                        System.out.println("Data masih kosong");
                    }else{
                        for(Mahasiswa mhs : dataMahasiswa){
                            System.out.println(mhs.tampildataMahasiswa());
                            System.out.println(Mahasiswa.tampilUniversitas());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Terimakasih");
                    System.exit(0);
            
                default:
                    System.out.println("program tidak dikenali");
                    break;
            }
        }
    }
}