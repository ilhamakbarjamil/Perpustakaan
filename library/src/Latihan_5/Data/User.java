package Latihan_5.Data;

import java.util.ArrayList;
import java.util.Scanner;

import Latihan_4.Book.Book;
import Latihan_4.Util.iMenu;
import Latihan_5.IllegalAdminAccess.IllegalAdminAccess;

public class User extends Exception implements iMenu {

    public static ArrayList<Book> data_buku = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    

    public void displayBook(){
        System.out.println("Daftar Buku yang tersedia");
        System.out.println("==========================");
        for(Book buku : data_buku){
            System.out.println("BookId: "+buku.getBookId());
            System.out.println("Judul: "+buku.getJudul());
            System.out.println("Penulis: "+buku.getPenulis());
            System.out.println("Kategori: "+buku.getKategori());
            System.out.println("Stock: "+buku.getStock());
            System.out.println("-");
        }
    }

    public void addBook(){

    }

    @Override
    public void menu(){
        
    }

    
}
