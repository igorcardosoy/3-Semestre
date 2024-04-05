package model.dao.implementations;

import model.dao.interfaces.Dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DaoImpl<T> implements Dao<T>{

    private static DaoImpl instance;
    private final List<T> dataset;

    private DaoImpl() {
        this.dataset = new LinkedList<>();
    }

    public DaoImpl getInstance() {
        if (instance == null) {
            instance = new DaoImpl<>();
        }

        return instance;
    }

    public Boolean add(T element) {
        return dataset.add(element);
    }

    public Boolean edit(T oldElement, T newElement) {
        if (!dataset.remove(oldElement)) return false;
        return dataset.add(newElement);
    }

    public Boolean remove(T element) {
        return dataset.remove(element);
    }

    public Boolean contain(T element) {
        return dataset.contains(element);
    }

    public List<T> getAll() {
        return new ArrayList<>(dataset);
    }
}
