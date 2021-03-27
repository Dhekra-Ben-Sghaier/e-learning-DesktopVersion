/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;


public interface Idao<T> {
    public void insert(T o,int prix);
    
    public List<T> displayAll();
    public T displayById(int id);
    
    public boolean update(T os);
    
}
