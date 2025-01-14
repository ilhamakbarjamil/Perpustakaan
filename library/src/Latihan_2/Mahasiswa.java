package Latihan_2;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
   

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public static String tampilUniversitas(){
        return "Universitas Muhammadiyah Malang";
    }

    public String tampildataMahasiswa(){
        return "Nama: "+nama+", Nim: "+nim+", Jurusan: "+jurusan;
    }
}
