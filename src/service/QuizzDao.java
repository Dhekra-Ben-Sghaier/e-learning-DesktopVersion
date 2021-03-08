package service;

import entity.Quizz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

public class QuizzDao implements Idao<Quizz> {
    
    
    private static QuizzDao instance;
    private Statement st;
    private ResultSet rs;
    
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
    
}
