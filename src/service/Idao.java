/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author Asus
 * @param <T>
 */
    public interface Idao<T> {
    public void insert(T o);
   // public void delete(T o);
    public List<T> displayAll();
    public List<T> displayAllById(int id);
    
    public boolean update(T os);
    
}
    
