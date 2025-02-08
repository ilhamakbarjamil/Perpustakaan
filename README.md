# Aplikasi Perpustakaan dengan Java GUI, Database SQL (XAMPP), dan Email API

## Deskripsi Proyek

Aplikasi Perpustakaan ini dibuat menggunakan bahasa pemrograman **Java** dengan antarmuka berbasis **GUI**. Sistem ini terhubung dengan **database SQL** yang dikelola melalui **phpMyAdmin di XAMPP**. Selain itu, aplikasi ini memiliki fitur notifikasi email kepada pengguna setiap kali mereka berhasil **meminjam** atau **mengembalikan** buku.

## Fitur Utama

- **Manajemen Buku**: Tambah, edit, hapus, dan melihat daftar buku.
- **Manajemen Pengguna**: Registrasi dan login pengguna.
- **Peminjaman Buku**: Pengguna dapat meminjam buku dengan mencatat tanggal peminjaman dan batas waktu pengembalian.
- **Pengembalian Buku**: Pengguna dapat mengembalikan buku, dan sistem akan mencatat transaksi ini.
- **Notifikasi Email**: Mengirim email notifikasi kepada pengguna saat mereka berhasil meminjam atau mengembalikan buku.

## Teknologi yang Digunakan

- **Java (Swing)**: Untuk antarmuka GUI.
- **MySQL (XAMPP/phpMyAdmin)**: Untuk database.
- **JavaMail API**: Untuk mengirim notifikasi email kepada pengguna.

## Instalasi dan Konfigurasi

### 1. Persiapan Lingkungan

- Pastikan sudah menginstal **JDK** dan **XAMPP** di sistem Anda.
- Aktifkan **Apache** dan **MySQL** melalui XAMPP Control Panel.

### 2. Konfigurasi Database

1. Buka **phpMyAdmin** melalui browser dengan alamat: `http://localhost/phpmyadmin/`
2. Buat database baru dengan nama: `perpustakaan_db`
3. Jalankan skrip SQL berikut untuk membuat tabel utama:

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255)
);

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    judul VARCHAR(255),
    penulis VARCHAR(100),
    tahun INT,
    stok INT
);

CREATE TABLE peminjaman (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    book_id INT,
    tanggal_pinjam DATE,
    tanggal_kembali DATE,
    status ENUM('dipinjam', 'dikembalikan'),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);
```

### 3. Konfigurasi Email API

1. Aktifkan **Less Secure App** di akun Gmail Anda atau gunakan layanan SMTP lain.
2. Tambahkan dependensi **JavaMail API** ke proyek Anda.
3. Konfigurasi pengaturan SMTP dalam kode Java:

```java
Properties properties = new Properties();
properties.put("mail.smtp.auth", "true");
properties.put("mail.smtp.starttls.enable", "true");
properties.put("mail.smtp.host", "smtp.gmail.com");
properties.put("mail.smtp.port", "587");

Session session = Session.getInstance(properties, new Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("emailanda@gmail.com", "passwordaplikasi");
    }
});
```

## Cara Menggunakan Aplikasi

1. Jalankan **XAMPP**, aktifkan **Apache** dan **MySQL**.
2. Import database `perpustakaan_db.sql` ke **phpMyAdmin**.
3. Buka dan jalankan file **Main.java** dalam IDE Java.
4. Login atau daftar sebagai pengguna.
5. Pinjam atau kembalikan buku dan periksa email untuk notifikasi.

## Kontak dan Kontribusi

Jika ada pertanyaan atau ingin berkontribusi, silakan hubungi kami melalui email atau buat **Pull Request** di repository ini.

---

**Dibuat oleh [ilham akbar jamil]**
