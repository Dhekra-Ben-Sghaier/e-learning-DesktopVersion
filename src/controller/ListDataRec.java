/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.RecnoteDao;
import entity.Recnote;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author asus
 */
public class ListDataRec {
    
     /**
     * The data as an observable list of Persons.
     */
    
    private ObservableList<Recnote> tablesrec=FXCollections.observableArrayList();

    public ListDataRec() {
        
        RecnoteDao pdao=RecnoteDao.getInstance();
          tablesrec= (ObservableList<Recnote>) pdao.displayAll();
               System.out.println(tablesrec);
    }
    
    public ObservableList<Recnote> gettables(){
        return tablesrec;
    }

    
   
}
    