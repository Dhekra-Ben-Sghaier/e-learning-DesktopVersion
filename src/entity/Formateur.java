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
public class Formateur  extends Personne{
    
    private SimpleStringProperty domaine ;

    public Formateur(String nom, String prenom ,String domaine) {
        super(nom, prenom);
           this.domaine = new SimpleStringProperty(domaine);
    }

    public Formateur( int id, String nom, String prenom ,String domaine) {
        super(id, nom, prenom);
        this.domaine = new SimpleStringProperty(domaine);
    }

    public String getDomaine() {
        return domaine.get();
    }

    public void setDomaine(String domaine) {
        this.domaine = new SimpleStringProperty(domaine);
    }
    public SimpleStringProperty getDomaineProperty(){
        return domaine;
    }
    
}
