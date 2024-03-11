package tn.esprit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicePersonne {
    Connection cnx;

    public ServicePersonne() {
        MyDatabase m = new MyDatabase();
        cnx = m.getCnx();
    }

    public void add(Personne p) {
        String qry = "INSERT INTO `personne`(`nom`, `prenom`, `age`) VALUES (?,?,?)";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1,p.getNom());
            pstm.setString(2,p.getPrenom());
            pstm.setInt(3,p.getAge());
            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public List<Personne> getAll() {
        ArrayList<Personne> personnes = new ArrayList<>();
            String qry ="SELECT * FROM `personne`";
        try {
            Statement stm = cnx.createStatement();
            ResultSet  rs =stm.executeQuery(qry);
            while (rs.next()){
                Personne p = new Personne();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setAge(rs.getInt("age"));
                personnes.add(p);



            }




        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return personnes;
    }


}
