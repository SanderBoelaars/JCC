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
public class Postzegel extends Voorwerp {

    private int lengte;
    private int breedte;

    public Postzegel(String naam, int lengte, int breedte) {
        super(naam);
        this.lengte = lengte;
        this.breedte = breedte;
        
    }

    public int getLengte() {
        return this.lengte;
    }

    public int getBreedte() {
        return this.breedte;
    }

    @Override
    public int compareTo(Object o) {
        Postzegel p = (Postzegel) o;

        if ((this.lengte * this.breedte) == (p.lengte * p.breedte)) {
            return 0;
        } else if ((this.lengte * this.breedte) > (p.lengte * p.breedte)) {
            return 1;
        } else {
            return -1;
        }
    }
}
