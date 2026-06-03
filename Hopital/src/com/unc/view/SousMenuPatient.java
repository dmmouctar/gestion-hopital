package com.unc.view;

import com.unc.dao.PatientImpl;
import com.unc.model.Patient;

import java.util.Scanner;

public class SousMenuPatient {
    private static Scanner clavier;
    private static PatientImpl operation;
    public static void runPatient()
    {
        operation = new PatientImpl();
        clavier = new Scanner(System.in);
        int choix;
        int id;
        Patient patient;
        String nom, prenom, date_naissance, adresse;
        do {
            System.out.println("==== Gestion des Patients ====");
            System.out.println("[   1. Ajouter             ]");
            System.out.println("[   2. Modifier            ]");
            System.out.println("[   3. Supprimer           ]");
            System.out.println("[   4. Afficher            ]");
            System.out.println("[   5. Rechercher          ]");
            System.out.println("[   6. Accueil             ]");
            System.out.println("============================");
            System.out.print("{## Votre choix -> ");
            choix=clavier.nextInt();
            switch (choix)
            {
                case 1 :
                    clavier.nextLine();
                    System.out.println("ENREGISTREMENT");
                    System.out.print("Saisir le nom du patient -> ");
                    nom = clavier.nextLine();
                    System.out.print("Saisir le prenom du patient -> ");
                    prenom = clavier.nextLine();
                    System.out.print("Donner sa date de naissance (AAAA-MM-JJ) -> ");
                    date_naissance = clavier.nextLine();
                    System.out.print("Saisir l'adresse du patient -> ");
                    adresse = clavier.nextLine();
                    operation.save(new Patient(nom,prenom,date_naissance,adresse ));
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 2 :
                    System.out.println("MODIFICATION");
                    System.out.print("Saisir l'identifiant du patient à modifier -> ");
                    id = clavier.nextInt();

                    patient = operation.getPatient(id);
                    if(patient != null)
                    {
                        clavier.nextLine();
                        System.out.print("Saisir le nouveau nom du patient -> ");
                        nom = clavier.nextLine();
                        System.out.print("Saisir le nouveau prenom du patient -> ");
                        prenom = clavier.nextLine();
                        System.out.print("Donner sa nouvelle date de naissance (AAAA-MM-JJ) -> ");
                        date_naissance = clavier.nextLine();
                        System.out.print("Saisir la nouvelle adresse du patient -> ");
                        adresse = clavier.nextLine();
                        patient.setNom(nom);
                        patient.setPrenom(prenom);
                        patient.setDate_naissance(date_naissance);
                        patient.setAdresse(adresse);
                        operation.update(patient);
                    }
                    else
                        System.out.println("Cet id n'est pas associé à un patient");
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 3 :
                    System.out.println("SUPPRIMER");
                    System.out.print("Saisir l'identifiant du patient à supprimer -> ");
                    id = clavier.nextInt();
                    operation.delete(new Patient(id));
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 4 :
                    System.out.println("LISTE DES PATIENTS");
                    operation.readAll().forEach(e-> System.out.println(e));
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 5 :
                    System.out.println("RECHERCHER");
                    System.out.print("Saisir l'identifiant du patient à rechercher -> ");
                    id = clavier.nextInt();
                    patient = operation.getPatient(id);
                    if(patient != null)
                    {
                        clavier.nextLine();
                        System.out.println("Resultat de la recherche");
                        System.out.println("Id : "+patient.getId());
                        System.out.println("Nom : "+patient.getNom());
                        System.out.println("Prenom : "+patient.getPrenom());
                        System.out.println("Date de Naissance : "+patient.getDate_naissance());
                        System.out.println("Adresse : "+patient.getAdresse());
                        System.out.println("========================");
                    }
                    else
                        System.out.println("Cet id n'est pas associé à un patient");
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 6 :
                    break;
                default:
                    System.out.println("\t[ Choix incorrect ]");

            }
        }while (choix != 6);
        Menu.menuPrincipal();
    }
}
