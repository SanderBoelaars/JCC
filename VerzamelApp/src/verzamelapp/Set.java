/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Sander
 */
public class Set {

    private String naam;
    private int jaartal;
    private ArrayList<Voorwerp> voorwerpen;

    public Set(String naam, int jaartal) {
        this.naam = naam;
        this.jaartal = jaartal;
        voorwerpen = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getJaartal() {
        return jaartal;
    }

    public void setJaartal(int jaartal) {
        this.jaartal = jaartal;
    }

    public ArrayList<Voorwerp> getVoorwerpen() {
        return voorwerpen;
    }

    public void setVoorwerpen(ArrayList voorwerpen) {
        this.voorwerpen = voorwerpen;
    }

    public void AddVoorwerp(Voorwerp voorwerp) {
        this.voorwerpen.add(voorwerp);
    }

    public void RemoveVoorwerp(Voorwerp voorwerp) {
        this.voorwerpen.remove(voorwerp);
    }

    public ArrayList<Voorwerp> ShowVoorwerpen() {
        Collections.sort(voorwerpen);
        return (ArrayList<Voorwerp>) Collections.unmodifiableList(this.voorwerpen);
    }

    public ArrayList<Postzegel> ShowPostzegels() {

        ArrayList<Postzegel> postzegels = new ArrayList<>();
        for (Voorwerp voorwerp : voorwerpen) {
            if (voorwerp instanceof Postzegel) {
                Postzegel postzegel = (Postzegel) voorwerp;
                postzegels.add(postzegel);
            }
        }
        Collections.sort(postzegels);
        return (ArrayList<Postzegel>) Collections.unmodifiableList(postzegels);
    }
}
