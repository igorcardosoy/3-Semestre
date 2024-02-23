package model.dao.impl;

import model.dao.interfaces.DiretorDao;
import model.entity.Diretor;
import java.util.List;

public class DiretorDaoImpl implements DiretorDao {

  List<Diretor> diretores;

  @Override
  public List<Diretor> findAll() {
    if (!diretores.isEmpty()){
      return diretores;
    }

    return null;
  }

  @Override
  public Diretor findByName(String name) {
    for (Diretor bdDiretor : diretores){
      if (bdDiretor.getNome().equals(name)) {
        return bdDiretor;
      }
    }

    return null;
  }

  private int findIndex(String name){
    int index = 0;

    for (Diretor bdDiretor : diretores){
      if (bdDiretor.getNome().equals(name)){
        return index;
      }
      index++;
    }

    return -1;
  }

  @Override
  public void insert(Diretor director) {
    if (findByName(director.getNome()) == null){
      diretores.add(director);
    }
  }

  @Override
  public void update(Diretor oldDirector, Diretor newDirector) {
    int index = findIndex(oldDirector.getNome());

    if (index > -1){
      diretores.set(index, newDirector);
    }
  }

  @Override
  public void delete(String name) {
    int index = findIndex(name);

    if (index > -1){
      diretores.remove(index);
    }
  }
}
