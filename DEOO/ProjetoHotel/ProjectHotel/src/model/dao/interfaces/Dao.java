package model.dao.interfaces;

import java.util.List;

public interface Dao<T>{

    Boolean add(T element);

    Boolean edit(T oldElement, T newElement);

    Boolean remove(T element);

    Boolean contain(T element);

    List<T> getAll();
}
