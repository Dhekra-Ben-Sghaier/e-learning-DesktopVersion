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
    private String difficulté;
    private Date date;

    public Formation(int id, String title, String description, float prix, String difficulté, Date date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prix = prix;
        this.difficulté = difficulté;
        this.date = date;
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

    public String getDifficulté() {
        return difficulté;
    }

    public Date getDate() {
        return date;
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

    public void setDifficulté(String difficulté) {
        this.difficulté = difficulté;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
