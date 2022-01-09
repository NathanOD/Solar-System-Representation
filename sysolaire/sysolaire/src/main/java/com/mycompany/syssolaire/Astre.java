/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.syssolaire;


import javafx.scene.paint.Color;


/**
 *
 * @author Thoma
 */
public class Astre {
    /**
     * Diametre de l'astre ramené à l'échelle de la scene (en pixels)
     */
    private double rayon;
    /**
     * Couleur de l'astre (utilisé pour la légende)
     */
    private Color couleur;
    /**
     * Periode de revolution
     */
    private double prevolution;

    /**
     * Constructeur
     * @param diametre
     * @param couleur
     * @param prevolution 
     */
    public Astre(double rayon, Color couleur, double prevolution) {
        this.rayon = rayon;
        this.couleur = couleur;
        this.prevolution = prevolution;
    }

    /**
     * Getter diametre
     * @return 
     */
    public double getRayon() {
        return rayon;
    }

    /**
     * Getter couleur
     * @return 
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * Getter periode revolution
     * @return 
     */
    public double getPrevolution() {
        return prevolution;
    }
    
    
}
