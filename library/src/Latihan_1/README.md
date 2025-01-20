# Library System

## Deskripsi
Program ini adalah sebuah sistem perpustakaan sederhana berbasis console yang memungkinkan pengguna untuk login sebagai "Student" atau "Admin". Program ini dibuat menggunakan bahasa pemrograman Java dan dirancang untuk memvalidasi input serta menangani kesalahan input secara dinamis.

## Fitur Utama
1. **Login sebagai Student:**
   - Pengguna diminta memasukkan NIM yang terdiri dari 15 karakter.
   - Jika input NIM tidak sesuai, pengguna akan diminta untuk memasukkan ulang hingga benar.
   - Setelah NIM valid, pengguna berhasil login sebagai "Student".

2. **Login sebagai Admin:**
   - Admin menggunakan username `admin` dan password `admin123`.
   - Sistem memberikan hingga 5 kesempatan untuk memasukkan username dan password yang benar.
   - Jika username atau password salah lebih dari 5 kali, program akan keluar secara otomatis.

3. **Keluar Program:**
   - Pengguna dapat memilih untuk keluar dari program dengan opsi menu.

## Cara Penggunaan
1. Jalankan program.
2. Pilih salah satu opsi menu yang tersedia:
   - `1` untuk login sebagai Student.
   - `2` untuk login sebagai Admin.
   - `3` untuk keluar dari program.
3. Ikuti petunjuk input sesuai dengan pilihan:
   - Untuk Student, masukkan NIM (15 karakter).
   - Untuk Admin, masukkan username dan password.
4. Jika berhasil login, program akan menampilkan pesan sukses.
5. Jika ingin keluar, pilih opsi `3`.

## Struktur Program
- **Menu Utama:** Menampilkan tiga opsi untuk pengguna.
- **Validasi NIM:** Memastikan NIM yang dimasukkan memiliki 15 karakter dan tidak mengandung huruf.
- **Validasi Login Admin:** Memastikan username dan password yang dimasukkan sesuai, dengan batas maksimum percobaan.
- **Error Handling:**
  - Menangani input yang tidak valid.
  - Memberikan pesan kesalahan yang informatif kepada pengguna.

## Contoh Interaksi
### Login sebagai Student:
```
=== Library System ===
1. Login as Student
2. Login as Admin
3. Exit
Masukkan pilihan (1-3): 1
Masukkan Nim: 123456789012345
Login berhasil sebagai student
```

### Login sebagai Admin:
```
=== Library System ===
1. Login as Student
2. Login as Admin
3. Exit
Masukkan pilihan (1-3): 2
Masukkan Username: admin
Masukkan Password: admin123
Berhasil login sebagai admin
```

### Input Salah:
```
=== Library System ===
1. Login as Student
2. Login as Admin
3. Exit
Masukkan pilihan (1-3): 1
Masukkan Nim: 123
Nim harus 15 karakter panjangnya
Masukkan Nim: 123456789012345
Login berhasil sebagai student
```

## Prasyarat
- Java Development Kit (JDK) versi 8 atau lebih baru.
- IDE atau editor teks yang mendukung Java, seperti IntelliJ IDEA, Eclipse, atau VS Code.

## Cara Menjalankan Program
1. Salin kode program ke file dengan nama `Latihan_1.java`.
2. Kompilasi program menggunakan perintah:
   ```
javac Latihan_1.java
   ```
3. Jalankan program menggunakan perintah:
   ```
java Latihan_1
   ```

## Catatan
- Program ini hanya menyediakan simulasi login sederhana tanpa koneksi ke database.
- Untuk pengembangan lebih lanjut, Anda bisa menambahkan fitur seperti:
  - Penyimpanan data pengguna.
  - Antarmuka pengguna berbasis GUI.
  - Integrasi dengan database untuk menyimpan data login.

