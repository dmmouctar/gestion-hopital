package com.unc.view;

import com.unc.dao.MedecinImpl;
import com.unc.dao.PatientImpl;
import com.unc.model.Medecin;
import com.unc.model.Patient;

import java.util.Scanner;

public class SousMenuMedecin {
    private static Scanner clavier;
    private static MedecinImpl operation;
    public static void runMedecin()
    {
        operation = new MedecinImpl();
        clavier = new Scanner(System.in);
        int choix;
        int id;
        Medecin medecin;
        String nom, prenom, specialite;
        do {

            System.out.println("==== Gestion des Medecin ====");
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
                    System.out.print("Saisir le nom du Medecin -> ");
                    nom = clavier.nextLine();
                    System.out.print("Saisir le prenom du Medecin -> ");
                    prenom = clavier.nextLine();
                    System.out.print("Saisir la specialité du Medecin -> ");
                    specialite = clavier.nextLine();

                    operation.save(new Medecin(nom,prenom,specialite ));
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 2 :
                    System.out.println("MODIFICATION");
                    System.out.print("Saisir l'identifiant du medecin à modifier -> ");
                    id = clavier.nextInt();

                    medecin = operation.getMedecin(id);
                    if(medecin != null)
                    {
                        clavier.nextLine();
                        System.out.print("Saisir le nouveau nom du Medecin -> ");
                        nom = clavier.nextLine();
                        System.out.print("Saisir le nouveau prenom du Medecin -> ");
                        prenom = clavier.nextLine();
                        System.out.print("Saisir la nouvelle specialité du Medecin -> ");
                        specialite = clavier.nextLine();
                        medecin.setNom(nom);
                        medecin.setPrenom(prenom);
                        medecin.setSpecialite(specialite);

                        operation.update(medecin);
                    }
                    else
                        System.out.println("Cet id n'est pas associé à un patient");
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 3 :
                    System.out.println("SUPPRIMER");
                    System.out.print("Saisir l'identifiant du medecin à supprimer -> ");
                    id = clavier.nextInt();
                    operation.delete(new Medecin(id));
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 4 :
                    System.out.println("LISTE DES MEDECINS");
                    operation.readAll().forEach(e-> System.out.println(e));
                    System.out.println("tapez sur Entrée pour continuer ");
                    clavier.nextLine();
                    break;
                case 5 :
                    System.out.println("RECHERCHER");
                    System.out.print("Saisir l'identifiant du medecin à rechercher -> ");
                    id = clavier.nextInt();
                    medecin = operation.getMedecin(id);
                    if(medecin != null)
                    {
                        clavier.nextLine();
                        System.out.println("Resultat de la recherche");
                        System.out.println("Id : "+medecin.getId());
                        System.out.println("Nom : "+medecin.getNom());
                        System.out.println("Prenom : "+medecin.getPrenom());
                        System.out.println("Specialité : "+medecin.getSpecialite());

                        System.out.println("========================");
                    }
                    else
                        System.out.println("Cet id n'est pas associé à un medecin");
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
