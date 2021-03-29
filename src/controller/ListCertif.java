package controller;

import service.Inscription_certificatDao;
import entity.Inscription_certificat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ListCertif {
    
    private ObservableList<Inscription_certificat> certifsapp =FXCollections.observableArrayList();

    public ListCertif() {
        Inscription_certificatDao cdao=Inscription_certificatDao.getInstance();
        certifsapp= (ObservableList<Inscription_certificat>) cdao.displayAll();
        System.out.println(certifsapp);
    }

    public ObservableList<Inscription_certificat> getInscriptionCertificat() {
        return certifsapp;
    }
        
    

}
