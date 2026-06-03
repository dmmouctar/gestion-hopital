package com.unc.model;

import java.text.NumberFormat;

public class AffConsultation {
    private int id;
    private String nomPatient;
    private  String nomMedecin;
    private String date_consultation;
    private int frais_medicaux;

    public AffConsultation(int id) {
        this.id = id;
    }

    public AffConsultation(int id, String nomPatient, String nomMedecin, String date_consultation, int frais_medicaux) {
        this.id = id;
        this.nomPatient = nomPatient;
        this.nomMedecin = nomMedecin;
        this.date_consultation = date_consultation;
        this.frais_medicaux = frais_medicaux;
    }

    public AffConsultation(String nomPatient, String nomMedecin, String date_consultation, int frais_medicaux) {
        this.nomPatient = nomPatient;
        this.nomMedecin = nomMedecin;
        this.date_consultation = date_consultation;
        this.frais_medicaux = frais_medicaux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getDate_consultation() {
        return date_consultation;
    }

    public void setDate_consultation(String date_consultation) {
        this.date_consultation = date_consultation;
    }

    public int getFrais_medicaux() {
        return frais_medicaux;
    }

    public void setFrais_medicaux(int frais_medicaux) {
        this.frais_medicaux = frais_medicaux;
    }

    @Override
    public String toString() {

        return String.format("[ %03d  %15s %15s  %15s      %d FG", id, nomPatient, nomMedecin, date_consultation, frais_medicaux);

    }
}
