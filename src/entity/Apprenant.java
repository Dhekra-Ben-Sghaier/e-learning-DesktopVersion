/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author benha
 */
public class Apprenant extends Personne {
    
    private SimpleStringProperty cd ; //centre d'interet

    public Apprenant(String nom, String prenom ,String cd) {
        super(nom, prenom);
        this.cd = new SimpleStringProperty(cd);
    }
    
    public Apprenant(int id, String nom, String prenom ,String cd) {
        super(id, nom, prenom);
        this.cd = new SimpleStringProperty(cd);
    }

    public String getCd() {
        return cd.get();
    }

    public void setCd(String cd) {
        this.cd = new SimpleStringProperty(cd);
    }
 public SimpleStringProperty getCdProperty(){
        return cd;
    }
    
}
