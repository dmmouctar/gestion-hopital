package com.unc.model;

public class Consultation {
    private int id;
    private int id_patient;
    private  int id_medecin;
    private String date_consultation;
    private int frais_medicaux;

    public Consultation(int id) {
        this.id = id;
    }

    public Consultation(int id_patient, int id_medecin, String date_consultation, int frais_medicaux) {
        this.id_patient = id_patient;
        this.id_medecin = id_medecin;
        this.date_consultation = date_consultation;
        this.frais_medicaux = frais_medicaux;
    }

    public Consultation(int id, int id_patient, int id_medecin, String date_consultation, int frais_medicaux) {
        this.id = id;
        this.id_patient = id_patient;
        this.id_medecin = id_medecin;
        this.date_consultation = date_consultation;
        this.frais_medicaux = frais_medicaux;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    public String getDate_consultation() {
        return date_consultation;
    }

    public void setDate_consultation(String date_consultation) {
        this.date_consultation = date_consultation;
    }

    public double getFrais_medicaux() {
        return frais_medicaux;
    }

    public void setFrais_medicaux(int frais_medicaux) {
        this.frais_medicaux = frais_medicaux;
    }

    @Override
    public String toString() {
        return String.format("[ %03d  %03d %03d  %15s %03d", id, id_patient, id_medecin, date_consultation, frais_medicaux);
    }
}
