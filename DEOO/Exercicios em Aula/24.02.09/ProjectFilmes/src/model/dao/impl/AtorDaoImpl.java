package model.dao.impl;

import model.dao.interfaces.AtorDao;
import model.entity.Ator;

import java.util.List;

public class AtorDaoImpl implements AtorDao {

  List<Ator> atores;

  @Override
  public List<Ator> findAll() {
    if (!atores.isEmpty()){
      return atores;
    }

    return null;
  }

  @Override
  public Ator findByName(String name) {

    for (Ator bdAtor : atores) {
      if (bdAtor.getNome().equals(name)) {
        return bdAtor;
      }
    }

    return null;
  }
  
  private int findActorIndex(String name){
    int index = 0;

    for (Ator bdAtor : atores){
      if (bdAtor.getNome().equals(name)){
        return index;
      }
      index++;
    }

    return -1;
  }

  @Override
  public void insert(Ator actor) {
    if (findByName(actor.getNome()) == null){
      atores.add(actor);
    }
  }

  @Override
  public void updateByName(String name, Ator actor) {
    int index = findActorIndex(name);

    if (index > -1){
      atores.set(index, actor);
    }
  }

  @Override
  public void delete(String name) {
    int index = findActorIndex(name);

    if (index > -1){
      atores.remove(index);
    }
  }
}
