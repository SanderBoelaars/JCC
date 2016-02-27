/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

    public static void main(String[] args) {
        sets = new ArrayList();
        
        ShowMenu();
        MenuInteractie();
    }

    private static void ShowMenu() {
        System.out.println("Menu (kies een optie):");
        System.out.println("[1] Nieuwe postzegel");
        System.out.println("[2] Nieuwe bierdop");
        System.out.println("[3] Nieuwe set");
        System.out.println("[4] Verwijder postzegel");
        System.out.println("[5] Verwijder bierdop");
        System.out.println("[6] Verwijder set");
        System.out.println("[7] Sorteer voorwerpen");
        System.out.println("[8] Sorteer postzegels");
        System.out.println("[9] Geef sets weer");
        System.out.println("[0] Exit");
        Answer();
    }
    
    private static void ShowSets() {
        String tabIndent = "    ";
        
        for (Set s : sets) {
            // Sla de voorwerpen uit de set tijdelijk op
            ArrayList<Voorwerp> voorwerpen = s.getVoorwerpen();
            
            // Print de set
            System.out.println(s.getNaam() + " [" + voorwerpen.size() + " voorwerpen] - jaar " + s.getJaartal());
            
            // Print de voorwerpen uit de set
            if (voorwerpen.size() == 0) {
                System.out.println(tabIndent + "Geen voorwerpen");
            } else {
                for (Voorwerp v : voorwerpen) {
                    System.out.println(tabIndent + "[" + (voorwerpen.indexOf(v)+1) + "] " + v.getClass().getSimpleName());
                }
            }
        }
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
            System.out.println("-------------------------------------");
            
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
                    GeefSetsWeer();
                    NieuweMenuOpdracht();
                    break;
                case "0":
                    Exit();
                    break;
                default:
                    System.out.println("Onjuiste toets ingevoerd");
                    NieuweMenuOpdracht();
                    break;
            }
        }
    }
    
    private static void NieuweMenuOpdracht() {
        System.out.println("-------------------------------------");
        ShowMenu();
        MenuInteractie();
    }
    
    private static boolean GeefSetsWeer() {
        
        if (!sets.isEmpty()) {
            System.out.println(sets.size() + " sets gevonden:");
            ShowSets();
            return true;
        }
        
        return false;
    }
    
    private static Set VraagSetOp() {
        System.out.println("Sets:");
        
        // Geef alle sets weer
        if (GeefSetsWeer()) {
            // Vraag de naam van de set
            System.out.print("Set naam: ");
            String setNaam = Answer();

            // Loop over alle sets om het set object te vinden
            for (Set s : sets) {
                if (s.getNaam().equalsIgnoreCase(setNaam)) {
                    // Geef de set terug
                    return s;
                }
            }
        }
        
        return null;
    }
    
    private static Postzegel VraagPostzegelOp(Set s) {
        ArrayList<Voorwerp> voorwerpen = s.getVoorwerpen();
        boolean postzegelsGevonden = false;
        
        System.out.println("Mogelijke postzegels:");
        
        for (Voorwerp v : voorwerpen) {
            if (v instanceof Postzegel) {
                postzegelsGevonden = true;
                System.out.println("[" + voorwerpen.indexOf(v) + "] Oppervlakte: " + (((Postzegel)v).getBreedte() * ((Postzegel)v).getLengte()) + "mm^2");
            }
        }
        
        Postzegel postzegel = null;
        
        if (postzegelsGevonden) {
            // Vraag de index op van het voorwerp
            System.out.print("Postzegel nummer: ");
            int postzegelIndex = Integer.parseInt(Answer());

            try {
                postzegel = (Postzegel)voorwerpen.get(postzegelIndex);
            } catch (Exception ex) {
                // doe iets met de error
            }
        }
        
        return postzegel;
    }
    
    private static Bierdop VraagBierdopOp(Set s) {
        ArrayList<Voorwerp> voorwerpen = s.getVoorwerpen();
        boolean bierdoppenGevonden = false;
        
        System.out.println("Mogelijke bierdoppen:");
        
        for (Voorwerp v : voorwerpen) {
            if (v instanceof Bierdop) {
                bierdoppenGevonden =  true;
                System.out.println("[" + voorwerpen.indexOf(v) + "] Merknaam: " + ((Bierdop)v).getMerk());
            }
        }
        
        Bierdop bierdop = null;
        
        if (bierdoppenGevonden) {
            // Vraag de index op van het voorwerp
            System.out.print("Bierdop nummer: ");
            int bierdopIndex = Integer.parseInt(Answer());

            try {
                bierdop = (Bierdop)voorwerpen.get(bierdopIndex);
            } catch (Exception ex) {
                // doe iets met de error
            }
        }
        
        return bierdop;
    }
    
    private static void NieuwePostzegel() {
        if (!sets.isEmpty()) {
            System.out.println("Nieuwe Postzegel");
            System.out.print("Postzegel lengte (mm): ");
            String lengte = Answer();
            System.out.print("Postzegel breedte (mm): ");
            String breedte = Answer();
            Postzegel postzegel = new Postzegel(Integer.parseInt(lengte), Integer.parseInt(breedte));
            
            // Vraag een set om de postzegel aan toe te voegen
            Set set = VraagSetOp();
            
            // Als set null is, geef een foutmelding
            if (set == null) {
                System.out.println("Er is geen set gevonden met die naam");
            } else {
                // Voeg de postzegel toe aan de set
                set.AddVoorwerp(postzegel);
                
                System.out.println("De postzegel is toegevoegd.");
            }
        } else {
            System.out.println("Er zijn geen sets gevonden. Maak een nieuwe set aan door optie 3 te gebruiken in het menu.");
        }
        
        NieuweMenuOpdracht();
    }
    
    private static void NieuweBierdop() {
        if (!sets.isEmpty()) {
            System.out.println("Nieuwe Bierdop");
            
            // Vraag het merk op
            System.out.print("Bierdop merk: ");
            String merk = Answer();
            
            // Maak de bierdop aan
            Bierdop bierdop = new Bierdop(merk);
            
            // Vraag een set om de bierdop aan toe te voegen
            Set set = VraagSetOp();
            
            // Als set null is, geef een foutmelding
            if (set == null) {
                System.out.println("Er is geen set gevonden met die naam");
            } else {
                // Voeg de bierdop toe aan de set
                set.AddVoorwerp(bierdop);
                
                System.out.println("Bierdop is toegevoegd.");
            }
        } else {
            System.out.println("Er zijn geen sets gevonden. Maak een nieuwe set aan door optie 3 te gebruiken in het menu.");
        }
        
        NieuweMenuOpdracht();
    }

    private static void NieuweSet() {
        System.out.println("Nieuwe Set");
        System.out.print("Set naam: ");
        String naam = Answer();
        System.out.print("Set jaartal: ");
        String jaartal = Answer();
        Set set = new Set(naam, Integer.parseInt(jaartal));
        
        // Voeg de set toe aan de ArrayList
        sets.add(set);
        System.out.println("Set is toegevoegd.");
        
        NieuweMenuOpdracht();
    }

    private static void VerwijderPostzegel() {
        System.out.println("Verwijder Postzegel");
        
        // Vraag de set op
        Set set = VraagSetOp();
        
        if (set != null) {
            // Vraag de postzegel op
            Postzegel postzegel = VraagPostzegelOp(set);

            if (postzegel != null) {
                // Verwijder de postzegel uit de set
                set.RemoveVoorwerp(postzegel);
                System.out.println("De postzegel is verwijderd uit '" + set.getNaam() + "'");
            } else {
                System.out.println("Er is geen postzegel met dat nummer gevonden in '" + set.getNaam() + "'");
            }
        } else {
            System.out.println("Er is geen set gevonden");
        }
        
        NieuweMenuOpdracht();
    }

    private static void VerwijderBierdop() {
        System.out.println("Verwijder bierdop");
        
        // Vraag de set op
        Set set = VraagSetOp();
        
        if (set != null) {
            // Vraag de bierdop op
            Bierdop bierdop = VraagBierdopOp(set);

            if (bierdop != null) {
                // Verwijder de bierdop uit de set
                set.RemoveVoorwerp(bierdop);
                System.out.println("De bierdop is verwijderd uit '" + set.getNaam() + "'");
            } else {
                System.out.println("Er is geen bierdop met dat nummer gevonden in '" + set.getNaam() + "'");
            }
        } else {
            System.out.println("Er is geen set gevonden");
        }
        
        NieuweMenuOpdracht();
    }

    private static void VerwijderSet() {
        System.out.println("Verwijder set");
        
        if (!sets.isEmpty()) {
            Set set = VraagSetOp();

            // Als set undefined is, geef een foutmelding
            if (set == null) {
                System.out.println("Er is geen set gevonden met die naam");
            } else {
                sets.remove(set);

                System.out.println("De set '" + set.getNaam() + "' is verwijderd.");
            }
        } else {
            System.out.println("Er zijn geen sets gevonden.");
        }
        
        NieuweMenuOpdracht();
    }

    private static void SorteerVoorwerpen() {
        System.out.println("Sorteer voorwerpen");
        
        Set set = VraagSetOp();
        
        if (set != null) {
            ArrayList<Voorwerp> voorwerpen = set.ShowVoorwerpen();
            
            if (!voorwerpen.isEmpty()) {
                for (Voorwerp v : voorwerpen) {
                    System.out.println("[" + voorwerpen.indexOf(v) + "]" + v.getClass().getSimpleName());
                }
            } else {
                System.out.println("Deze set bevat geen voorwerpen");
            }
        } else {
            System.out.println("Er is geen set gevonden");
        }
        
        NieuweMenuOpdracht();
    }

    private static void SorteerPostzegels() {
        System.out.println("Sorteer postzegels");
        
        Set set = VraagSetOp();
        
        if (set != null) {
            ArrayList<Postzegel> postzegels = set.ShowPostzegels();
            
            if (!postzegels.isEmpty()) {
                for (Postzegel p : postzegels) {
                    System.out.println("[" + postzegels.indexOf(p) + "]" + p.getClass().getSimpleName());
                }
            } else {
                System.out.println("Deze set bevat geen postzegels");
            }
        } else {
            System.out.println("Er is geen set gevonden");
        }
        
        NieuweMenuOpdracht();
    }

    private static void Exit() {
        System.out.println("Applicatie is aan het afsluiten...");
        
        // Sluit de applicatie
        System.exit(0);
    }
}
