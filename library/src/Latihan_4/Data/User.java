package Latihan_4.Data;

import java.util.ArrayList;
import java.util.Scanner;

import Latihan_4.Book.Book;
import Latihan_4.Util.iMenu;

public class User implements iMenu{

    ArrayList<Book> data_buku = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    

    public void displayBook(){
        System.out.println("Daftar Buku yang tersedia");
        System.out.println("==========================");
    }

    public void addBook(){

    }

    @Override
    public void menu() {
        
    }

    
}
