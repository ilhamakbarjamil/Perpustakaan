package Latihan_4.Main;

import java.util.Scanner;

public class LibrarySystem {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
    
    }

    public void menu(){
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
                
                break;
        
            default:
                break;
        }
    }
}
