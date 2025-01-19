package Latihan_1;
import java.util.Scanner;

public class Latihan_1 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("=== Library System ===");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Masukkan piihan (1-3): ");
        int jawab = scan.nextInt();
        scan.nextLine();

        if(jawab == 1){
            System.out.print("Masukkan Nim: ");
            String nim = scan.nextLine();

            if (nim.length() != 15) {
                do {
                    System.out.println("Nim harus 15 karakter panjangnya ");
                    System.out.print("Masukkan Nim: ");
                    nim = scan.nextLine();
                } while (nim.length() != 15 || nim.matches(".*[a-zA-Z].*"));
            } 
            System.out.println("Login berhasil sebagai student");
        }

        else if(jawab == 2){
            String username = "admin";
            String password = "admin123";
            int trying = 0;

            do {
                System.out.print("Masukkan Username: ");
                    String user = scan.nextLine();
    
                    if(user.equalsIgnoreCase(username)){
                        System.out.print("Masukkan Password: ");
                        String pass = scan.nextLine();
    
                        if(pass.equalsIgnoreCase(password)){
                            System.out.println("Berhail login sebagai admin");
                            break;
                        }else{
                            System.out.println("Password tidak ditemukan");
                        }
                    }else{
                        System.out.println("User tidak sesuai");
                    }

                    trying ++;
                    if(trying >= 5){
                        System.out.println("program keluar terlalu banyak percobaan");
                        break;
                    }

            } while (true);
        }

        else if(jawab == 3){
            System.out.println("Terimakasih");
            System.exit(0);
        }

        else{
            System.out.println("Program error");
            System.exit(0);
        }



        scan.close();
    }
}
