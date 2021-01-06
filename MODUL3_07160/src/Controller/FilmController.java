package Controller;

import Entity.FilmEntity;
import java.util.Date;

public class FilmController {

    public FilmController() {
    }

    public FilmEntity getData(int index) {
        return AllObjectModel.filmModel.getFilmEntityArrayList(index);
    }

    public void insert(String nama, int harga, Date tanggaltayang) {
        AllObjectModel.filmModel.insert(new FilmEntity(nama, harga, tanggaltayang));
    }

    public void delete(int index) {
        AllObjectModel.filmModel.delete(index);
    }
}
