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
     * @param rayon Rayon de l'astre
     * @param couleur Couleur associée
     * @param prevolution Periode pour une révolution
     * @param pannee Periode pour une année
     */
    public Astre(double rayon, Color couleur, double prevolution, double pannee) {
        this.rayon = rayon;
        this.couleur = couleur;
        this.prevolution = prevolution;
        this.pannee = pannee;
    }

    /**
     * Getter rayon
     * 
     * @return Rayon de l'astre
     */
    public double getRayon() {
        return rayon;
    }

    /**
     * Getter couleur
     * 
     * @return Couleur de l'astre
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * Getter periode revolution
     * 
     * @return Periode de révolution
     */
    public double getPrevolution() {
        return prevolution;
    }

    /**
     * Getter durée année
     * 
     * @return Periode pour une année
     */
    public double getPannee() {
        return this.pannee;
    }
}
