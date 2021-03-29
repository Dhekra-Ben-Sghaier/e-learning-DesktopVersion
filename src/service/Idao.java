/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import java.util.Observable;
import javafx.collections.ObservableList;

/**
 *
 * @author benha
 */
public interface Idao <T> {
      public void insert(T o);
    public void delete(T o);
    public List<T> displayAll();
    public T displayById(int id);
    public ObservableList<T> displaylist();
    public boolean update(T os);
    
}
