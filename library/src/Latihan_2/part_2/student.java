package Latihan_2.part_2;

public class student {
    String nama, fakultas, programStudi, nim;

    public String getNim() {
        return nim;
    }

    public student(String nama, String fakultas, String programStudi, String nim) {
        this.nama = nama;
        this.fakultas = fakultas;
        this.programStudi = programStudi;
        this.nim = nim;
    }

    public String display(){
        return "Nama: "+nama+"\nNim: "+nim+"\nFakultas: "+fakultas+"\nJurusan: "+programStudi;
    }

    public void logout(){
        System.exit(0);
    }

    public void displayBook(){

    }


}
