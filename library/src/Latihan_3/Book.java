package Latihan_3;

public class Book {
    String BookId;
    String judul;
    String penulis;
    String kategori;
    int stock;
    int durasi;

    public Book(String bookId, String judul, String penulis, String kategori, int stock, int durasi) {
        BookId = bookId;
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.stock = stock;
        this.durasi = durasi;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }
}

class HistoryBook extends Book {
    String kategori = "History";

    public HistoryBook(String bookId, String judul, String penulis, String kategori, int stock, int durasi) {
        super(bookId, judul, penulis, kategori, stock, durasi);
    }
}

class StoryBook extends Book{
    String kategori = "Story";

    public StoryBook(String bookId, String judul, String penulis, String kategori, int stock, int durasi) {
        super(bookId, judul, penulis, kategori, stock, durasi);
    }
}

class TextBook extends Book{
    String kategori = "TextBook";

    public TextBook(String bookId, String judul, String penulis, String kategori, int stock, int durasi) {
        super(bookId, judul, penulis, kategori, stock, durasi);
    }
}