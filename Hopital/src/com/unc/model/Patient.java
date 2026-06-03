package com.unc.model;

public class Patient {
    private int id;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String adresse;

    public Patient(int id) {

        this.id = id;
    }

    public Patient(String nom, String prenom, String dateNaissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = dateNaissance;
        this.adresse = adresse;
    }

    public Patient(int id, String nom, String prenom, String dateNaissance, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = dateNaissance;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return String.format("[ %03d  %15s  %15s  %11s  %15s]", id, nom, prenom, date_naissance, adresse );
    }
}
