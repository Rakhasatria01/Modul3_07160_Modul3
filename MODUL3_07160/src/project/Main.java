package project;

import Controller.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static UserController user = new UserController();
    private static FilmController film = new FilmController();
    private static int cekdata, loop = -1;

    public static void main(String[] args) {
        daftarfilm();
        int pilih;
        do {
            System.out.println("Selamat Datang di RPL XXI!!!");
            System.out.println("1. Daftar");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Masukkan Pilihan = ");
            pilih = input.nextInt();
            switch (pilih) {
                case 1:
                    daftar();
                    break;
                case 2:
                    login();
                    break;
            }
        } while (pilih != 3);
    }

    private static void daftar() {
        try {
            System.out.print("Masukkan nama          : ");
            String nama = input.next();
            System.out.print("Masukkan password      : ");
            String password = input.next();
            System.out.print("Masukkan no telp       : ");
            String notelp = input.next();
            System.out.print("Masukkan tanggal lahir : ");
            Date tanggal = new Date(input.next());
            user.insert(nama, password, notelp, tanggal);
        } catch (Exception e) {
            System.out.println("Format salah gagal daftar");
        }
    }

    private static void login() {
        try {
            int pil;
            System.out.print("Masukkan nama          : ");
            String nama = input.next();
            System.out.print("Masukkan password      : ");
            String password = input.next();
            cekdata = user.cekdataAkun(nama, password);
            System.out.println("\nSelamat datang " + user.getData(cekdata).getNama() + "\n");
            do {
                System.out.println("Menu ");
                System.out.println("1. Beli tiket");
                System.out.println("2. Cetak tiket");
                System.out.println("3. Update akun");
                pil = input.nextInt();
                switch (pil) {
                    case 1:
                        belitiket();
                        break;
                    case 2:
                        cetaktiket();
                        break;
                    case 3:
                        update();
                        break;
                }
            } while (pil <= 2);
        } catch (Exception e) {
            System.out.println("Nama atau password salah");
        }
    }

    private static void daftarfilm() {
        String namaFilm[] = {"Titanic", "IT", "UP"};
        String tanggaltayang[] = {"12/08/2021", "03/07/2021", "08/10/2021"};
        for (int i = 0; i < namaFilm.length; i++) {
            film.insert(namaFilm[i], 25000, new Date(tanggaltayang[i]));
        }
    }

    private static void belitiket() {
        System.out.println("List Film Tahun 2021 : ");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + 1);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" Judul       : " + film.getData(i).getNama());
            System.out.println(" Harga           : " + film.getData(i).getHarga());
            System.out.println(" Tanggal tayang  : " + new SimpleDateFormat("dd-MM-yyyy").format(film.getData(i).getTanggaltayang()));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        System.out.print("Film no berapa yang ingin ditonton? no ");
        int idx = input.nextInt();
        loop++;
        film.getData(loop).setIndexakun(cekdata);
        film.getData(loop).setIndex(idx - 1);
        System.out.println("Tiket untuk film " + film.getData(film.getData(loop).getIndex()).getNama() + "berhasil dibeli");
    }

    private static void cetaktiket() {
        System.out.println("Tiket yang anda miliki :");
        if (loop < 0) {
            System.out.println("Belum ada tiket yang dibeli");
        } else {
            for (int i = 0; i <= loop; i++) {
                if (film.getData(i).getIndexakun() == cekdata) {
                    System.out.println("No tiket : " + (film.getData(i).getIndex() + 1));
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println(" Judul           : " + film.getData(film.getData(loop).getIndex()).getNama());
                    System.out.println(" Harga           : " + film.getData(film.getData(loop).getIndex()).getHarga());
                    System.out.println(" Tanggal tayang  : " + new SimpleDateFormat("dd-MM-yyyy").format(film.getData(film.getData(loop).getIndex()).getTanggaltayang()));
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
            System.out.println("No tiket yang ingin dicetak = ");
            int notiket = input.nextInt();
            System.out.println("\nNama pembeli : " + user.getData(cekdata).getNama());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" Judul       : " + film.getData(notiket - 1).getNama());
            System.out.println(" Harga           : " + film.getData(notiket - 1).getHarga());
            System.out.println(" Tanggal tayang  : " + new SimpleDateFormat("dd-MM-yyyy").format(film.getData(notiket - 1).getTanggaltayang()));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            film.delete(notiket - 1);
            loop--;
        }
    }

    private static void update() {
        try {
            System.out.println("1. nama");
            System.out.println("2. password");
            System.out.println("3. no telp");
            System.out.println("4. tanggal lahir");
            System.out.print("yang mau diupdate no = ");
            int pilih = input.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan nama baru = ");
                    String newnama = input.next();
                    user.getData(cekdata).setNama(newnama);
                    System.out.println("Nama berhasil diupdate");
                    break;
                case 2:
                    System.out.print("Masukkan password baru = ");
                    String newpassword = input.next();
                    user.getData(cekdata).setPassword(newpassword);
                    System.out.println("Password berhasil diupdate");
                    break;
                case 3:
                    System.out.print("Masukkan notelp baru = ");
                    String newnotelp = input.next();
                    user.getData(cekdata).setNotelp(newnotelp);
                    System.out.println("No telp berhasil diupdate");
                    break;
                case 4:
                    System.out.print("Masukkan tanggal lahir baru = ");
                    Date newtgllahir = new Date(input.next());
                    user.getData(cekdata).setTgl(newtgllahir);
                    System.out.println("tanggal lahir berhasil diupdate");
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
