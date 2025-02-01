package Latihan_4.Main;

import java.util.Scanner;

import Latihan_4.Data.Admin;
import Latihan_4.Data.Student;

public class LibrarySystem {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        LibrarySystem main = new LibrarySystem();
        main.menu();
    }

    public void menu() {
        while (true) {
            System.out.println("Menu");
            System.out.println("===================");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Pilih(1-3): ");
            int jawab = scan.nextInt();
            scan.nextLine();

            switch (jawab) {
                case 1:
                    inputNim();
                    break;
                case 2:
                    check();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("invalid");
                    break;
            }
        }
    }

    public void inputNim() {
        while (true) {
            System.out.print("Masukkan Nim (99 back): ");
            String nim = scan.nextLine();

            if (nim.equalsIgnoreCase("99")) {
                menu();
                break;
            }

            for (Student student : Admin.data_mahasiswa) {
                if (student.getNim().equalsIgnoreCase(nim)) {
                    student.menu();
                    break;
                }
            }
        }
    }

    public void check() {
        Admin admin = new Admin();

        admin.isadmin();
    }
}
