package Latihan_4.Data;

import java.util.ArrayList;
import java.util.UUID;

import Latihan_4.Book.Book;
import Latihan_4.Book.HistoryBook;
import Latihan_4.Book.StoryBook;
import Latihan_4.Book.TextBook;

public class Admin extends User {

    ArrayList<Student> data_mahasiswa = new ArrayList<>();

    @Override
    public void menu() {
        while (true) {
            System.out.println("Menu Admin");
            System.out.println("===================");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tambah Buku");
            System.out.println("3. Tampilkan data Mahasiswa");
            System.out.println("4. Tampilkan daftar Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih(1-5): ");
            int jawab = scan.nextInt();
            scan.nextLine();

            switch (jawab) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    inputBook();
                    break;
                case 3:
                    displayStudent();
                    break;
                case 4:
                    displayBook();
                    break;
                case 5:
                    System.out.println("Keluar");
                    return;
                default:
                    System.out.println("Pilihan hanya (11-5)");
                    break;
            }
        }
    }

    private void addStudent() {

        while (true) {
            String nama, nim, fakultas, prodi;
            do {
                System.out.print("Masukkan Nama Mahasiswa: ");
                nama = scan.nextLine();

                if (nama.matches(".*[0-9!@#$%^&*+=]*.")) {
                    System.out.println("Harus menggunakan huruf");
                }

                System.out.print("Masukkan Nim Mahasiswa: ");
                nim = scan.nextLine();

                if (nim.length() != 15 && nim.matches(".*[a-zA-Z!@#$%^&*]*.")) {
                    System.out.println("Nim harus menggunakan angka");
                }

                System.out.print("Masukkan Fakultas Mahasiswa: ");
                fakultas = scan.nextLine();

                if (fakultas.matches(".*[0-9!@#$%^&*+=]*.")) {
                    System.out.println("Harus menggunakan huruf");
                }

                System.out.print("Masukkan Prodi Mahasiswa: ");
                prodi = scan.nextLine();

                if (prodi.matches(".*[0-9!@#$%^&*+=]*.")) {
                    System.out.println("Harus menggunakan huruf");
                }

                Student student = new Student(nama, nim, fakultas, prodi);
                data_mahasiswa.add(student);
                return;

            } while (nama.matches(".*[0-9!@#$%^&*+=]*.") || nim.length() != 15 && nim.matches(".*[a-zA-Z!@#$%^&*]*.")
                    || fakultas.matches(".*[0-9!@#$%^&*+=]*.") || prodi.matches(".*[0-9!@#$%^&*+=]*."));

        }
    }

    public void inputBook() {

        String BookId, judul, penulis, kategori;
        int stock;
        while (true) {

            for (Book buku : data_buku) {
                do {
                    System.out.print("Masukkan BookId: ");
                    BookId = generateId();
                    System.out.println(generateId());

                    System.out.print("Masukkan Judul: ");
                    judul = scan.nextLine();
                    if (buku.getJudul().equalsIgnoreCase(judul)) {
                        System.out.println("Buku sudah ada");
                    }

                    System.out.print("Masukkan Penulis: ");
                    penulis = scan.nextLine();

                    System.out.println("Masukkan Kategori");
                    System.out.println("1. History Book");
                    System.out.println("2. Story Book");
                    System.out.println("3. Text Book");
                    System.out.print("Pilih(1-3): ");
                    kategori = scan.nextLine();

                    System.out.print("Masukkan jumlah: ");
                    stock = scan.nextInt();
                    scan.nextLine();

                    switch (kategori) {
                        case "1":
                            HistoryBook historyBook = new HistoryBook(BookId, judul, penulis, "History Book", stock);
                            data_buku.add(historyBook);
                            break;

                        case "2":
                            StoryBook storyBook = new StoryBook(BookId, judul, penulis, "Story Book", stock);
                            data_buku.add(storyBook);
                            break;

                        case "3":
                            TextBook textBook = new TextBook(BookId, judul, penulis, "Text Book", stock);
                            data_buku.add(textBook);
                            break;

                        default:
                            System.out.println("Pilihan hanya 1-3");
                            break;
                    }
                    return;

                } while (buku.getJudul().equalsIgnoreCase(judul));
            }

        }
    }

    @Override
    public void displayBook() {
        super.displayBook();
        for (Book buku : data_buku) {
            if (data_buku.isEmpty()) {
                System.out.println("Buku Kosong");
            } else {
                System.out.println("BookId: " + buku.getBookId());
                System.out.println("Judul: " + buku.getJudul());
                System.out.println("Penulis: " + buku.getPenulis());
                System.out.println("Kategori: " + buku.getKategori());
                System.out.println("Jumlah: " + buku.getStock());
                System.out.println("-");
            }
        }
    }

    public void displayStudent(){
        System.out.println("\nDaftar Mahasiswa");
        System.out.println("===================");
        if(data_mahasiswa.isEmpty()){
            System.out.println("Data Kosong");
        }else{
            for(Student student : data_mahasiswa){
                System.out.println("Nama: "+student.getNama());
                System.out.println("Nim: "+student.getNim());
                System.out.println("Fakultas: "+student.getFakultas());
                System.out.println("Prodi: "+student.getProdi());
                System.out.println("--");
            }
        }
    }

    public String generateId(){
        String id = UUID.randomUUID().toString();
        return "77-" + id.substring(0, 8).toUpperCase();
    }
}
