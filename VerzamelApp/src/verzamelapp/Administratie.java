/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import java.util.ArrayList;

/**
 *
 * @author Sander
 */
public class Administratie {

    private static ArrayList<Set> sets;
    private static ArrayList<Voorwerp> voorwerpen;

    public Administratie() {
        sets = new ArrayList<Set>();
        voorwerpen = new ArrayList<Voorwerp>();
    }

    public ArrayList<Voorwerp> getVoorwerpen() {
        return this.voorwerpen;
    }

    public ArrayList<Set> getSets() {
        return this.sets;
    }

    public void addVoorwerp(Voorwerp voorwerp) {
        this.voorwerpen.add(voorwerp);
    }

    public void addSet(Set set) {
        this.sets.add(set);
    }

    public void reset() {
        voorwerpen = new ArrayList<Voorwerp>();
        sets = new ArrayList<Set>();
    }
}
