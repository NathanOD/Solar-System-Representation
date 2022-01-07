package com.mycompany.syssolaire;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class rOrbite {
    /**
     * Ellipse représentant l'orbite
     */
    Ellipse e;
    /**
     * Orbite associée
     */
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
    
    /**
     * Methode permettant de gérer l'affichage de l'orbite
     */
    public void affichage(){
        //Definition du centre de l'orbite
        e.setCenterX(o.getPcentrex());
        e.setCenterY(o.getPcentrey());
        //Definition de la longueur et de largeur de l'orbite
        e.setRadiusX(o.getLongueur());
        e.setRadiusY(o.getLargeur());
        //Gestion de la couleur de fond, de l'épaisseur et de la couleur de la bordure
        e.setStroke(Color.rgb(228, 225, 220));
        e.setStrokeWidth(1);
        e.setFill(Color.rgb(1, 0, 41));
    }
    
    

    

}
