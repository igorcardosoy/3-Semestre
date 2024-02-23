package model.dao.interfaces;

import model.entity.Filme;
import java.util.List;

public interface FilmeDao {

  boolean insertMovie(Filme movie);

  boolean updateMovie(Filme movie);

  boolean deleteByTitle(String title);

  Filme findByTitle(String title);

  List<Filme> findAll();

}
