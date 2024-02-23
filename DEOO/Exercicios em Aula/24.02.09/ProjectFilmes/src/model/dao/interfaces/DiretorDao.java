package model.dao.interfaces;
import model.entity.Diretor;

import java.util.List;

public interface DiretorDao {

  List<Diretor> findAll();

  Diretor findByName(String name);

  void insert(Diretor director);

  void update(Diretor oldDirector, Diretor newDirector);

  void delete(String name);
}
