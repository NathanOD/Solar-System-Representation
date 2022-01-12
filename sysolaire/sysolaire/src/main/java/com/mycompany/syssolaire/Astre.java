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
     * Durée d'une année
     */
    private double pannee;

    /**
     * Constructeur
     * 
     * @param diametre
     * @param couleur
     * @param prevolution
     * @param pannee
     */
    public Astre(double rayon, Color couleur, double prevolution, double pannee) {
        this.rayon = rayon;
        this.couleur = couleur;
        this.prevolution = prevolution;
        this.pannee = pannee;
    }

    /**
     * Getter diametre
     * 
     * @return
     */
    public double getRayon() {
        return rayon;
    }

    /**
     * Getter couleur
     * 
     * @return
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * Getter periode revolution
     * 
     * @return
     */
    public double getPrevolution() {
        return prevolution;
    }

    /**
     * Getter durée année
     * 
     * @return
     */
    public double getPannee() {
        return this.pannee;
    }
}
