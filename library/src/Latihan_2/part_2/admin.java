package Latihan_2.part_2;

import java.util.ArrayList;
import java.util.Scanner;

public class admin {
    String username = "admin";
    String password = "admin123";
    static ArrayList<student> dataMahasiswa = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void addStudent(){
        while (true) {
            System.out.println("Masukkan nama mahasiswa: ");
            String nama = scan.nextLine();
            System.out.println("Masukkakan nim mahasiswa: ");
            String nim = scan.nextLine();
            System.out.println("Masukkan fakultas mahasiswa: ");
            String fakultas = scan.nextLine();
            System.out.println("Masukkan Program studi mahasiswa: ");
            String jurusan = scan.nextLine();

            student mahasiswa = new student(nama, fakultas, jurusan, nim);
            dataMahasiswa.add(mahasiswa);
            break;
        }
    }

    public void displayStudent(){
        System.out.println("daftar mahasiswa\n");
        if(dataMahasiswa.isEmpty()){
            System.out.println("data sedang kosong");
        }else{
            for(student data : dataMahasiswa){
                System.out.println(data.display());
            }
        }
    }
}
