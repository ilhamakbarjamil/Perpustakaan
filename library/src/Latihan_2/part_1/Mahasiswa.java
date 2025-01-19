package Latihan_2.part_1;

public class Mahasiswa {

    String nama, nim, jurusan;

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public static String tampilUniversitas(){
        return "Universitas Muhammadiyah Malang\n";
    }

    public String tampildataMahasiswa(){
        return "Nama: "+nama+"\nNim: "+nim+"\nJurusan: "+jurusan;
    }

}