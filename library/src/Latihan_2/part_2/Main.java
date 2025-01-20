package Latihan_2.part_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main utama = new Main();
        utama.menu();
    }

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
                    checknim();
                    break;

                case 2:
                    admin anjay = new admin();
                    String username = "";
                    String password = "";
                    do {
                        System.out.print("Masukkan username: ");
                        username = scan.nextLine();

                        if (anjay.username.equalsIgnoreCase(username)) {
                            System.out.print("Masukkan password: ");
                            password = scan.nextLine();

                            if (anjay.password.equalsIgnoreCase(password)) {
                                menuAdmin();
                                break;
                            } else {
                                System.out.println("Password tidak ditemukan");
                            }
                        } else {
                            System.out.println("username tidak ditemuakan");
                        }
                    } while (username != anjay.username || password != anjay.password);
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
        admin add = new admin();
        while (true) {
            System.out.println("=== Menu Admin ===");
            System.out.println("1. Tambah data mahasiswa");
            System.out.println("2. Tampilkan data mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih (1-3): ");
            int jawab = scan.nextInt();
            scan.nextLine();

            switch (jawab) {
                case 1:
                    add.addStudent();
                    break;
                case 2:
                    add.displayStudent();
                    break;
                case 3:
                    System.out.println("terimakasih");
                    menu();
                    break;

                default:
                    System.out.println("Program tidak dikenali");
                    break;
            }
        }
    }

    public void menuStudent() {

    }

    public void checknim() {

        while (true) {
            System.out.print("Masukkan Nim (99 to back): ");
            String nim = scan.nextLine();

            if (nim.equalsIgnoreCase("99")) {
                menu();
            }

            boolean found = false;
            for (student mahasiswa : admin.dataMahasiswa) {
                if (mahasiswa.getNim().equals(nim)) {
                    System.out.println("Nim ditemukan");
                    menuStudent();
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("nim tidak ditemukan");
            }
        }
    }
}
