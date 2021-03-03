/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AppDao;
import entity.Apprenant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author benha
 */
public class ListDet {
        private ObservableList<Apprenant> personsapp=FXCollections.observableArrayList();

    public ListDet() {
        AppDao pdao=AppDao.getInstance();
        personsapp= (ObservableList<Apprenant>) pdao.displayAll();
        System.out.println(personsapp);
    }

    public ObservableList<Apprenant> getPersonsapp() {
        return personsapp;
    }
        

}
