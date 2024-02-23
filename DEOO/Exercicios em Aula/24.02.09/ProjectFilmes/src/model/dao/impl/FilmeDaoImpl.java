package model.dao.impl;

import model.dao.interfaces.FilmeDao;
import model.entity.Filme;

import java.util.List;

public class FilmeDaoImpl implements FilmeDao {

  List<Filme> filmes;

  @Override
  public boolean insertMovie(Filme movie) {
    return false;
  }

  @Override
  public boolean updateMovie(Filme movie) {
    return false;
  }

  @Override
  public boolean deleteByTitle(String title) {
    return false;
  }

  @Override
  public Filme findByTitle(String title) {
    return null;
  }

  @Override
  public List<Filme> findAll() {
    return null;
  }
}
