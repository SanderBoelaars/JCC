/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

/**
 *
 * @author Sander
 */
public abstract class Voorwerp implements Comparable {

    private String naam;

    public Voorwerp(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return this.naam;
    }
}
