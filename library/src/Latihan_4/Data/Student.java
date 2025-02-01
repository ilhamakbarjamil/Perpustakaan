package Latihan_4.Data;

import java.util.ArrayList;
import Latihan_3.Book;

public class Student extends User {

    ArrayList<Book> buku_terpinjam = new ArrayList<>();

    private String nama, nim, fakultas, prodi;

    public Student(String nama, String nim, String fakultas, String prodi) {
        this.nama = nama;
        this.nim = nim;
        this.fakultas = fakultas;
        this.prodi = prodi;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getFakultas() {
        return fakultas;
    }

    public String getProdi() {
        return prodi;
    }

    public void displayInfo() {
        System.out.println("Informasi Mahasiswa");
        System.out.println("===================");
        System.out.println("Nama: " + getNama());
        System.out.println("Nim: " + getNim());
        System.out.println("Fakultas: " + getFakultas());
        System.out.println("Prodi: " + getProdi());
    }

    @Override
    public void menu() {
        while (true) {
            System.out.println("Menu Student");
            System.out.println("======================");
            System.out.println("1. Tampilkan Informasi Mahasiswa");
            System.out.println("2. Tampilkan Buku Terpinjam");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih(1-5): ");
            int jawab = scan.nextInt();
            scan.nextLine();

            switch (jawab) {
                case 1:
                    displayInfo();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:

                    return;
                default:
                    break;
            }
        }
    }

    public void showBorrowedBook(){
        System.out.println("Buku yang anda Pinjam");
        System.out.println("=====================");
        if(buku_terpinjam.isEmpty()){
            System.out.println("Daftar Buku Kosong");
        }else{
            for(Book buku : buku_terpinjam){
                System.out.println("BookId: "+buku.getBookId());
                System.out.println("Judul: "+buku.getJudul());
                System.out.println("Penulis: "+buku.getPenulis());
                System.out.println("Kategori: "+buku.getKategori());
                System.out.println("Jumlah: "+buku.getStock());
                System.out.println("Durasi: "+buku.getDurasi()+" hari");
                System.out.println("\n");
            }
        }
    }

    public void choiceBook(){

    }

    public void returnBook(){
        
    }

    public void logout(){
        System.out.println("Berhasil keluar, '"+getNama()+"'");
        return;
    }


}
