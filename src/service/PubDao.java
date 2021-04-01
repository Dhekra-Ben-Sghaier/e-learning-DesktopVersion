package service;


import entity.Pub;
import java.io.InputStream;
import utils.ConnexionSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author wiemhjiri
 */
public class PubDao implements Idao<Pub>{
    
    private static PubDao instance;
    private Statement st;
    private ResultSet rs;
    
    private PubDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static PubDao getInstance(){
        if(instance==null) 
            instance=new PubDao();
        return instance;
    }
@Override
    public void insert(Pub o ,int prix) {
        String req="insert into publicité (nom,prenom,email,domaine,Affichage,Prix,lien) values ('"+o.getNom()+"','"+o.getPrenom()+"','"+o.getEmail()+"', '"+o.getDomaine()+"','"+o.getAffichage()+"','"+prix+"','"+o.getLien()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    
    @Override
    public List<Pub> displayAll() {
      String req="select * from publicité";
        ObservableList<Pub> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
              Pub p=new Pub();
                p.setId(rs.getInt(1));
               p.setNom(rs.getString(2));
                p.setPrenom(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setDomaine(rs.getString(5));
                p.setAffichage(rs.getString(6));
                 p.setPrix(rs.getInt(8));
                 p.setLien(rs.getString(9));
                

                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     *
     * @return
     */
//    @Override
//    public List<Pub> displayAll() {
//      String req="select * from publicité";
//        ObservableList<Pub> list=FXCollections.observableArrayList();       
//        
//        try {
//            rs=st.executeQuery(req);
//            while(rs.next()){
//              Pub p=new Pub();
//                p.setId(rs.getInt(1));
//               p.setNom(rs.getString(2));
//                p.setPrenom(rs.getString(3));
//                p.setEmail(rs.getString(4));
//                p.setDomaine(rs.getString(5));
//                p.setAffichage(rs.getString(6));
//                 p.setPrix(rs.getInt(8));
//                
//
//                
//                list.add(p);
//            }
            
//        } catch (SQLException ex) {
//            Logger.getLogger(PubDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list; //To change body of generated methods, choose Tools | Templates.
//    }
    
    public ArrayList displayPrixList() {
        String req="select DISTINCT Prix from publicité ORDER by Prix ASC";
        ArrayList list=new ArrayList();
        
        try {
           rs=st.executeQuery(req);
            while(rs.next()){
                Pub p=new Pub();
           
                p.setPrix(rs.getInt("Prix"));
                
                list.add(p.getPrix());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean update(Pub os) {
        String qry = "update publicité set nom = '"+os.getNom()+"' , prenom = '"+os.getPrenom()+"', email = '"+os.getEmail()+"', domaine = '"+os.getDomaine()+"' , Affichage = '"+os.getAffichage()+"',Prix = '"+os.getPrix()+"',lien='"+os.getLien()+"'  WHERE id = "+os.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    // hedheya testhakha f supprimer
     @Override
    public Pub displayById(int id) {
            String req="select * from publicité where id ="+id;
       Pub p=new Pub();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
               p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrenom(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setDomaine(rs.getString(5));
                p.setAffichage(rs.getString(6));
                p.setPrix(rs.getInt(8));
                p.setLien(rs.getString(9));
               
                //}  
        } catch (SQLException ex) {
            Logger.getLogger(PubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }
    
    

    public void delete(Pub p) {
        String req="delete from publicité where id="+p.getId();
        Pub o=displayById(p.getId());
        
          if(o!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(PubDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }
    

//    ///recupérer nbAffichage 
//    public String recNbAff (int id) {
//        String req="select Affichage from publicité where id='"+id+"'";
//      String res="";
//        try {
//            rs=st.executeQuery(req);
//            while(rs.next()){
//               res=rs.getString("Affichage");
//              return res ;
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(PubDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return res; 
//    }
//    
}
