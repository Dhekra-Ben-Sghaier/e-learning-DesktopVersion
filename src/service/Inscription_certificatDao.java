package service;

import entity.Inscription_certificat;
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


public class Inscription_certificatDao implements Idao<Inscription_certificat>{
    
    private static Inscription_certificatDao instance;
    private Statement st;
    private ResultSet rs;
    
    private Inscription_certificatDao() {
        DataSource cs= DataSource.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Inscription_certificatDao getInstance(){
        if(instance==null) 
            instance=new Inscription_certificatDao();
        return instance;
    }
    
    @Override
    public void insert(Inscription_certificat o) {
        String req = "insert into inscri_certif (nom_utilisateur,nom_certificat,description,domaine) values ('"+o.getNomUtilisateur()+"','"+o.getNom()+"','"+o.getDescription()+"','"+o.getDomaine()+"')"; 
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Inscription_certificat o) {
        String req="delete from inscri_certif where id_inscri="+o.getId();
//        Formation f =displayById(o.getId());
//        
//          if(f!=null)
              try {           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);}
//        }else System.out.println("la formation n'existe pas");
    }

    @Override
    public List<Inscription_certificat> displayAll() {
        String req="select * from inscri_certif";
        ObservableList<Inscription_certificat> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Inscription_certificat f =new Inscription_certificat();
                f.setId(rs.getInt("id_inscri"));
                f.setNomUtilisateur(rs.getString("nom_utilisateur"));
                f.setNom(rs.getString("nom_certificat"));
                f.setDescription(rs.getString("description"));
                f.setDomaine(rs.getString("domaine"));
                list.add(f);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Inscription_certificat displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Inscription_certificat os) {
        String qry = "update inscri_certif set nom_utilisateur = '"+os.getNomUtilisateur()+"' , nom_certificat = '"+os.getNom()+"', description = '"+os.getDescription()+"', domaine = '"+os.getDomaine()+"'  WHERE id_inscri = "+os.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
 
}
