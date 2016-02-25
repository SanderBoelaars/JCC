/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import verzamelapp.Set;
import verzamelapp.Voorwerp;

/**
 *
 * @author Sander
 */
public class VerzamelApp {

    /**
     * @param args the command line arguments
     */
    private static String answer;

    private static ArrayList<Set> sets;
    private static ArrayList<Voorwerp> voorwerpen;

    public static void main(String[] args) {
        sets = new ArrayList<Set>();
        voorwerpen = new ArrayList<Voorwerp>();
        ShowMenu();

    }

    private static void ShowMenu() {
        System.out.println("-------------------------------------");
        System.out.println("Menu (kies een optie):");
        System.out.println("[1] Nieuwe postzegel");
        System.out.println("[2] Nieuwe bierdop");
        System.out.println("[3] Nieuwe set");
        System.out.println("[4] verwijder postzegel");
        System.out.println("[5] Verwijder bierdop");
        System.out.println("[6] Verwijder set");
        System.out.println("[7] Sorteer voorwerpen");
        System.out.println("[8] Sorteer postzegels");
        System.out.println("[9] Exit");
        Input();
        MenuInteractie();
    }

    private static String Input() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            answer = input.readLine();
        } catch (Exception e) {
        }
        return answer;
    }

    private static void MenuInteractie() {
        if (answer != null) {
            switch (answer) {
                case "1":
                    NieuwePostzegel();
                    break;
                case "2":
                    NieuweBierdop();
                    break;
                case "3":
                    NieuweSet();
                    break;
                case "4":
                    VerwijderPostzegel();
                    break;
                case "5":
                    VerwijderBierdop();
                    break;
                case "6":
                    VerwijderSet();
                    break;
                case "7":
                    SorteerVoorwerpen();
                    break;
                case "8":
                    SorteerPostzegels();
                    break;
                case "9":
                    Exit();
                    break;
            }
        }
    }

    private static void NieuwePostzegel() {
        System.out.println("-------------------------------------");
        if (sets.isEmpty()) {
            System.out.println("Geen set beschikbaar om deze postzegel aan toe te voegen.");
            ShowMenu();
        }
        int counter = 1;
        for (Set set : sets) {
            System.out.println("[" + counter + "] " + set.getNaam() + " uit " + set.getJaartal());
            counter++;
        }
        int index = Integer.parseInt(Input());
        Set set = sets.get(index - 1);

        System.out.println("Nieuwe Postzegel");
        System.out.println("Postzegel naam:");
        String naam = Input();
        System.out.println("Postzegel lengte (mm):");
        String lengte = Input();
        System.out.println("Postzegel breedte (mm):");
        String breedte = Input();

        Postzegel postzegel = new Postzegel(naam, Integer.parseInt(lengte), Integer.parseInt(breedte));
        voorwerpen.add(postzegel);
        set.AddVoorwerp(postzegel);
        System.out.println("De postzegel is toegevoegd.");
        ShowMenu();
    }

    private static void NieuweBierdop() {
        System.out.println("-------------------------------------");
        if (sets.isEmpty()) {
            System.out.println("Geen set beschikbaar om deze bierdop aan toe te voegen.");
            ShowMenu();
        }
        int counter = 1;
        for (Set set : sets) {
            System.out.println("[" + counter + "] " + set.getNaam() + " uit " + set.getJaartal());
            counter++;
        }
        int index = Integer.parseInt(Input());
        Set set = sets.get(index - 1);

        System.out.println("Nieuwe Bierdop");
        System.out.println("Bierdop naam:");
        String naam = Input();
        System.out.println("Bierdop merk:");
        String merk = Input();

        Bierdop bierdop = new Bierdop(naam, merk);
        voorwerpen.add(bierdop);
        set.AddVoorwerp(bierdop);
        System.out.println("Bierdop is toegevoegd.");
        ShowMenu();
    }

    private static void NieuweSet() {
        System.out.println("-------------------------------------");
        System.out.println("Nieuwe Set");
        System.out.println("Set naam:");
        String naam = Input();
        System.out.println("Set jaartal:");
        String jaartal = Input();
        Set set = new Set(naam, Integer.parseInt(jaartal));
        sets.add(set);
        System.out.println("Set is toegevoegd.");
        ShowMenu();
    }

    private static void VerwijderPostzegel() {
        System.out.println("-------------------------------------");
        System.out.println("Verwijder Postzegel");
        System.out.println("Kies een set om een voorwerp te verwijderen");

        int counter = 1;
        for (Set set : sets) {
            System.out.println("[" + counter + "] " + set.getNaam() + " uit " + set.getJaartal());
            counter++;
        }
        int index = Integer.parseInt(Input());
        Set set = sets.get(index - 1);

        int counter2 = 1;
        for (Voorwerp voorwerp : set.getVoorwerpen()) {
            if (voorwerp instanceof Postzegel) {
                Postzegel postzegel = (Postzegel) voorwerp;
                System.out.println("[" + counter2 + "] " + postzegel.getNaam() + " (" + postzegel.getBreedte() + "/" + postzegel.getLengte() + ")");
                counter2++;
            } else if (voorwerp instanceof Bierdop) {
                Bierdop bierdop = (Bierdop) voorwerp;
                System.out.println("[" + counter2 + "] " + bierdop.getNaam() + " (" + bierdop.getMerk() + ")");
                counter2++;
            }
        }
        int index2 = Integer.parseInt(Input());
        Voorwerp voorwerp = set.getVoorwerpen().remove(index2-1);
        voorwerpen.remove(voorwerp);
        System.out.println("Voorwerp is verwijderd.");
        ShowMenu();
    }

    private static void VerwijderBierdop() {

    }

    private static void VerwijderSet() {

    }

    private static void SorteerVoorwerpen() {

    }

    private static void SorteerPostzegels() {

    }

    private static void Exit() {
        System.exit(0);
    }
}
