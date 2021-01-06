package Model;
import Entity.UserEntity;
import java.util.ArrayList;
public class UserModel{
    private ArrayList <UserEntity> userEntityArrayList;

    public UserModel(){
        userEntityArrayList = new ArrayList <UserEntity>();
    }
    
    public void insert (UserEntity userEntity){
        userEntityArrayList.add(userEntity);
    }
    
    public int cekdata(String nama, String password){
        int loop = 0;
        while(!userEntityArrayList.get(loop).getNama().equals(nama)&&
                !userEntityArrayList.get(loop).getPassword().equals(password)){
            loop++;
        }
        return loop;
    }
    
    public UserEntity getUserEntityArrayList(int index){
        return userEntityArrayList.get(index);
    }
    
    public boolean cekempty(boolean cek){
        while(userEntityArrayList.isEmpty()){
            System.out.println("\nBELUM ADA AKUN YANG TERDAFTAR\n");
            cek=true;
            break;
        }
        while(!userEntityArrayList.isEmpty()){
            cek=false;
            break;
        }
        return cek;
    }
}