package com.mycompany.syssolaire;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

public class Animation {
    PathTransition pt;
    Astre a;
    Sphere c;
    Ellipse e;

    public Animation(PathTransition pt, Astre a, Sphere c, Ellipse e) {
        this.pt = pt;
        this.a = a;
        this.c = c;
        this.e = e;
    }

    public void affAnim(){
        pt.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*a.getPrevolution()*3600*24));
        pt.setNode(c);
        pt.setPath(e);
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.setInterpolator(Interpolator.LINEAR);
        pt.play();
    }
}
