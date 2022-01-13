package com.mycompany.syssolaire;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

/**
 * Classe gérant les animations
 * @author Thoma
 */
public class Animation {
    /**
     * Chemin associé
     */
    PathTransition pt;
    /**
     * Rotation associée
     */
    RotateTransition rt;
    /**
     * Astre associé
     */
    Astre a;
    /**
     * Sphère associée
     */
    Sphere s;
    /**
     * Ellipse associée
     */
    Ellipse e;

    /**
     * Constructeur
     * 
     * @param pt Chemin ellipse
     * @param rt Rotation
     * @param a Astre
     * @param s Sphere
     * @param e Ellipse
     */
    public Animation(PathTransition pt, RotateTransition rt, Astre a, Sphere s, Ellipse e) {
        this.pt = pt;
        this.rt = rt;
        this.a = a;
        this.s = s;
        this.e = e;
    }

    /**
     * Methode gérant l'affichage des animations
     */
    public void affAnim() {
        // Definition de la durée selon un facteur choisi
        pt.setDuration(Duration.seconds(Math.pow(10, -5) * a.getPrevolution() * 3600 * 24));
        // Definition de l'élément animé
        pt.setNode(s);
        // Definition du chemin à suivre
        pt.setPath(e);
        // Animation souhaitée infinie
        pt.setCycleCount(PathTransition.INDEFINITE);
        // Animation à vitesse linéaire
        pt.setInterpolator(Interpolator.LINEAR);
        // Lancement
        pt.play();
    }

    /**
     * Méthode gérant l'affichage des rotations
     */
    public void affRotation() {
        // Definition de la durée selon un facteur choisi
        rt.setDuration(Duration.seconds(Math.pow(10, -5) * a.getPannee() * 3600 * 24));
        // Definition de l'élément animé
        rt.setNode(s);
        // CHoix de l'amplitude de la rotation
        rt.setByAngle(360);
        // Animation souhaitée infinie
        rt.setCycleCount(RotateTransition.INDEFINITE);
        // Animation à vitesse linéaire
        rt.setInterpolator(Interpolator.LINEAR);
        // Lancement
        rt.play();
    }
}
