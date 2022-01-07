package com.mycompany.syssolaire;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

public class Animation {
    /**
     * Chemin associé
     */
    PathTransition pt;
    /**
     * Astre associé
     */
    Astre a;
    Sphere s;
    Ellipse e;
    /**
     * Constructeur
     * @param pt
     * @param a
     * @param s
     * @param e 
     */
    public Animation(PathTransition pt, Astre a, Sphere s, Ellipse e) {
        this.pt = pt;
        this.a = a;
        this.s = s;
        this.e = e;
    }

    /**
     * Methode gérant l'affichage des animations
     */
    public void affAnim(){
        //Definition de la durée selon un facteur choisi
        pt.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*a.getPrevolution()*3600*24));
        //Definition de l'élément animé
        pt.setNode(s);
        //Definition du chemin à suivre
        pt.setPath(e);
        //Animation souhaitée infinie
        pt.setCycleCount(PathTransition.INDEFINITE);
        //Animation à vitesse linéaire
        pt.setInterpolator(Interpolator.LINEAR);
        //Lancement
        pt.play();
    }
}
