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
    
    Sphere c;
    Astre a;
    Label l;
    URL u;
    double texteX;
    double texteY;

    public rAstre(Sphere c, Astre a, Label l, URL u, double texteX, double texteY) {
        this.c = c;
        this.a = a;
        this.l = l;
        this.u = u;
        this.texteX = texteX;
        this.texteY = texteY;
    }

    
    
    public void affichageTexte(){
        l.setLayoutX(texteX);
        l.setLayoutY(texteY);
        l.setFont(Font.font("Calibri", 15.));
        l.setTextFill(a.getCouleur());
    }
    
    public void affichageTexture() throws IOException{
        URLConnection uconn = u.openConnection();
        InputStream is = uconn.getInputStream();
        Image i = new Image(is);
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(i);
        c.setMaterial(phongMaterial);
    }
    
    public void affichagePlanete(){
        c.setRadius(a.getRayon());
    }
    
    
}
