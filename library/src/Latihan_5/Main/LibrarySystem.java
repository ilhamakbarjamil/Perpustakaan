package Latihan_5.Main;

import java.util.Scanner;

import Latihan_4.Book.HistoryBook;
import Latihan_4.Data.Admin;
import Latihan_4.Data.Student;
import Latihan_4.Data.User;
import Latihan_5.IllegalAdminAccess.IllegalAdminAccess;

public class LibrarySystem {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IllegalAdminAccess {
        LibrarySystem main = new LibrarySystem();
        main.addTempBook();
        main.addTempStudent();
        main.menu();
    }

    public void menu() throws IllegalAdminAccess {
        while (true) {
            try {
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
                        throw new IllegalAdminAccess("Invalid");
                }
            } catch (IllegalAdminAccess e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputNim() throws IllegalAdminAccess {
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

    public void addTempStudent() {
        Student student = new Student("Ilham Akbar Jamil", "202310370311085", "Teknik", "Informatika");
        Admin.data_mahasiswa.add(student);
    }

    public void addTempBook() {
        HistoryBook buku = new HistoryBook("77-12345678", "santet", "Alexander", "History Book", 10);
        User.data_buku.add(buku);
    }
}
