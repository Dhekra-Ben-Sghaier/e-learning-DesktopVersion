package entity;

public class Quiz {
    private String nom;
    private String description;

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
    private String domaine;


    public Quiz(String nom, String description, String domaine) {
        this.nom = nom;
        this.description = description;
        this.domaine = domaine;
    }
    
    

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    

    
}