/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import service.PubDao;
import entity.Pub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author hp
 */

    public class ListDetPub {
        private ObservableList<Pub> publi=FXCollections.observableArrayList();
        //private ObservableList<Pub> prixPub=FXCollections.observableArrayList();
    public ListDetPub() {
       PubDao pdao=PubDao.getInstance();
       publi= (ObservableList<Pub>) pdao.displayAll();
// prixPub = (ObservableList<Pub>) pdao.displayPrixList();
//       
//       System.out.println(publi);
    }
   public ObservableList<Pub> getPub() {
        return publi;
    }
//   public ObservableList<Pub> getPrixPub() {
//        return prixPub;
//   }
}
