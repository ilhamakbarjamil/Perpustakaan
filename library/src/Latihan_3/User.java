package Latihan_3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class User {
    public static ArrayList<Book> dataBuku = new ArrayList<>();
    public Scanner scan = new Scanner(System.in);

    protected void displayBook() {
        System.out.println("\ndaftar buku\n");
        for (Book buku : dataBuku) {
            System.out.println("BookId:: " + buku.getBookId());
            System.out.println("Judul: " + buku.getJudul());
            System.out.println("Penulis: " + buku.getPenulis());
            System.out.println("Kategori: " + buku.getKategori());
            System.out.println("Stock: " + buku.getStock());
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

        if (kategori.equalsIgnoreCase("history book")) {
            HistoryBook history = new HistoryBook(bookId, judul, penulis, "History Book", stock);
            dataBuku.add(history);
        } else if (kategori.equalsIgnoreCase("story book")) {
            StoryBook story = new StoryBook(bookId, judul, penulis, "Story Book", stock);
            dataBuku.add(story);
        } else if (kategori.equalsIgnoreCase("text book")) {
            TextBook text = new TextBook(bookId, judul, penulis, "Text Book", stock);
            dataBuku.add(text);
        }
    }

}

class Student extends User {
    private String nama, nim, fakultas, prodi;
    public ArrayList<Book> bukuYangDipinjam = new ArrayList<>();

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
        System.out.println("\nBuku yang dipinjam\n: ");
        if (bukuYangDipinjam.isEmpty()) {
            System.out.println("Tidak ada buku yang dipinjam");
        } else {
            for (Book buku : bukuYangDipinjam) {
                System.out.println("Book Id: " + buku.getBookId());
                System.out.println("Judul: " + buku.getJudul());
                System.out.println("Penulis: " + buku.getPenulis());
                System.out.println("Kategori: " + buku.getKategori());
                System.out.println("Jumlah: " + buku.getStock());
                System.out.println("Durasi (hari): " + buku.getDurasi());
                System.out.println("");
            }
        }
    }

    public void PinjamBuku() {
        displayBook();
        while (true) {
            System.out.print("Masukkan judul buku yang ingin dipinjam: ");
            String judul = scan.nextLine();
            boolean found = false;

            for (Book buku1 : dataBuku) {
                if (buku1.getJudul().equalsIgnoreCase(judul)) {
                    found = true;
                    System.out.print("Masukkan jumlah pinjam: ");
                    int jumlah = scan.nextInt();
                    scan.nextLine();

                    if (jumlah > buku1.getStock()) {
                        System.out.println("Melebihi stock yang ada");
                    } else {
                        System.out.print("durasi peminjaman (maks. 14 hari): ");
                        int durasi = scan.nextInt();
                        scan.nextLine();

                        if (durasi > 14 || durasi < 0) {
                            System.out.println("Melebihi ketentuan");
                        } else {
                            buku1.setStock(buku1.getStock() - jumlah);

                            Book buku2 = new Book(buku1.getBookId(), buku1.getJudul(), buku1.getPenulis(),
                                    buku1.getKategori(), jumlah);
                            buku2.setDurasi(durasi);
                            bukuYangDipinjam.add(buku2);
                            System.out.println("Buku " + judul + " berhasil dipinjam");
                            return;
                        }
                    }
                }
            }

            if (!found) {
                System.out.println("Buku " + judul + " tidak di temukan");
            }

        }
    }

    public void returnBook() {
        displayBookBorrowed();
        while (true) {
            System.out.print("Masukkan judul buku yang di kembalikan: ");
            String judul = scan.nextLine();
            boolean found = false;

            for (Book buku1 : dataBuku) {
                for (Book buku2 : bukuYangDipinjam) {
                    if (judul.equalsIgnoreCase(buku2.getJudul())) {

                        found = true;
                        System.out.print("Masukkan jumlah buku yang di kembalikan: ");
                        int jumlah = scan.nextInt();
                        scan.nextLine();

                        if (jumlah > buku2.getStock()) {
                            System.out.println("Melebihi stok yang di pinjam: " + buku2.getStock());
                        } else {
                            buku1.setStock(buku1.getStock() + jumlah);
                            buku2.setStock(buku2.getStock() - jumlah);
                            bukuYangDipinjam.remove(buku2);
                            System.out.println("Buku " + judul + " berhasil di kembalikan");
                            return;
                        }
                    }
                }
            }

            if (!found) {
                System.out.println("Buku " + judul + ", tidak di temukan ");
            }
        }
    }

    public void logout() {
        System.out.println("\nNama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Fakultas: " + getFakultas());
        System.out.println("Prodi: " + getProdi());
        System.out.println("\nberhasil logout\n");
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

        if (ifNimExist(nim)) {
            System.out.println("Nim sudah ada");
            return;
        }

        System.out.print("Masukkan Fakultas Mahasiswa: ");
        fakultas = scan.nextLine();
        System.out.print("Masukkan Prodi Mahasiswa: ");
        prodi = scan.nextLine();

        Student student = new Student(nama, nim, fakultas, prodi);
        dataMahasiswa.add(student);
    }

    private boolean ifNimExist(String nim) {
        for (Student student : dataMahasiswa) {
            if (student.getNim().equalsIgnoreCase(nim)) {
                System.out.println("Nim sudah ada");
                return true;
            }
        }
        return false;
    }

    public void addStudent() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scan.nextLine();

        String nim;
        do {
            System.out.print("Masukkan Nim Mahasiswa: ");
            nim = scan.nextLine();
        } while (ifNimExist(nim) || nim.length() != 15);

        System.out.print("Masukkan Fakultas Mahasiswa: ");
        String fakultas = scan.nextLine();
        System.out.print("Masukkan Prodi Mahasiswa: ");
        String prodi = scan.nextLine();

        Student student = new Student(nama, nim, fakultas, prodi);
        dataMahasiswa.add(student);
    }

    private boolean judulsama(String judul) {
        for (Book book : dataBuku) {
            if (book.getJudul().equalsIgnoreCase(judul)) {
                System.out.println("Judul sudah ada");
                return true;
            }
        }
        return false;
    }

    private boolean bookIdSama(String bookId){
        for(Book buku : dataBuku){
            if(buku.getJudul().equalsIgnoreCase(bookId)){
                System.out.println("Book Id sudah ada");
                return true;
            }
        }
        return false;
    }

    public void InputBook() {
        System.out.println("Tambah Buku");

        String bookId;
        do {
            System.out.print("Masukkan Book Id: ");
            bookId = generateId();
            System.out.println("Book Id: " + bookId);
        } while (bookIdSama(bookId));

        String judul;

        do {
            System.out.print("Masukkan judul buku: ");
            judul = scan.nextLine();
        } while (judulsama(judul));

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