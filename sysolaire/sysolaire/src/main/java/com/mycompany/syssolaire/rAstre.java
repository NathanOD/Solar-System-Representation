/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.syssolaire;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;

/**
 *
 * @author Thoma
 */
public class rAstre {
<<<<<<< HEAD
    
    Sphere c;
=======
    /**
     * Cercle representant la planète
     */
    Circle c;
    /**
     * Astre associé
     */
>>>>>>> e6697f356c947150a6262d7a2c653fb7b866d1b0
    Astre a;
    /**
     * Label associé pour la légende
     */
    Label l;
    /**
     * URL associé afin d'obtenir la texture
     */
    URL u;
    /**
     * Positionnement du label selon x
     */
    double texteX;
    /**
     * Positionnement du label selon y
     */
    double texteY;

<<<<<<< HEAD
    public rAstre(Sphere c, Astre a, Label l, URL u, double texteX, double texteY) {
=======
    /**
     * Constructeur
     * @param c
     * @param a
     * @param l
     * @param u
     * @param texteX
     * @param texteY 
     */
    public rAstre(Circle c, Astre a, Label l, URL u, double texteX, double texteY) {
>>>>>>> e6697f356c947150a6262d7a2c653fb7b866d1b0
        this.c = c;
        this.a = a;
        this.l = l;
        this.u = u;
        this.texteX = texteX;
        this.texteY = texteY;
    }

    
    /**
     * Methode gérant l'affichage du label
     */
    public void affichageTexte(){
        //Definition du positionnement
        l.setLayoutX(texteX);
        l.setLayoutY(texteY);
        //Gestion de la police, couleur et taille du texte
        l.setFont(Font.font("Calibri", 15.));
        l.setTextFill(a.getCouleur());
    }
    
    /**
     * Methode permettant d'afficher la texture des planètes
     * @throws IOException 
     */
    public void affichageTexture() throws IOException{
        //Recuperation de l'image à partir d'internet
        URLConnection uconn = u.openConnection();
        InputStream is = uconn.getInputStream();
        //Creation de l'image
        Image i = new Image(is);
<<<<<<< HEAD
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(i);
        c.setMaterial(phongMaterial);
=======
        //Association entre le cercle représentant la planète et l'image
        c.setFill(new ImagePattern(i));
>>>>>>> e6697f356c947150a6262d7a2c653fb7b866d1b0
    }
    
    /**
     * Methode definissant la taille d'affichage des planètes
     */
    public void affichagePlanete(){
        c.setRadius(a.getRayon());
    }
    
    
}
