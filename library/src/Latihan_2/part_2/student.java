package Latihan_2.part_2;

public class student {
    private String nama, fakultas, programStudi, nim;

    public String getNama() {
        return nama;
    }

    public String getFakultas() {
        return fakultas;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public student(String nama, String fakultas, String programStudi, String nim) {
        this.nama = nama;
        this.fakultas = fakultas;
        this.programStudi = programStudi;
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public String display(){
        return "Nama: "+nama+"\nNim: "+nim+"\nFakultas: "+fakultas+"\nJurusan: "+programStudi+"\n";
    }

    public void logout(student mahasiswa){
        System.out.println("Nama: "+mahasiswa.getNama()+", Nim: "+mahasiswa.getNim()+", Fakultas: "+mahasiswa.getFakultas()+"\nTerimakasih");
    }
}
