/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.syssolaire;

import javafx.scene.paint.Color;

/**
 * Classe des astres
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
     * @param rayon Rayon
     * @param couleur Couleur
     * @param prevolution Periode révolution
     * @param pannee Periode année
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
     * @return Diametre
     */
    public double getRayon() {
        return rayon;
    }

    /**
     * Getter couleur
     * 
     * @return Couleur 
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * Getter periode revolution
     * 
     * @return Periode révolution
     */
    public double getPrevolution() {
        return prevolution;
    }

    /**
     * Getter durée année
     * 
     * @return Periode Année
     */
    public double getPannee() {
        return this.pannee;
    }
}
