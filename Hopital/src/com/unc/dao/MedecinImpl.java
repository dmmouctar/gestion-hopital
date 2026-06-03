package com.unc.dao;

import com.unc.model.Medecin;
import com.unc.model.Patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedecinImpl implements IMedecin{
    @Override
    public void save(Medecin medecin) {
        Db db = new Db();

        try {
            Connection connection = db.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO Medecin(nom, prenom,specialite ) values('"+medecin.getNom()+"','"+medecin.getPrenom()+"','"+medecin.getSpecialite()+"')");

            System.out.println("\t[ Enregistrement reussi ]");
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage());
        }
    }

    @Override
    public Medecin getMedecin(int id) {
        Db db = new Db();
        Connection connection;
        ResultSet resultSet;
        Statement statement;
        try {
            connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from medecin where id ="+id);
            if(resultSet.next())
                return new Medecin(resultSet.getInt("id"),resultSet.getString("nom"),resultSet.getString("prenom"), resultSet.getString("specialite"));
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Medecin> readAll() {
        Db db = new Db();
        List<Medecin> liste=new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        try {
            Connection connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from medecin");
            while (resultSet.next())
            {
                liste.add(new Medecin(resultSet.getInt("id"),resultSet.getString("nom"),resultSet.getString("prenom"), resultSet.getString("specialite")));
            }
            statement.close();
            connection.close();
            return liste;
        }catch (Exception e){
            System.out.println("\t["+e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(Medecin medecin) {
        Db db = new Db();

        try {
            Connection connection = db.getConnection();
            Statement statement = connection.createStatement();
            int rep = statement.executeUpdate("delete from medecin where id ="+medecin.getId());
            if(rep != 0)
                System.out.println("\t[ Suppression reussie ]");
            else
                System.out.println("\t[ Aucune ligne ne correspond à l'id ("+ medecin.getId()+") ]");
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage());
        }
    }

    @Override
    public void update(Medecin medecin) {
        Db db = new Db();

        try {
            Connection connection = db.getConnection();
            Statement statement = connection.createStatement();
            int rep = statement.executeUpdate("update medecin set nom ='"+medecin.getNom()+"', prenom ='"+medecin.getPrenom()+"', specialite='"+medecin.getSpecialite()+"' where id ="+medecin.getId());
            if(rep != 0)
                System.out.println("\t[ Modification reussie ]");
            else
                System.out.println("\t[ Aucune ligne ne correspond à l'id ("+ medecin.getId()+") ]");
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage());
        }
    }
}
