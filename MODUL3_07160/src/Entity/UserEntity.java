package Entity;

import java.util.Date;

public class UserEntity extends induk {

    private String password, notelp;
    private Date tgl;

    public UserEntity(String nama, String password, String notelp, Date tgl) {
        super.nama = nama;
        this.password = password;
        this.notelp = notelp;
        this.tgl = tgl;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

}
