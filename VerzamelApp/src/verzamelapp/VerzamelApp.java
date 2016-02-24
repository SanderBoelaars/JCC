/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Sander
 */
public class VerzamelApp {

    /**
     * @param args the command line arguments
     */
    private static String answer;

    public static void main(String[] args) {
        ShowMenu();
        MenuInteractie();
    }

    private static void ShowMenu() {
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
        Answer();
    }

    private static String Answer() {
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
        System.out.println("Nieuwe Postzegel");
        System.out.println("Postzegel lengte (mm):");
        String lengte = Answer();
        System.out.println("Postzegel breedte (mm):");
        String breedte = Answer();
        Postzegel postzegel = new Postzegel(Integer.parseInt(lengte), Integer.parseInt(breedte));
        System.out.println("De postzegel is toegevoegd.");
        System.out.println("-------------------------------------");
        ShowMenu();
    }

    private static void NieuweBierdop() {
        System.out.println("-------------------------------------");
        System.out.println("Nieuwe Bierdop");
        System.out.println("Bierdop merk:");
        String merk = Answer();
        Bierdop bierdop = new Bierdop(merk);
        System.out.println("Bierdop is toegevoegd.");
        System.out.println("-------------------------------------");
        ShowMenu();
    }

    private static void NieuweSet() {
        System.out.println("-------------------------------------");
        System.out.println("Nieuwe Set");
        System.out.println("Set naam:");
        String naam = Answer();
        System.out.println("Set jaartal:");
        String jaartal = Answer();
        Set set = new Set(naam, Integer.parseInt(jaartal));
        System.out.println("Set is toegevoegd.");
        System.out.println("-------------------------------------");
        ShowMenu();
    }

    private static void VerwijderPostzegel() {
        System.out.println("-------------------------------------");
        System.out.println("Verwijder Postzegel");
        
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

    }
}
