/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.syssolaire;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

/**
 *
 * @author Thoma
 */
public class SmartGroup extends Group{
    /**
     * Rotation
     */
    Rotate r;
    /**
     * Transformation (rotation)
     */
    Transform t = new Rotate();

    /**
     * Gestion d'une rotation autour de l'axe X
     * @param ang 
     */
    void rotateByX(int ang) {
        r = new Rotate(ang, Rotate.X_AXIS);
        //Definition du point pivot (le Soleil)
        r.setPivotX(740);
        r.setPivotY(390);
        //Rotation
        t = t.createConcatenation(r);
        this.getTransforms().clear();
        this.getTransforms().addAll(t);
    }

    /**
     * Gestion d'une rotation autour de l'axe Y
     * @param ang 
     */
    void rotateByY(int ang) {
        r = new Rotate(ang, Rotate.Y_AXIS);
        r.setPivotX(740);
        r.setPivotY(390);
        t = t.createConcatenation(r);
        this.getTransforms().clear();
        this.getTransforms().addAll(t);
    }
}
