package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;


public class Utilisateur {
    
    private String url ="jdbc:mysql://127.0.0.1/esprit";
    private String login ="root";
    private String pwd ="";
    
    private int ID;
    private String Nom;
    private String prenom;
    
    
    public Utilisateur() {
        
    }

    public Utilisateur(String Nom, String prenom) {
        this.Nom = Nom;
        this.prenom = prenom;
    }
    

    public Utilisateur(int ID, String Nom, String prenom) {
        this.ID = ID;
        this.Nom = Nom;
        this.prenom = prenom;
    }
    
    public int getID() {
        return ID;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    //enregistrer utilisateur 
    public boolean save(){
        String req = "INSERT INTO utilisateur (nom, prenom) VALUES (?,?)"; 
        try {
            Connection cnx = DriverManager.getConnection(url, login, pwd);
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, this.Nom);
            ps.setString(2, this.prenom);
            int i = ps.executeUpdate();
            System.out.println("Updated rows " +i);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
  
}
