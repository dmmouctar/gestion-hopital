package com.unc.view;

import com.unc.dao.ConsultationImpl;
import com.unc.dao.MedecinImpl;
import com.unc.model.Consultation;
import com.unc.model.Medecin;

import java.util.Scanner;

public class SousMenuConsultation {
    private static Scanner clavier;
    private static ConsultationImpl operation;
    public static void runConsultation()
    {
        operation = new ConsultationImpl();
        clavier = new Scanner(System.in);
        int choix;
        int id;
        Consultation consultation;
        int id_patient, id_medecin, frais_medicaux;
        String date_consultation;
        do {

            System.out.println("==== Gestion des Consultations ====");
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
                    System.out.print("Saisir l'identifiant du patient' → ");
                    id_patient = clavier.nextInt();
                    System.out.print("Saisir l'identifiant du medecin' → ");
                    id_medecin = clavier.nextInt();
                    clavier.nextLine();
                    System.out.print("Saisir la date de consultation → ");
                    date_consultation = clavier.nextLine();
                    System.out.print("Saisir les frais medicaux du patient → ");
                    frais_medicaux = clavier.nextInt();

                    operation.save(new Consultation(id_patient,id_medecin, date_consultation, frais_medicaux));
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 2 :
                    System.out.println("MODIFICATION");
                    System.out.print("Saisir l'identifiant de la consultation à modifier -> ");
                    id = clavier.nextInt();

                    consultation = operation.getConsultation(id);
                    if(consultation != null)
                    {
                        clavier.nextLine();
                        System.out.print("Saisir le nouveau id du patient' → ");
                        id_patient = clavier.nextInt();
                        System.out.print("Saisir le nouveau id du medecin' → ");
                        id_medecin = clavier.nextInt();
                        System.out.print("Saisir la nouvelle date de consultation → ");
                        date_consultation = clavier.nextLine();
                        System.out.print("Saisir les nouveaux frais medicaux du patient → ");
                        frais_medicaux = clavier.nextInt();
                        consultation.setId_patient(id_patient);
                        consultation.setId_medecin(id_medecin);
                        consultation.setDate_consultation(date_consultation);
                        consultation.setFrais_medicaux(frais_medicaux);
                    operation.update(consultation);
                    }
                    else
                        System.out.println("Cet id n'est pas associé à une consultation");
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 3 :
                    System.out.println("SUPPRIMER");
                    System.out.print("Saisir l'identifiant de la consultation à supprimer -> ");
                    id = clavier.nextInt();
                    operation.delete(new Consultation(id));
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 4 :
                    System.out.println("LISTE DES CONSULTATIONS");
                    operation.readAll().forEach(e-> System.out.println(e));
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 5 :
                    System.out.println("RECHERCHER");
                    System.out.print("Saisir l'identifiant de la consultation à rechercher -> ");
                    id = clavier.nextInt();
                    consultation = operation.getConsultation(id);
                    if(consultation != null)
                    {
                        clavier.nextLine();
                        System.out.println("Resultat de la recherche");
                        System.out.println("Id_patient : "+consultation.getId_patient());
                        System.out.println("Id_medecin : "+consultation.getId_medecin());
                        System.out.println("Date de consultation : "+consultation.getDate_consultation());
                        System.out.println("Frais medicaux : "+consultation.getFrais_medicaux());

                        System.out.println("========================");
                    }
                    else
                        System.out.println("Cet id n'est pas associé à une consultation");
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
