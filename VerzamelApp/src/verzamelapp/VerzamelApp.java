/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
        showMenu();

    }

    private static void showMenu() {
        System.out.println("-------------------------------------");
        System.out.println("Menu (kies een optie):");
        System.out.println("[1] Nieuwe postzegel");
        System.out.println("[2] Nieuwe bierdop");
        System.out.println("[3] Nieuwe set");
        System.out.println("[4] verwijder voorwerp");
        System.out.println("[5] Verwijder set");
        System.out.println("[6] Sorteer collectie");
        System.out.println("[7] Aflsuiten");
        input();
        menuInteractie();
    }

    private static String input() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            answer = input.readLine();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
        }
        return answer;
    }

    private static void menuInteractie() {
        if (answer != null) {
            switch (answer) {
                case "1":
                    nieuwePostzegel();
                    break;
                case "2":
                    nieuweBierdop();
                    break;
                case "3":
                    nieuweSet();
                    break;
                case "4":
                    verwijderVoorwerp();
                    break;
                case "5":
                    verwijderSet();
                    break;
                case "6":
                    sorteer();
                    break;
                case "7":
                    exit();
                    break;
                default:
                    break;
            }
        }
    }

    private static void nieuwePostzegel() {
        try {
            System.out.println("-------------------------------------");
            System.out.println("Nieuwe postzegel (kies een set):");
            if (sets.isEmpty()) {
                System.out.println("Geen set beschikbaar om deze postzegel aan toe te voegen.");
                showMenu();
            }
            int counter = 1;
            for (Set set : sets) {
                System.out.println("[" + counter + "] " + set.getNaam() + " uit " + set.getJaartal());
                counter++;
            }
            int index = Integer.parseInt(input());
            Set set = sets.get(index - 1);

            System.out.println("Postzegel naam:");
            String naam = input();
            System.out.println("Postzegel lengte (mm):");
            String lengte = input();
            System.out.println("Postzegel breedte (mm):");
            String breedte = input();

            Postzegel postzegel = new Postzegel(naam, Integer.parseInt(lengte), Integer.parseInt(breedte));
            voorwerpen.add(postzegel);
            set.addVoorwerp(postzegel);
            System.out.println("De postzegel is toegevoegd.");
            showMenu();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            error();
        }
    }

    private static void nieuweBierdop() {
        try {
            System.out.println("-------------------------------------");
            System.out.println("Nieuwe bierdop (kies een set):");
            if (sets.isEmpty()) {
                System.out.println("Geen set beschikbaar om deze bierdop aan toe te voegen.");
                showMenu();
            }
            int counter = 1;
            for (Set set : sets) {
                System.out.println("[" + counter + "] " + set.getNaam() + " uit " + set.getJaartal());
                counter++;
            }
            int index = Integer.parseInt(input());
            Set set = sets.get(index - 1);

            System.out.println("Bierdop naam:");
            String naam = input();
            System.out.println("Bierdop merk:");
            String merk = input();

            Bierdop bierdop = new Bierdop(naam, merk);
            voorwerpen.add(bierdop);
            set.addVoorwerp(bierdop);
            System.out.println("Bierdop is toegevoegd.");
            showMenu();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            error();
        }
    }

    private static void nieuweSet() {
        try {
            System.out.println("-------------------------------------");
            System.out.println("Nieuwe set");
            System.out.println("Set naam:");
            String naam = input();
            System.out.println("Set jaartal:");
            String jaartal = input();
            Set set = new Set(naam, Integer.parseInt(jaartal));
            sets.add(set);
            System.out.println("Set is toegevoegd.");
            showMenu();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            error();
        }
    }

    private static void verwijderVoorwerp() {
        try {
            System.out.println("-------------------------------------");
            System.out.println("Verwijder voorwerp uit set (kies een set):");
            if (sets.isEmpty()) {
                System.out.println("Geen set beschikbaar om een voorwerp uit te verwijderen.");
                showMenu();
            }
            int counter = 1;
            for (Set set : sets) {
                System.out.println("[" + counter + "] " + set.getNaam() + " uit " + set.getJaartal());
                counter++;
            }
            System.out.println("[" + counter + "] Terug naar hoofdmenu");
            int index = Integer.parseInt(input());
            Set set = sets.get(index - 1);
            System.out.println("Verwijder voorwerp:");
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
            System.out.println("[" + counter2 + "] Terug naar hoofdmenu");
            int index2 = Integer.parseInt(input());
            Voorwerp voorwerp = set.getVoorwerpen().remove(index2 - 1);
            voorwerpen.remove(voorwerp);
            System.out.println("Voorwerp is verwijderd.");
            showMenu();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            error();
        }
    }

    private static void verwijderSet() {
        try {
            System.out.println("-------------------------------------");
            System.out.println("Verwijder s"
                    + ""
                    + "et en bijbehorende voorwerpen (kies een set):");
            if (sets.isEmpty()) {
                System.out.println("Geen set beschikbaar om te verwijderen.");
                showMenu();
            }
            int counter = 1;
            for (Set set : sets) {
                System.out.println("[" + counter + "] " + set.getNaam() + " uit " + set.getJaartal());
                counter++;
            }
            System.out.println("[" + counter + "] Terug naar hoofdmenu");
            int index = Integer.parseInt(input());
            Set set = sets.get(index - 1);
            Voorwerp voorwerp = null;
            for (Voorwerp vw : set.getVoorwerpen()) {
                for (Voorwerp vw2 : voorwerpen) {
                    if (vw2.equals(vw)) {
                        voorwerp = vw2;
                    }
                }
            }
            voorwerpen.remove(voorwerp);
            sets.remove(set);
            System.out.println("Set is verwijderd.");
            showMenu();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            error();
        }
    }

    private static void sorteer() {
        try {
            System.out.println("-------------------------------------");
            System.out.println("Sorteer collectie:");
            if (voorwerpen.isEmpty()) {
                System.out.println("Geen voorwerpen beschikbaar om te sorteren.");
                showMenu();
            }
            System.out.println("[1] Sorteer gehele collectie.");
            System.out.println("[2] Sorteer postzegels.");
            System.out.println("[3] Terug naar hoofdmenu.");
            String string = input();
            if (string.equals("1")) {
                sorteerVoorwerpen();
            } else if (string.equals("2")) {
                sorteerPostzegels();
            } else if (string.equals("3")) {
                showMenu();
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            error();
        }
    }

    private static void sorteerVoorwerpen() {
        try {
            System.out.println("-------------------------------------");
            System.out.println("Voorwerpen (gesorteerd op jaartal):");
            if (voorwerpen.isEmpty()) {
                System.out.println("Geen voorwerpen beschikbaar.");
                showMenu();
            }
            Collections.sort(sets);
            int counter = 1;
            for (Set set : sets) {
                if (set.getVoorwerpen().isEmpty() == false) {
                    for (Voorwerp voorwerp : set.getVoorwerpen()) {
                        if (voorwerp instanceof Postzegel) {
                            Postzegel postzegel = (Postzegel) voorwerp;
                            System.out.println("Postzegel: " + counter + ". " + postzegel.getNaam() + " (" + postzegel.getBreedte() + "/" + postzegel.getLengte() + ") uit " + set.getNaam() + "(" + set.getJaartal() + ")");
                            counter++;
                        } else if (voorwerp instanceof Bierdop) {
                            Bierdop bierdop = (Bierdop) voorwerp;
                            System.out.println("Bierdop: " + counter + ". " + bierdop.getNaam() + " (" + bierdop.getMerk() + ") uit " + set.getNaam() + "(" + set.getJaartal() + ")");
                            counter++;
                        }
                    }
                }
            }
            System.out.println("[1] Terug naar menu.");
            String string = input();
            if (string.equals("1")) {
                showMenu();
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            error();
        }
    }

    private static void sorteerPostzegels() {
        try {
            System.out.println("-------------------------------------");
            System.out.println("Postzegels (gesorteerd op grootte):");
            if (voorwerpen.isEmpty()) {
                System.out.println("Geen voorwerpen beschikbaar.");
                showMenu();
            }
            ArrayList<Postzegel> collectie = new ArrayList<Postzegel>();

            for (Voorwerp vw : voorwerpen) {
                if (vw instanceof Postzegel) {
                    Postzegel postzegel = (Postzegel) vw;
                    collectie.add(postzegel);
                }
            }
            Collections.sort(collectie);
            int counter2 = 1;
            for (Postzegel postzegel : collectie) {
                System.out.println("Postzegel: " + counter2 + ". " + postzegel.getNaam() + " (" + postzegel.getBreedte() + "/" + postzegel.getLengte() + ")");
                counter2++;
            }
            System.out.println("[1] Terug naar menu.");
            String string = input();
            if (string.equals(
                    "1")) {
                showMenu();
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            error();
        }
    }

    private static void exit() {
        System.out.println("-------------------------------------");
        System.out.println("Afsluiten");
        System.exit(0);
    }

    private static void error() {
        System.out.println("-------------------------------------");
        System.out.println("Er is een fout opgetreden.");
        showMenu();
    }
}
