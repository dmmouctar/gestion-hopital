package com.unc.view;

import java.util.Scanner;

public class Menu {
    public static void menuPrincipal()
    {
        Scanner clavier = new Scanner(System.in);
        int choix;
        do {
            System.out.println("==== MENU PRINCIPAL ===========");
            System.out.println("[ 1.GESTION DES PATIENTS      ]");
            System.out.println("[ 2.GESTION DES MEDECINS      ]");
            System.out.println("[ 3.GESTION DES CONSULTAIONS  ]");
            System.out.println("[ 4.QUITTER                   ]");
            System.out.println("[+++++++++++++++++++++++++++++]");
            System.out.print("{## choix -> ");
            choix = clavier.nextInt();
            switch (choix)
            {
                case 1 :
                    SousMenuPatient.runPatient();
                    break;
                case 2 :
                    SousMenuMedecin.runMedecin();
                    break;
                case 3 :
                    SousMenuConsultation.runConsultation();
                    break;
                case 4 :
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }while (choix != 3);
    }
}
