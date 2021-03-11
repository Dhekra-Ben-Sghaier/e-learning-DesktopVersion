 
package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Alert;
import service.QuizzDao;

public class Quizz {
    private int quizID;
    private String nom;
    
    public static class MetaData{
        public static final String TABLE_NAME = "quizs";
        public static final String QUIZ_ID = "quiz_id";
        public static final String NOM = "nom";
    }

    public Quizz(int quizID, String nom) {
        this.quizID = quizID;
        this.nom = nom;
    }
    
    public Quizz() {
    }
    
    public Quizz(String nom) {
        this.nom = nom;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }


    @Override
    public String toString() {
        return "Quizz{" + ", nom=" + nom + '}';
    }

    

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    public String getNom() {
        return nom;
    }
//    public int save()
//    {
        
        
//            Quizz f = new Quizz (nomQuiz.getText());
//            QuizzDao Q = QuizzDao.getInstance();
//            Q.insert(f);
//            
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Information Dialog");
//            alert.setHeaderText(null);
//            alert.setContentText("Nom Quiz ajouté avec succés!");
//            alert.show();
//            nomQuiz.setText("");
//            System.out.println("ok");
//        try{
//                
//            String raw= "insert into %s (%s) values (?)";
//            String query= String.format(raw, Quizz.MetaData.TABLE_NAME, Quizz.MetaData.NOM);
//            String connectionUrl="\"jdbc:mysql://127.0.0.1/esprit\"";
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(connectionUrl);
//            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            //ps.setString(1, this.nom);
//            int i = ps.executeUpdate();
//            ResultSet keys= ps.getGeneratedKeys();
//            if (keys.next())
//                {
//                    return keys.getInt(1);
//                }
//            
//            
//            
//            
//            
//        }
//        catch(Exception ex){
//            ex.printStackTrace(); 
//            return -1;
//        }
//        
//        return -1;

//    }
    
}
