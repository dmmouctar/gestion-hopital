package com.unc.dao;

import com.unc.model.AffConsultation;
import com.unc.model.Consultation;
import com.unc.model.Medecin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultationImpl implements IConsultation{
    @Override
    public void save(Consultation consultation) {
        Db db = new Db();

        try {
            Connection connection = db.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO Consultation(id_patient, id_medecin,date_consultation,frais_medicaux ) values("+consultation.getId_patient()+","+consultation.getId_medecin()+",'"+consultation.getDate_consultation()+"',"+consultation.getFrais_medicaux()+")");

            System.out.println("\t[ Enregistrement reussi 👌]");
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage());
        }
    }

    @Override
    public Consultation getConsultation(int id) {
        Db db = new Db();
        Connection connection;
        ResultSet resultSet;
        Statement statement;
        try {
            connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from consultation where id ="+id);
            if(resultSet.next())
                return (new Consultation(resultSet.getInt("id_patient"), resultSet.getInt("id_medecin"),resultSet.getString("date_consultation"),resultSet.getInt("frais_medicaux")));
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage());
        }
        return null;
    }

    @Override
    public List<AffConsultation> readAll() {
        Db db = new Db();
        List<AffConsultation> liste=new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        try {
            Connection connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select consultation.id ,concat(patient.nom ,' ', patient.prenom) as patient, concat(medecin.nom ,' ', medecin.prenom) as medecin, consultation.date_consultation, consultation.frais_medicaux from patient, medecin , consultation where patient.id=consultation.id_patient and medecin.id = consultation.id_medecin");
            while (resultSet.next())
            {
                liste.add(new AffConsultation(resultSet.getInt("id"), resultSet.getString("patient"), resultSet.getString("medecin"),resultSet.getString("date_consultation"),resultSet.getInt("frais_medicaux")));
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
    public void delete(Consultation consultation) {
        Db db = new Db();

        try {
            Connection connection = db.getConnection();
            Statement statement = connection.createStatement();
            int rep = statement.executeUpdate("delete from consultation where id ="+consultation.getId());
            if(rep != 0)
                System.out.println("\t[ Suppression reussie ]");
            else
                System.out.println("\t[ Aucune ligne ne correspond à l'id ("+ consultation.getId()+") ]");
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage());
        }
    }

    @Override
    public void update(Consultation consultation) {
        Db db = new Db();

        try {
            Connection connection = db.getConnection();
            Statement statement = connection.createStatement();
            int rep = statement.executeUpdate("update consultation set id_patient ='"+consultation.getId_patient()+", id_medecin ="+consultation.getId_medecin()+",date_consultation ='"+consultation.getDate_consultation()+"',frais_madicaux ="+consultation.getFrais_medicaux()+"' where id ="+consultation.getId());
            if(rep != 0)
                System.out.println("\t[ Modification reussie ]");
            else
                System.out.println("\t[ Aucune ligne ne correspond à l'id ("+ consultation.getId()+") ]");
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\t["+e.getMessage());
        }
    }
}
