package model.dao.interfaces;

import model.entity.Ator;
import java.util.List;

public interface AtorDao {
  List<Ator> findAll();

  Ator findByName(String name);

  void insert(Ator actor);

  void updateByName(String name, Ator actor);

  void delete(String name);
}
