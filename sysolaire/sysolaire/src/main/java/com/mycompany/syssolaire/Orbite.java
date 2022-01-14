/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.syssolaire;

/**
 * Classe des orbites
 * @author Thoma
 */
public class Orbite {
    /**
     * Position centre x en pixels
     */
    private double pcentrex;
    /**
     * Position centre y en pixels
     */
    private double pcentrey;
    /**
     * Longueur de l'ellipse orbitale ramenée à l'échelle de la scene (en pixels)
     */
    private double longueur;
    /**
     * Largeur de l'ellipse orbitale ramenée à l'échelle de la scene (en pixels)
     */
    private double largeur;
    /**
     * Association avec une planète
     */
    private Astre planete;

    /**
     * Constructeur
     * 
     * @param pcentrex Position centre X
     * @param pcentrey Position centre Y
     * @param longueur Longueur
     * @param largeur Largeur
     * @param planete Planète associée
     */
    public Orbite(double pcentrex, double pcentrey, double longueur, double largeur, Astre planete) {
        this.pcentrex = pcentrex;
        this.pcentrey = pcentrey;
        this.longueur = longueur;
        this.largeur = largeur;
        this.planete = planete;
    }

    /**
     * Getter position centre x
     * 
     * @return Position centre X
     */
    public double getPcentrex() {
        return pcentrex;
    }

    /**
     * Getter position centre y
     * 
     * @return Position centre Y
     */
    public double getPcentrey() {
        return pcentrey;
    }

    /**
     * Getter longueur
     * 
     * @return Lonngueur
     */
    public double getLongueur() {
        return longueur;
    }

    /**
     * Getter largeur
     * 
     * @return Largeur
     */
    public double getLargeur() {
        return largeur;
    }

}
