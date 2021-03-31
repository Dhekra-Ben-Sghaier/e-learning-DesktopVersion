/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Recformation;
import entity.Recnote;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import service.RecformationDao;
import service.RecnoteDao;

/**
 *
 * @author benha
 */
public class ListRecUser {
    private ObservableList<Recnote> tablerec=FXCollections.observableArrayList();
    
 private RecnoteDao rdao=RecnoteDao.getInstance();
    public ListRecUser() {
        
        RecnoteDao rdao=RecnoteDao.getInstance();
         
              
    }
      public ObservableList<Recnote> getFormAch(String d){
          tablerec = (ObservableList<Recnote>) rdao.displayAllByEmail(d);
           System.out.println(tablerec);
        return tablerec;
    }
    public ObservableList<Recnote> gettables(){
        return tablerec;
    }
}
