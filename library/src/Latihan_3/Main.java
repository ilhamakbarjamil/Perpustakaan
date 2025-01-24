package Latihan_3;

import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {      
        Admin admin = new Admin();
        Main.addTempBook(admin);
        Main.addTempStudent(admin);
        Main main = new Main();
        main.menu();
    }

    public static void addTempBook(User user){
        user.dataBuku.add(new Book("BK-12345678", "Santet", "Alexander", "story book", 10));
    }

    public static void addTempStudent(Admin admin){
        admin.dataMahasiswa.add(new Student("Ilham Akbar Jamil", "202310370311085", "Teknik", "Informatika"));
    }

    public void menu() {
        while (true) {
            System.out.println("---- Perpustakaan Menu ----");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Keluar");
            System.out.print("pilih (1-3): ");
            int pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    checkNim();
                    break;
                case 2:
                    checkAdmin();
                    break;
                case 3:
                    System.out.println("Terima kasih, Keluar");
                    System.exit(0);
                default:
                    System.out.println("pilih angka 1-3");
                    break;
            }
        }
    }

    private void checkNim() {
        while (true) {
            System.out.print("Masukkan Nim (99 back): ");
            String nim = scan.nextLine();
            boolean found = false;

            if (nim.equalsIgnoreCase("99")) {
                menu();
                break;
            }

            for (Student cek : Admin.dataMahasiswa) {
                if(nim.equalsIgnoreCase(cek.getNim())){
                    found = true;
                    System.out.println(cek.getNama()+", "+cek.getNim());
                    menuStudent(cek);
                }
            }

            if(!found){
                System.out.println("Nim tidak di temukan");
            }
        }
    }

    private void checkAdmin(){
        String username = "admin";
        String password = "admin123";

        while (true) {
            System.out.print("Masukkan Username: ");
            String userAdmin = scan.nextLine();

            if(userAdmin.equalsIgnoreCase(username)){
                System.out.print("Masukkan Password: ");
                String passAdmin = scan.nextLine();

                if(passAdmin.equalsIgnoreCase(password)){
                    menuAdmin();
                    break;
                }else{
                    System.out.println("password salah");
                }
            }
            else{
                System.out.println("username salah");
            }


        }
    }

    public void menuStudent(Student student) {
        while (true) {
            System.out.println("---- Student Menu ----");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Kembalikan buku");
            System.out.println("4. Logout");
            System.out.print("pilih (1-4): ");
            int jawab = scan.nextInt();
            scan.nextLine();

            switch (jawab) {
                case 1:
                    student.displayBookBorrowed();
                    break;
                case 2:
                    student.PinjamBuku();
                    break;
                case 3:
                    student.returnBook();
                    break;
                case 4:
                    student.logout();
                    menu();
                    break;
                default:
                    System.out.println("pilih (1-4)");
                    break;
            }
        }
    }

    public void menuAdmin() {
       Admin admin = new Admin();
        while (true) {
            System.out.println("---- Admin Menu ----");
            System.out.println("1. Tambah Student");
            System.out.println("2. Tambah buku");
            System.out.println("3. Display Registered Student");
            System.out.println("4. Display Buku Tersedia");
            System.out.println("5. Logout");
            System.out.print("pilih (1-5): ");
            int jawab = scan.nextInt();
            scan.nextLine();

            switch (jawab) {
                case 1:
                    admin.addStudent();
                    break;
                case 2:
                    admin.InputBook();
                    break;
                case 3:
                    admin.displayStudent();
                    break;
                case 4:
                    admin.displayBook();
                    break;
                case 5:
                    menu();
                    break;
            
                default:
                    System.out.println("pilih (1-5)");
                    break;
            }
        }
    }
}