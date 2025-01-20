package Latihan_2.part_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    ArrayList<student> datamahasiswa = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void menu() {

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih (1-3): ");
            int jawab = scan.nextInt();
            scan.nextLine();

            switch (jawab) {
                case 1:
                    menuStudent();
                    break;

                case 2:
                    menuAdmin();
                    break;

                case 3:
                    System.out.println("Program keluar");
                    System.exit(0);

                default:
                    System.out.println("Program tidak tahu");
                    break;
            }
        }
    }

    public void menuAdmin() {

    }

    public void menuStudent() {

    }

    public void checknim() {

        while (true) {
            System.out.print("Masukkan Nim: ");
            String nim = scan.nextLine();
            for (student mahasiswa : datamahasiswa) {
                if (nim.equals(mahasiswa.getNim())) {
                    menuStudent();
                }
            }
        }
    }
}
