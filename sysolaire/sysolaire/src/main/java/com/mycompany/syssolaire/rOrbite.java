package com.mycompany.syssolaire;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class rOrbite {
    
    Ellipse e;
    Orbite o;

    /**
     * Constructeur
     * @param e
     * @param o 
     */
    public rOrbite(Ellipse e, Orbite o) {
        this.e = e;
        this.o = o;
    }
    
    public void affichage(){
        //Coordonnées centre
        e.setCenterX(o.getPcentrex());
        e.setCenterY(o.getPcentrey());
        //Longueur et largeur
        e.setRadiusX(o.getLongueur());
        e.setRadiusY(o.getLargeur());
        //Couleur
        e.setStroke(Color.rgb(228, 225, 220));
        e.setStrokeWidth(1);
        e.setFill(Color.rgb(1, 0, 41));
    }
    
    

    

}
