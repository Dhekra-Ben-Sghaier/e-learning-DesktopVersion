package Controllers;

import service.Inscription_certificatDao;
import entity.Inscription_certificat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author benha
 */
public class ListCertif {
        private ObservableList<Inscription_certificat> personsapp=FXCollections.observableArrayList();

    public ListCertif() {
        Inscription_certificatDao pdao=Inscription_certificatDao.getInstance();
        personsapp= (ObservableList<Inscription_certificat>) pdao.displayAll();
        System.out.println(personsapp);
    }

    public ObservableList<Inscription_certificat> getPersonsapp() {
        return personsapp;
    }
        

}
