package Model;
import Entity.FilmEntity;
import java.util.ArrayList;
public class FilmModel{
    private ArrayList <FilmEntity> filmEntityArrayList;

    public FilmModel(){
        filmEntityArrayList = new ArrayList <FilmEntity>();
    }
    
    public void insert (FilmEntity filmEntity){
        filmEntityArrayList.add(filmEntity);
    }
   
    public FilmEntity getFilmEntityArrayList(int index){
        return filmEntityArrayList.get(index);
    }
    
    public void delete(int index){
        filmEntityArrayList.remove(index);
    }
}
