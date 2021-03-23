/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FormDao;
import entity.Formateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author benha
 */
public class Listform {
            private ObservableList<Formateur> personsform=FXCollections.observableArrayList();

    public Listform() {
         FormDao pdao=FormDao.getInstance();
        personsform= (ObservableList<Formateur>) pdao.displayAll();
        System.out.println(personsform);
    }
 public ObservableList<Formateur> getPersonsform() {
        return personsform;
    }
}
