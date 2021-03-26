/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Formation {
    private int id;
    private String title;
    private String description;
    private float prix;
    private String difficulte;
    private boolean certifier;
    private byte[] pdf;
    private String path;
    private String pathImg;
    
    
    public Formation() {
    }
    
    public Formation(int id, String title, String description, float prix, String difficulté, boolean certifier) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prix = prix;
        this.difficulte = difficulté;
        this.certifier = certifier;
    }

    public Formation(int id, String title, String description, float prix, String difficulte, String path) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prix = prix;
        this.difficulte = difficulte;
        this.path = path;
    }

    public Formation(int id, String title, String description, float prix, String difficulte, String path, String pathImg) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prix = prix;
        this.difficulte = difficulte;
        this.path = path;
        this.pathImg = pathImg;
    }
    

    public Formation(int id, String title, String description, float prix, String difficulte, boolean certifier, String path, String pathImg) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prix = prix;
        this.difficulte = difficulte;
        this.certifier = certifier;
        this.path = path;
        this.pathImg = pathImg;
    }

    
    
    public Formation(int id, String title, String description, float prix, String difficulte, byte[] pdf) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prix = prix;
        this.difficulte = difficulte;
        this.pdf = pdf;
    }
    
    public Formation(int id, String title, String description, float prix, String difficulte, boolean certifier, byte[] pdf) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prix = prix;
        this.difficulte = difficulte;
        this.certifier = certifier;
        this.pdf = pdf;
    }
    

    public String getDifficulte() {
        return difficulte;
    }

    public Formation(int id, String title, String description, float prix, String difficulte) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prix = prix;
        this.difficulte = difficulte;
 
    }

    public boolean isCertifier() {
        return certifier;
    }

    public void setCertifier(boolean certifier) {
        this.certifier = certifier;
    }

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }

   



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }




    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }


       @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", title=" + title + ", description=" + description + ", prix=" + prix + ", difficulte=" + difficulte + ", certifier=" + certifier + '}';
    }
 
    
    
}
