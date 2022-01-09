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
import javafx.event.ActionEvent;

import javafx.geometry.Point3D;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Thoma
 */
public class rAstre {
    Sphere s;
    /**
     * Astre associé
     */
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
    /**
     * Checkbox associée
     */
    CheckBox cb;
    /**
     * Positionnement selon x
     */
    double cbx;
    /**
     * Positionnement selon y
     */
    double cby;
    /**
     * Ellipse associée à l'astre
     */
    Ellipse e;

    /**
     * Constructeur
     * @param s
     * @param a
     * @param l
     * @param u
     * @param texteX
     * @param texteY
     * @param cb
     * @param cbx
     * @param cby
     * @param e 
     */
    public rAstre(Sphere s, Astre a, Label l, URL u, double texteX, double texteY, CheckBox cb, double cbx, double cby, Ellipse e) {
        this.s = s;
        this.a = a;
        this.l = l;
        this.u = u;
        this.texteX = texteX;
        this.texteY = texteY;
        this.cb = cb;
        this.cbx = cbx;
        this.cby = cby;
        this.e = e;
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
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(i);
        s.setMaterial(phongMaterial);
        Rotate rot = new Rotate(90,Rotate.X_AXIS);
        s.getTransforms().add(rot);
    }
    
    /**
     * Methode definissant la taille d'affichage des planètes
     */
    public void affichagePlanete(){
        s.setRadius(a.getRayon());
    }
    
    
    public void gestionCheckbox(){
        cb.setLayoutX(cbx);
        cb.setLayoutY(cby);
        // Selectionnée
        cb.setSelected(true);
        cb.setOnAction((ActionEvent event) -> {
            // Gestion affichage orbite + Planète
            if (cb.isSelected()) {
                e.setVisible(true);
                s.setVisible(true);
            } else {
                e.setVisible(false);
                s.setVisible(false);
            }
        });
    }
    
}
