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
 * @author asus
 */
public class Recnote {
    private SimpleIntegerProperty id_reclamation;
    private SimpleStringProperty examen;
    private String date;
    private SimpleStringProperty nom_formateur;
    private SimpleStringProperty description;

    public Recnote(int id_reclamation, String examen, String date, String nom_formateur,String description) {
        this.id_reclamation = new SimpleIntegerProperty(id_reclamation);
        this.examen = new SimpleStringProperty(examen);
        this.date = date;
        this.nom_formateur = new SimpleStringProperty(nom_formateur);
        this.description = new SimpleStringProperty(description);
    }

   public Recnote(String examen, String date, String nom_formateur,String description) {
        this.examen = new SimpleStringProperty(examen);
        this.date = date;
        this.nom_formateur = new SimpleStringProperty(nom_formateur);
        this.description = new SimpleStringProperty(description);
    }

    public int getId_reclamation() {
        return id_reclamation.get();
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation =new SimpleIntegerProperty(id_reclamation);
    }

    public String getExamen() {
        return examen.get();
    }

    public void setExamen(String examen) {
        this.examen = new SimpleStringProperty(examen);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNom_formateur() {
        return nom_formateur.get();
    }

    public void setNom_formateur(String nom_formateur) {
        this.nom_formateur = new SimpleStringProperty(nom_formateur);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }
    
    
    
    
}
