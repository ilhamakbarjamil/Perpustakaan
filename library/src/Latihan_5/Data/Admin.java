package Latihan_5.Data;

import java.util.ArrayList;
import java.util.UUID;

import Latihan_4.Book.Book;
import Latihan_4.Book.HistoryBook;
import Latihan_4.Book.StoryBook;
import Latihan_4.Book.TextBook;
import Latihan_5.IllegalAdminAccess.IllegalAdminAccess;

public class Admin extends User {

    public static ArrayList<Student> data_mahasiswa = new ArrayList<>();
    private String username = "admin";
    private String pass = "admin123";

    @Override
    public void menu() {
        while (true) {
            try {
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
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addStudent() {

        while (true) {
            try {
                String nama, nim, fakultas, prodi;
                boolean nim_sudah_ada;

                do {
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    nama = scan.nextLine();

                    if (nama.matches(".*[0-9].*")) {
                        System.out.println("Terdeteksi menggunakan angka");
                    }
                } while (nama.matches(".*[0-9].*"));

                do {
                    nim_sudah_ada = false;
                    System.out.print("Masukkan Nim Mahasisw: ");
                    nim = scan.nextLine();

                    if (nim.matches(".*[a-zA-Z].*")) {
                        System.out.println("Terdeteksi menggunakan angka");
                        continue;
                    } else if (nim.length() != 15) {
                        System.out.println("Panjang Nim harus 15 karakter");
                        continue;
                    } else {
                        for (Student sama : data_mahasiswa) {
                            if (sama.getNim().equalsIgnoreCase(nim)) {
                                System.out.println("Nim sudah ada");
                                nim_sudah_ada = true;
                                break;
                            }
                        }
                    }
                } while (nim.matches(".*[a-zA-Z].*") || nim.length() != 15 || nim_sudah_ada);

                do {
                    System.out.print("Masukkan Fakultas Mahasiswa: ");
                    fakultas = scan.nextLine();

                    if (fakultas.matches(".*[0-9].*")) {
                        System.out.println("Terdeteksi menggunakan angka");
                    }

                } while (fakultas.matches(".*[0-9].*"));

                do {
                    System.out.print("Masukkan Prodi Mahasiswa: ");
                    prodi = scan.nextLine();

                    if (prodi.matches(".*[0-9].*")) {
                        System.out.println("Terdeteksi menggunaakn angka");
                    }
                } while (prodi.matches(".*[0-9].*"));

                Student student = new Student(nama, nim, fakultas, prodi);
                data_mahasiswa.add(student);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputBook() {

        while (true) {
            try {
                System.out.print("Masukkan BookId: ");
                String BookId = generateId();
                System.out.println(generateId());

                String judul;
                boolean judul_sudahAda;
                do {
                    judul_sudahAda = false;
                    System.out.print("Masukkan Judul Buku: ");
                    judul = scan.nextLine();

                    for (Book buku : data_buku) {
                        if (buku.getJudul().equalsIgnoreCase(judul)) {
                            System.out.println("Buku sudah ada");
                            judul_sudahAda = true;
                            break;
                        }
                    }
                } while (judul_sudahAda);

                System.out.print("Masukkan Penulis Buku: ");
                String penulis = scan.nextLine();

                System.out.println("Masukkan Kategori: ");
                System.out.println("1. History Book");
                System.out.println("2. Story Book");
                System.out.println("3. Text Book");
                System.out.print("PIlih (1-3)");
                String kategori = scan.nextLine();

                System.out.print("Masukkan jumlah buku: ");
                int jumlah = scan.nextInt();
                scan.nextLine();

                switch (kategori) {
                    case "1":
                        HistoryBook historyBook = new HistoryBook(BookId, judul, penulis, "History Book", jumlah);
                        data_buku.add(historyBook);
                        break;
                    case "2":
                        StoryBook storyBook = new StoryBook(BookId, judul, penulis, "Story Book", jumlah);
                        data_buku.add(storyBook);
                        break;
                    case "3":
                        TextBook textBook = new TextBook(BookId, judul, penulis, "Text Book", jumlah);
                        data_buku.add(textBook);
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void displayStudent() {
        System.out.println("\nDaftar Mahasiswa");
        System.out.println("===================");
        if (data_mahasiswa.isEmpty()) {
            System.out.println("Data Kosong");
        } else {
            for (Student student : data_mahasiswa) {
                System.out.println("Nama: " + student.getNama());
                System.out.println("Nim: " + student.getNim());
                System.out.println("Fakultas: " + student.getFakultas());
                System.out.println("Prodi: " + student.getProdi());
                System.out.println("--");
            }
        }
        System.out.println("===================");
    }

    public String generateId() {
        String id = UUID.randomUUID().toString();
        return "77-" + id.substring(0, 8).toUpperCase();
    }

    public void isadmin() {
        while (true) {
            try {
                System.out.print("Masukkan username: ");
                String username1 = scan.nextLine();

                if (username.equalsIgnoreCase(username1)) {
                    System.out.print("Masukkan password: ");
                    String password = scan.nextLine();

                    if (pass.equalsIgnoreCase(password)) {
                        menu();
                        break;
                    } else {
                        System.out.println("password salah");
                    }

                } else {
                    System.out.println("username salah");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
