package Latihan_3;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    

    
}

class Student extends User{
    String nama, nim, fakultas, prodi;

    public Student(String nama, String nim, String fakultas, String prodi) {
        this.nama = nama;
        this.nim = nim;
        this.fakultas = fakultas;
        this.prodi = prodi;
    }

    




}

class Admin extends User{
    String username = "admin";
    String password = "admin123";
    Scanner scan = new Scanner(System.in);
    static ArrayList<Student> dataMahasiswa = new ArrayList<>();

    public void addStudent(){
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Nim Mahasiswa: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Fakultas Mahasiswa: ");
        String fakultas = scan.nextLine();
        System.out.print("Masukkan Prodi Mahasiswa: ");
        String prodi = scan.nextLine();

        Student student = new Student(nama, nim, fakultas, prodi);
        dataMahasiswa.add(student);
    }

    public void displayStudent(){
        System.out.println("\nData Mahasiswa\n");
        if(dataMahasiswa.isEmpty()){
            System.out.println("Data Kosong");
        }else{
            
        }
    }
    
}