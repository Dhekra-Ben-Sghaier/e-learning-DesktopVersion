/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Formation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;

/**
 *
 * @author Asus
 */
public class FormationDao implements Idao<Formation>{
    
    private static FormationDao instance;
    private Statement st;
    private ResultSet rs;

    
    private FormationDao() {
        DataSource cs= DataSource.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static FormationDao getInstance(){
        if(instance==null) 
            instance=new FormationDao();
        return instance;
    }
    @Override
    public void insert(Formation o) {
        String req = "insert into formation (id,titre,description,prix,difficulte) values ('"+o.getId()+"','"+o.getTitle()+"','"+o.getDescription()
                +"','"+o.getPrix()+"','"+o.getDifficulte()+"')"; 
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Formation o) {
        String req="delete from formation where id="+o.getId();
//        Formation f =displayById(o.getId());
//        
//          if(f!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);}
//        }else System.out.println("la formation n'existe pas");
    }

    @Override
    public List<Formation> displayAll() {
        String req="select * from formation";
        ObservableList<Formation> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Formation f =new Formation();
                f.setId(rs.getInt("id"));
                f.setTitle(rs.getString("titre"));
                f.setDescription(rs.getString("description"));
                f.setPrix(rs.getFloat("prix"));
                f.setDifficulte(rs.getString("difficulte"));
                f.setCertifier(rs.getBoolean("certificat"));
                list.add(f);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Formation displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Formation f) {
        String qry = "UPDATE formation SET titre = '"+f.getTitle()+"' , description = '"+f.getDescription()+"', prix = "+f.getPrix()+" , difficulte = '"+f.getDifficulte()+"' WHERE id = "+f.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
//        public List<Formation> displayAllList() {
//        String req="select * from personne";
//        List<Formation> list=new ArrayList<>();
//        
//        try {
//            rs=st.executeQuery(req);
//            while(rs.next()){
//                Formation f =new Formation();
//                f.setId(rs.getInt(1));
//                f.setTitle(rs.getString("titre"));
//                f.setDescription(rs.getString("description"));
//                f.setPrix(rs.getFloat("prix"));
//                f.setDifficulte(rs.getString("difficulte"));
//                f.setCertifier(rs.getBoolean("certificat"));
//                
//                list.add(f);
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    
}
