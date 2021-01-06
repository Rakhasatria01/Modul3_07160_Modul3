package Controller;

import Entity.UserEntity;
import java.util.Date;

public class UserController {

    public UserController() {
    }

    public UserEntity getData(int index) {
        return AllObjectModel.userModel.getUserEntityArrayList(index);
    }

    public void insert(String nama, String password, String notelp, Date tgl) {
        AllObjectModel.userModel.insert(new UserEntity(nama, password, notelp, tgl));
    }

    public int cekdataAkun(String nama, String password) {
        int cekdata = AllObjectModel.userModel.cekdata(nama, password);
        return cekdata;
    }

    public boolean cekKosong(boolean cek) {
        boolean cekakun = AllObjectModel.userModel.cekempty(cek);
        return cekakun;
    }
}
