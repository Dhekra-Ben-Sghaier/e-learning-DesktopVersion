package service;

import entity.Inscription_certificat;
import entity.Question;
import entity.Quizz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;

public class QuizzDao implements Idao<Quizz> {
    
    
    private static QuizzDao instance;
    private Statement st;
    private ResultSet rs;
    private String url ="jdbc:mysql://127.0.0.1/esprit";
    private String login ="root";
    private String pwd ="";
    Quizz q ;
    
    private QuizzDao() {
        DataSource cs= DataSource.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QuizzDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static QuizzDao getInstance(){
        if(instance==null) 
            instance=new QuizzDao();
        return instance;
    }
    
    @Override
    public void insert(Quizz o) {
        String req = "insert into quizz (nom) values ('"+o.getNom()+"')"; 
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(QuizzDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(Quizz o) {
//        String req="delete from quizz where quizID="+o.getNom();
//        Quizz p=displayById(o.getQuizID());
//        
//          if(p!=null)
//              try {
//           
//            st.executeUpdate(req);
//             
//        } catch (SQLException ex) {
//            Logger.getLogger(QuizzDao.class.getName()).log(Level.SEVERE, null, ex);
//        }else System.out.println("n'existe pas");
    }

    @Override
    public List<Quizz> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Quizz displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Quizz os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 

    public int retoutnerID(Quizz a) {
          String req="SELECT quizID FROM quizz \n" +
                    " WHERE nom = '"+a.getNom()+"'";  
          int resu=0;
        try {

            rs=st.executeQuery(req);
            while(rs.next()){
                Quizz q = new Quizz ();
               
                      q.setQuizID(rs.getInt("quizID"));
                      resu=q.getQuizID();
                      //System.out.println("resu="+resu);
                      return resu;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuizzDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resu;
    }
    
    public Map <Quizz, List<Question>>  getAll(){
        Map <Quizz, List<Question>> quizes = new HashMap<>();
        Quizz key = null;       
        
        String  req = "select quizz.quizID, nom, id, question, option1, option2,"
                + "option3, option4, reponse from quizz JOIN questionn ON questionn.idQuiz = quizz.quizID";
        System.out.println(req);
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Quizz temp = new Quizz();
                temp.setQuizID(rs.getInt(1));
                temp.setNom(rs.getString(2));
                
                Question tempQuestion = new Question();
                tempQuestion.setQuestionId(rs.getInt(3));
                tempQuestion.setQuestion(rs.getString(4));
                tempQuestion.setOption1(rs.getString(5));
                tempQuestion.setOption2(rs.getString(6));
                tempQuestion.setOption3(rs.getString(7));
                tempQuestion.setOption3(rs.getString(8));
                tempQuestion.setReponse(rs.getString(9));  

                if (key!= null && key.equals(temp)){
                    quizes.get(key).add(tempQuestion);
                }else{
                    ArrayList<Question> value = new ArrayList<>();
                    value.add(tempQuestion);
                    quizes.put(key, value); 
                }
                key= temp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizzDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return quizes;
    }
    public Map <Quizz, Integer> compterNombreQuestions(){
        Map <Quizz, Integer> quizes = new HashMap<>();
        Quizz key = null;       
        
        String  req = "SELECT nom,quizz.quizID,\n" +
                            "count(*) AS question_count FROM quizz\n" +
                            "INNER JOIN questionn ON \n" +
                            "quizz.quizID = questionn.idQuiz\n" +
                            "GROUP BY quizz.quizID";
        System.out.println(req);
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Quizz temp = new Quizz();                
                temp.setNom(rs.getString(1));
                temp.setQuizID(rs.getInt(2));
                int count = rs.getInt(3);
                quizes.put(temp, count);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizzDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return quizes;
    }
    public Map <Quizz,String>  retoutnerNom(){
        Map <Quizz,String> quizes = new HashMap<>();
        Quizz key = null;   
        String nomq = null;

        
        String req="select nom FROM quizz INNER JOIN questionn ON quizz.quizID = questionn.idQuiz ";
    System.out.println(req);
    try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Quizz temp = new Quizz();
                temp.setNom(rs.getString(1));
                quizes.put(temp, nomq);  
                


                
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizzDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return quizes;
    }

   
    
}
