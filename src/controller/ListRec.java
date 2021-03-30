/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Recformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import service.RecformationDao;

/**
 *
 * @author asus
 */
public class ListRec {
     private ObservableList<Recformation> tablerec=FXCollections.observableArrayList();

    public ListRec() {
        
        RecformationDao rdao=RecformationDao.getInstance();
          tablerec= (ObservableList<Recformation>) rdao.displayAll();
               System.out.println(tablerec);
    }
    
    public ObservableList<Recformation> gettables(){
        return tablerec;
    }

    
}
