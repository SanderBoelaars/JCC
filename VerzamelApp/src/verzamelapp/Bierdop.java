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
public class Bierdop extends Voorwerp {

    private String merk;

    public Bierdop(String merk) {
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }

    @Override
    public int compareTo(Object o) {
        Bierdop b = (Bierdop)o;
        return this.merk.compareTo(b.merk);
    }
}
