/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Formation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import service.FormationDao;

/**
 *
 * @author Asus
 */
class ListData {
        
    private ObservableList<Formation> formation =FXCollections.observableArrayList();
    private ObservableList<Formation> formAchete =FXCollections.observableArrayList();

    public ListData() {
        
        FormationDao fdao =FormationDao.getInstance();
        formation = (ObservableList<Formation>) fdao.displayAll();
        formAchete = (ObservableList<Formation>) fdao.displayAllById(1);
        
    }
    
    public ObservableList<Formation> getFormations(){
        
        return formation;
    }
    
    public ObservableList<Formation> getFormAch(){
        
        return formAchete;
    }
    
    



    
}