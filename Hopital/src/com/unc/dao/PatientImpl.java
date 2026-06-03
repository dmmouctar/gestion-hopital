package com.unc.dao;

import com.unc.model.Patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientImpl implements IPatient{
    @Override
    public void save(Patient patient) {
        Db db = new Db();

        try {
            Connection connection = db.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO Patient(nom, prenom , date_naissance, adresse) values('"+patient.getNom()+"','"+patient.getPrenom()+"','"+patient.getDate_naissance()+"','"+patient.getAdresse()+"')");

            System.out.println("\t[ Enregistrement reussi ]");
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage()+ "]");
        }
    }

    @Override
    public Patient getPatient(int id) {
        Db db = new Db();
        Connection connection;
        ResultSet resultSet;
        Statement statement;
        try {
            connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from patient where id ="+id);
            if(resultSet.next())
                return new Patient(resultSet.getInt("id"),resultSet.getString("nom"),resultSet.getString("prenom"), resultSet.getString("date_naissance"), resultSet.getString("adresse"));
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage()+ "]");
        }
        return null;
    }

    @Override
    public List<Patient> readAll() {
        Db db = new Db();
        List<Patient> liste=new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        try {
            Connection connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from patient");
            while (resultSet.next())
            {
                liste.add(new Patient(resultSet.getInt("id"),resultSet.getString("nom"),resultSet.getString("prenom"), resultSet.getString("date_naissance"), resultSet.getString("adresse")));
            }
            statement.close();
            connection.close();
            return liste;
        }catch (Exception e){
            System.out.println("\t["+e.getMessage()+ "]");
        }
        return null;
    }

    @Override
    public void delete(Patient patient) {
        Db db = new Db();

        try {
            Connection connection = db.getConnection();
            Statement statement = connection.createStatement();
            int rep = statement.executeUpdate("delete from patient where id ="+patient.getId());
            if(rep != 0)
                System.out.println("\t[ Suppression reussie ]");
            else
                System.out.println("\t[ Aucune ligne ne correspond à l'id ("+ patient.getId()+") ]");
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage()+ "]");
        }
    }

    @Override
    public void update(Patient patient) {
        Db db = new Db();

        try {
            Connection connection = db.getConnection();
            Statement statement = connection.createStatement();
            int rep = statement.executeUpdate("update patient set nom ='"+patient.getNom()+"', prenom ='"+patient.getPrenom()+"', date_naissance='"+patient.getDate_naissance()+"', adresse='"+patient.getAdresse()+"' where id ="+patient.getId());
            if(rep != 0)
                System.out.println("\t[ Modification reussie ]");
            else
                System.out.println("\t[ Aucune ligne ne correspond à l'id ("+ patient.getId()+") ]");
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage()+ "]");
        }
    }
}
