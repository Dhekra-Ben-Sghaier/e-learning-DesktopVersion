package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.QuizzDao;

public class Quizz {
    private int quizID;
    private String nom;
    private String url ="jdbc:mysql://127.0.0.1/esprit";
    private String login ="root";
    private String pwd ="";
    
    

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
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
   
    @Override
    public int hashCode() {
        return Objects.hash(quizID,nom);
    }
    
    public List<Question> getQuestions(){
        List<Question> quizes = new ArrayList<>();

        String  req = "select id, question, option1, option2, option3, option4, reponse FROM questionn WHERE (idQuiz = ? ) ";
        System.out.println(req);
        try {
            Connection cnx = DriverManager.getConnection(url, login, pwd);
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, this.quizID);
            ResultSet rslt = ps.executeQuery();
            while(rslt.next()){
                Question tempQuestion = new Question();
                tempQuestion.setQuestionId(rslt.getInt(1));
                tempQuestion.setQuestion(rslt.getString(2));
                tempQuestion.setOption1(rslt.getString(3));
                tempQuestion.setOption2(rslt.getString(4));
                tempQuestion.setOption3(rslt.getString(5));
                tempQuestion.setOption4(rslt.getString(6));
                tempQuestion.setReponse(rslt.getString(7));
                tempQuestion.setQuiz(this.getQuizID());
                quizes.add(tempQuestion);
            }
        } catch (SQLException ex) {
                Logger.getLogger(QuizzDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return quizes;  
    }   
}
