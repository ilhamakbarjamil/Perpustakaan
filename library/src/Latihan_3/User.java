package Latihan_3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class User {
    public ArrayList<Book> dataBuku = new ArrayList<>();
    public Scanner scan = new Scanner(System.in);

    public void displayBook() {
        System.out.println("\ndaftar buku\n");
        for(Book buku : dataBuku){
            System.out.println("BookId:: "+buku.getBookId());
            System.out.println("Judul: "+buku.getJudul());
            System.out.println("Penulis: "+buku.getPenulis());
            System.out.println("Kategori: "+buku.getKategori());
            System.out.println("Stock: "+buku.getStock());
            System.out.println("");
        }
    }

    public void addBook(String bookId, String judul, String penulis, String kategori, int stock) {
        System.out.println("Tambah Buku");
        System.out.print("Masukkan Book Id: ");
        bookId = scan.nextLine();
        System.out.print("Masukkan judul buku: ");
        judul = scan.nextLine();
        System.out.print("Masukkan penulis buku: ");
        penulis = scan.nextLine();
        System.out.print("Masukkan kategori buku: ");
        kategori = scan.nextLine();
        System.out.print("Masukkan stock Buku: ");
        stock = scan.nextInt();
        scan.nextLine();

        if(kategori.equalsIgnoreCase("history book")){
            HistoryBook history = new HistoryBook(bookId, judul, penulis, "History Book", stock);
            dataBuku.add(history);
        }else if(kategori.equalsIgnoreCase("story book")){
            StoryBook story = new StoryBook(bookId, judul, penulis, "Story Book", stock);
            dataBuku.add(story);
        }else if(kategori.equalsIgnoreCase("text book")){
            TextBook text = new TextBook(bookId, judul, penulis, "Text Book", stock);
            dataBuku.add(text);
        }
    }

}

class Student extends User {
    private String nama, nim, fakultas, prodi;
    private ArrayList<Book> bukuYangDipinjam = new ArrayList<>();

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
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Fakultas: " + getFakultas());
        System.out.println("Prodi: " + getProdi());
    }

    public void displayBookBorrowed() {
        System.out.println("Buku yang dipinjam: ");
        if (bukuYangDipinjam.isEmpty()) {
            System.out.println("Tidak ada buku yang dipinjam");
        } else {
            System.out.println("Buku yang dipinjam: ");
            for (Book buku : bukuYangDipinjam) {
                System.out.println("Book Id: " + buku.getBookId());
                System.out.println("Judul: " + buku.getJudul());
                System.out.println("Penulis: " + buku.getPenulis());
                System.out.println("Kategori: " + buku.getKategori());
                System.out.println("Stock: " + buku.getStock());
                System.out.println("Durasi: " + buku.getDurasi());
            }
        }
    }

    public void PinjamBuku() {
        System.out.print("Masukkan judul buku yang ingin dipinjam: ");
        String judul = scan.nextLine();
        boolean found = false;

        for (Book buku : bukuYangDipinjam) {
            if (judul.equalsIgnoreCase(buku.getJudul())) {
                System.out.println("buku di temukan\n" + buku.getJudul() + ", stock buku: " + buku.getStock());
                found = true;
                if (buku.getStock() > 0) {
                    buku.setStock(buku.getStock() - 1);
                    System.out.print("durasi peminjaman buku (max 14 hari): ");
                    int durasi = scan.nextInt();
                    scan.nextLine();

                    if (durasi > 14 || durasi < 0) {
                        System.out.println("anda melebihi batas");
                    } else {
                        buku.setStock(buku.getStock() + durasi);
                        bukuYangDipinjam.add(buku);
                        System.out.println("buku berhasil dipinjam " + buku.getJudul());
                    }

                } else {
                    System.out.println("Buku lagi kosong");
                }
            }
        }
        if (!found) {
            System.out.println("Buku tidak ditemukan");
        }
    }

    public void returnBook() {
        System.out.print("Masukkan judul buku yang di kembalikan: ");
        String judul = scan.nextLine();
        boolean found = false;

        for (Book buku : bukuYangDipinjam) {
            if (judul.contains(buku.getJudul())) {
                found = true;
                buku.setStock(buku.getStock() + 1);
                bukuYangDipinjam.remove(buku.getJudul());
                System.out.println("buku '" + buku.getJudul() + "', berhasil di kembalikan");
            }
        }

        if (!found) {
            System.out.println("Buku " + judul + ", tidak di temukan ");
        }
    }

    public void logout() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Fakultas: " + getFakultas());
        System.out.println("Prodi: " + getProdi());
        System.out.println("berhasil logout");
    }
}

class Admin extends User {
    String username_cek = "admin";
    String password_cek = "admin123";
    Scanner scan = new Scanner(System.in);
    static ArrayList<Student> dataMahasiswa = new ArrayList<>();

    public void addStudent(String nama, String nim, String fakultas, String prodi) {
        System.out.print("Masukkan Nama Mahasiswa: ");
        nama = scan.nextLine();
        System.out.print("Masukkan Nim Mahasiswa: ");
        nim = scan.nextLine();
        System.out.print("Masukkan Fakultas Mahasiswa: ");
        fakultas = scan.nextLine();
        System.out.print("Masukkan Prodi Mahasiswa: ");
        prodi = scan.nextLine();

        Student student = new Student(nama, nim, fakultas, prodi);
        dataMahasiswa.add(student);
    }

    public void addStudent() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Nim Mahasiswa: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Fakultas Mahasiswa: ");
        String fakultas = scan.nextLine();
        System.out.print("Masukkan Prodi Mahasiswa: ");
        String prodi = scan.nextLine();

        Student student = new Student(nama, nim, fakultas, prodi);
        dataMahasiswa.add(student);
    }

    public void InputBook() {
        System.out.println("Tambah Buku");
        System.out.print("Masukkan Book Id: ");
        String bookId = generateId();
        System.out.println("Book Id: " + bookId);
        System.out.print("Masukkan judul buku: ");
        String judul = scan.nextLine();
        System.out.print("Masukkan penulis buku: ");
        String penulis = scan.nextLine();
        System.out.println("Pilih kategori buku:");
        System.out.println("1. History Book");
        System.out.println("2. Story Book"); 
        System.out.println("3. Text Book");
        System.out.print("Masukkan pilihan (1-3): ");
        String kategori = scan.nextLine();
        
        System.out.print("Masukkan stock Buku: ");
        int stock = Integer.parseInt(scan.nextLine());

        switch (kategori) {
            case "1":
                HistoryBook historyBook = new HistoryBook(bookId, judul, penulis, "History Book", stock);
                dataBuku.add(historyBook);
                System.out.println("Buku History berhasil ditambahkan");
                break;
            case "2":
                StoryBook storyBook = new StoryBook(bookId, judul, penulis, "Story Book", stock);
                dataBuku.add(storyBook);
                System.out.println("Buku Story berhasil ditambahkan");
                break;
            case "3":
                TextBook textBook = new TextBook(bookId, judul, penulis, "Text Book", stock);
                dataBuku.add(textBook);
                System.out.println("Buku Text berhasil ditambahkan");
                break;
            default:
                System.out.println("Kategori tidak valid");
                break;
        }
    }

    public void displayStudent() {
        System.out.println("\nData Mahasiswa\n");
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Data Kosong");
        } else {
            for (Student student : dataMahasiswa) {
                System.out.println("Nama: " + student.getNama());
                System.out.println("NIM: " + student.getNim());
                System.out.println("Fakultas: " + student.getFakultas());
                System.out.println("Prodi: " + student.getProdi());
                System.out.println("");
            }
        }
    }

    public String generateId() {
        String id = UUID.randomUUID().toString();
        return "BK-" + id.substring(0, 8).toUpperCase();
    }
}