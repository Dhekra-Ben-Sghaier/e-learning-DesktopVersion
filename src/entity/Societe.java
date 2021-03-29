/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author benha
 */
public class Societe extends Personne {
    private SimpleStringProperty nomSoc;
    public Societe() {
    }

    public Societe( String email, String mdp, String login ,String nomSoc) {
        super(email, mdp, login);
        this.nomSoc =new SimpleStringProperty( nomSoc);
    }

      public SimpleStringProperty getNomSocProperty(){
        return nomSoc;
    }
    public String getNomSoc() {
        return nomSoc.get();
    }

    public void setNomSoc(String nomSoc) {
        this.nomSoc = new SimpleStringProperty(nomSoc);
    }
}
