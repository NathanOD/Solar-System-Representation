package com.mycompany.syssolaire;

import java.io.IOException;
import java.net.URL;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        // Tout est défini selon le nombre de pixels
        // L'axe x part du haut gauche de la fenetre vers la droite
        // L'axe y part du haut gauche et se dirige vers le bas
        // Creation de la scène et association a la fenetre
        Group root = new Group();
        SmartGroup groupePlanete = new SmartGroup();
        // Scene de taille 1480x780 pixels
        Scene scene = new Scene(root, 1480, 780);
        //Scene scene2 = new Scene(groupePlanete, 1480, 780);
        stage.setScene(scene);
        // Modification du nom
        stage.setTitle("Systeme Solaire");
        // Association du nouveau groupe a la racine
        root.getChildren().add(groupePlanete);
        // Choix couleur scene
        scene.setFill(Color.rgb(1, 0, 41));

        // Creation soleil
        Astre soleil = new Astre(55, Color.rgb(255, 178, 1), 0);

        // Creation representation Soleil
        // Circle rSoleil = new Circle();
        Sphere rSoleil = new Sphere();
        // Positionnement
        // rSoleil.setCenterX(740);
        // rSoleil.setCenterY(390);
        rSoleil.setLayoutX(740);
        rSoleil.setLayoutY(390);
        // Creation de son label
        Label tSoleil = new Label("Soleil");
        // Creation de l'url afin d'obtenir la texture
        URL urlSoleil = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Soleil.jpg");
        // Creation d'une représentation
        rAstre repSoleil = new rAstre(rSoleil, soleil, tSoleil, urlSoleil, 5, 5);
        // Application des méthodes pour affichage
        repSoleil.affichagePlanete();
        repSoleil.affichageTexte();
        repSoleil.affichageTexture();

        // Creation de Mercure et de son orbite
        Astre mercure = new Astre(3, Color.rgb(162, 158, 156), 87.969);
        Orbite oMercure = new Orbite(740, 390, 126, 66, mercure);
        // Representation de l'orbite
        Ellipse eMercure = new Ellipse();
        rOrbite orbMercure = new rOrbite(eMercure, oMercure);
        orbMercure.affichage();

        // Representation planète
        Sphere rMercure = new Sphere();
        Label tMercure = new Label("Mercure");
        URL urlMercure = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Mercure.jpg");
        rAstre repMercure = new rAstre(rMercure, mercure, tMercure, urlMercure, 5, 30);
        repMercure.affichagePlanete();
        repMercure.affichageTexte();
        repMercure.affichageTexture();

        // Animation
        PathTransition transitionMercure = new PathTransition();
        Animation animMercure = new Animation(transitionMercure, mercure, rMercure, eMercure);
        animMercure.affAnim();

        // Creation Venus et son orbite
        Astre venus = new Astre(7, Color.rgb(142, 186, 195), 224.667);
        Orbite oVenus = new Orbite(740, 390, 186, 98, venus);

        // Representation orbite
        Ellipse eVenus = new Ellipse();
        rOrbite orbVenus = new rOrbite(eVenus, oVenus);
        orbVenus.affichage();

        // Representation planete
        Sphere rVenus = new Sphere();
        Label tVenus = new Label("Venus");
        URL urlVenus = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Venus.jpg");
        rAstre repVenus = new rAstre(rVenus, venus, tVenus, urlVenus, 5, 55);
        repVenus.affichagePlanete();
        repVenus.affichageTexte();
        repVenus.affichageTexture();

        // Animations
        PathTransition transitionVenus = new PathTransition();
        Animation animVenus = new Animation(transitionVenus, venus, rVenus, eVenus);
        animVenus.affAnim();

        // Creation Terre
        // Utilisation de la color.rgb qui donne une couleur à partir de la reference
        // rgb
        // Nous avons utilisé https://htmlcolorcodes.com/fr/
        Astre terre = new Astre(8, Color.rgb(72, 185, 234), 365.2569);
        // Creation de l'orbite de la Terre
        Orbite oTerre = new Orbite(740, 390, 217, 114, terre);

        // Creation forme representant l'orbite (une ellipse)
        Ellipse eTerre = new Ellipse();
        // Creation de la représentation de l'orbite
        rOrbite orbTerre = new rOrbite(eTerre, oTerre);
        // Affichage
        orbTerre.affichage();

        // Creation du cercle representant la Terre
        Sphere rTerre = new Sphere();
        // Creation de son label
        Label tTerre = new Label("Terre");
        // Creation de son URL afin d'obtenir la texture
        URL urlTerre = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Terre.jpg");
        // Creation de la représentation astrale
        rAstre repTerre = new rAstre(rTerre, terre, tTerre, urlTerre, 5, 80);
        // Affichage de la planète
        repTerre.affichagePlanete();
        // Affichage du label associé
        repTerre.affichageTexte();
        // Association avec la texture
        repTerre.affichageTexture();

        // Animations
        // Nous avons décidé d'utiliser des animations directement implantées dans
        // javaFX
        // Creation d'un chemin pour l'animation
        PathTransition transitionTerre = new PathTransition();
        // Creation d'une animation
        Animation animTerre = new Animation(transitionTerre, terre, rTerre, eTerre);
        // Affichage de l'animation
        animTerre.affAnim();

        // Creation de Mars et de son orbite
        Astre mars = new Astre(5, Color.rgb(217, 72, 8), 686.885);
        Orbite oMars = new Orbite(740, 390, 256, 135, venus);

        // Representation de l'orbite de Mars
        Ellipse eMars = new Ellipse();
        rOrbite orbMars = new rOrbite(eMars, oMars);
        orbMars.affichage();

        // Representation planete
        Sphere rMars = new Sphere();
        Label tMars = new Label("Mars");
        URL urlMars = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Mars.jpg");
        rAstre repMars = new rAstre(rMars, mars, tMars, urlMars, 5, 105);
        repMars.affichagePlanete();
        repMars.affichageTexte();
        repMars.affichageTexture();

        // Animations
        PathTransition transitionMars = new PathTransition();
        Animation animMars = new Animation(transitionMars, mars, rMars, eMars);
        animMars.affAnim();

        // Creation de Jupiter et de son orbite
        Astre jupiter = new Astre(25, Color.rgb(202, 158, 141), 4332.01);
        Orbite oJupiter = new Orbite(740, 390, 311, 164, jupiter);

        // Representation orbite
        Ellipse eJupiter = new Ellipse();
        rOrbite orbJupiter = new rOrbite(eJupiter, oJupiter);
        orbJupiter.affichage();

        // Representation planete
        Sphere rJupiter = new Sphere();
        Label tJupiter = new Label("Jupiter");
        URL urlJupiter = new URL( "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Jupiter.jpg");
        rAstre repJupiter = new rAstre(rJupiter, jupiter, tJupiter, urlJupiter, 5, 130);
        repJupiter.affichagePlanete();
        repJupiter.affichageTexte();
        repJupiter.affichageTexture();

        // Animation Jupiter
        PathTransition transitionJupiter = new PathTransition();
        Animation animJupiter = new Animation(transitionJupiter, jupiter, rJupiter, eJupiter);
        animJupiter.affAnim();

        // Creation de Saturne et de son orbite
        Astre saturne = new Astre(20, Color.rgb(159, 193, 133), 10754);
        Orbite oSaturne = new Orbite(740, 390, 427, 224, saturne);

        // Creation representation orbite
        Ellipse eSaturne = new Ellipse();
        rOrbite orbSaturne = new rOrbite(eSaturne, oSaturne);
        orbSaturne.affichage();

        // Representation planete
        Sphere rSaturne = new Sphere();
        Label tSaturne = new Label("Saturne");
        URL urlSaturne = new URL(  "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Saturne.jpg");
        rAstre repSaturne = new rAstre(rSaturne, saturne, tSaturne, urlSaturne, 5, 155);
        repSaturne.affichagePlanete();
        repSaturne.affichageTexte();
        repSaturne.affichageTexture();

        // Animation Saturne
        PathTransition transitionSaturne = new PathTransition();
        Animation animSaturne = new Animation(transitionSaturne, saturne, rSaturne, eSaturne);
        animSaturne.affAnim();

        // Creation d'Uranus et de son orbite
        Astre uranus = new Astre(12, Color.rgb(140, 218, 222), 30698);
        Orbite oUranus = new Orbite(740, 390, 559, 294, uranus);

        // Creation representation orbite
        Ellipse eUranus = new Ellipse();
        rOrbite orbUranus = new rOrbite(eUranus, oUranus);
        orbUranus.affichage();
        Sphere rUranus = new Sphere();
        Label tUranus = new Label("Uranus");
        URL urlUranus = new URL(   "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Uranus.jpg");
        rAstre repUranus = new rAstre(rUranus, uranus, tUranus, urlUranus, 5, 180);
        // Affichage
        repUranus.affichagePlanete();
        repUranus.affichageTexte();
        repUranus.affichageTexture();

        // Animation Uranus
        PathTransition transitionUranus = new PathTransition();
        Animation animUranus = new Animation(transitionUranus, uranus, rUranus, eUranus);
        animUranus.affAnim();

        // Creation de Neptune et de son orbite
        Astre neptune = new Astre(11, Color.rgb(47, 100, 223), 60216.8);
        Orbite oNeptune = new Orbite(740, 390, 644, 339, neptune);

        // Representation orbite
        Ellipse eNeptune = new Ellipse();
        rOrbite orbNeptune = new rOrbite(eNeptune, oNeptune);
        orbNeptune.affichage();

        // Representation planete
        Sphere rNeptune = new Sphere();
        Label tNeptune = new Label("Neptune");
        URL urlNeptune = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Neptune.jpg");
        rAstre repNeptune = new rAstre(rNeptune, neptune, tNeptune, urlNeptune, 5, 205);
        repNeptune.affichagePlanete();
        repNeptune.affichageTexte();
        repNeptune.affichageTexture();

        // Animation Neptune
        PathTransition transitionNeptune = new PathTransition();
        Animation animNeptune = new Animation(transitionNeptune, neptune, rNeptune, eNeptune);
        animNeptune.affAnim();

        // Creation du bouton play/pause
        ToggleButton BoutonPause = new ToggleButton("Play/Pause");
        // Positionnement
        BoutonPause.setLayoutX(1397);
        BoutonPause.setLayoutY(5);

        // Action lors du click sur bouton
        BoutonPause.setOnAction((ActionEvent event) -> {
            // Si le bouton pause est selectionné on met en pause toutes les animations
            if (BoutonPause.isSelected()) {
                transitionMercure.pause();
                transitionVenus.pause();
                transitionTerre.pause();
                transitionMars.pause();
                transitionJupiter.pause();
                transitionSaturne.pause();
                transitionUranus.pause();
                transitionNeptune.pause();
            }
            // Sinon toutes les animations sont lancées
            else {
                transitionMercure.play();
                transitionVenus.play();
                transitionTerre.play();
                transitionMars.play();
                transitionJupiter.play();
                transitionSaturne.play();
                transitionUranus.play();
                transitionNeptune.play();
            }
        });

        // Creation Slider Vitesse
        Slider sliderVitesse = new Slider();
        // Definition min et max (de x1 à x5)
        sliderVitesse.setMin(1);
        sliderVitesse.setMax(5);
        // Valeur au lancement 1
        sliderVitesse.setValue(1);
        // Positionnement
        sliderVitesse.setLayoutX(1300);
        sliderVitesse.setLayoutY(740);
        // Label associé
        Label tSlider = new Label("Vitesse");
        // Positionnement
        tSlider.setLayoutX(1345);
        tSlider.setLayoutY(720);
        // Modification de la police et de la taille
        tSlider.setFont(Font.font("Calibri", 17.));
        // Modification de la couleur
        tSlider.setTextFill(Color.WHITE);
        // Ajout de l'échelle sur le slider
        sliderVitesse.setShowTickLabels(true);
        // Incrémentation de 1
        sliderVitesse.setBlockIncrement(1);
        // Visualiser les sous graduations
        sliderVitesse.setShowTickMarks(true);

        // Gestion du Slider vitesse
        // Recuperation des valeurs et adpataion
        sliderVitesse.valueProperty().addListener(
                (ObservableValue<? extends Number> obsVal, Number oldVal, Number newVal) -> {
                    // Arret des animations pour en relancer de nouvelles avec de nouvelles durées
                    transitionMercure.stop();
                    transitionVenus.stop();
                    transitionTerre.stop();
                    transitionMars.stop();
                    transitionJupiter.stop();
                    transitionSaturne.stop();
                    transitionUranus.stop();
                    transitionNeptune.stop();
                    // Nouvelle durée de l'animation en divisant par la valeur récupérée
                    // On récupère cette nouvelle valeur avec newVal qui est un number
                    // Nous convertissons donc cette valeur en double
                    transitionMercure.setDuration(Duration.seconds(
                            5.77 * Math.pow(10, -7) * mercure.getPrevolution() * 3600 * 24 / newVal.doubleValue()));
                    transitionVenus.setDuration(Duration.seconds(
                            5.77 * Math.pow(10, -7) * venus.getPrevolution() * 3600 * 24 / newVal.doubleValue()));
                    transitionTerre.setDuration(Duration.seconds(
                            5.77 * Math.pow(10, -7) * terre.getPrevolution() * 3600 * 24 / newVal.doubleValue()));
                    transitionMars.setDuration(Duration.seconds(
                            5.77 * Math.pow(10, -7) * mars.getPrevolution() * 3600 * 24 / newVal.doubleValue()));
                    transitionJupiter.setDuration(Duration.seconds(
                            5.77 * Math.pow(10, -7) * jupiter.getPrevolution() * 3600 * 24 / newVal.doubleValue()));
                    transitionSaturne.setDuration(Duration.seconds(
                            5.77 * Math.pow(10, -7) * saturne.getPrevolution() * 3600 * 24 / newVal.doubleValue()));
                    transitionUranus.setDuration(Duration.seconds(
                            5.77 * Math.pow(10, -7) * uranus.getPrevolution() * 3600 * 24 / newVal.doubleValue()));
                    transitionNeptune.setDuration(Duration.seconds(
                            5.77 * Math.pow(10, -7) * neptune.getPrevolution() * 3600 * 24 / newVal.doubleValue()));
                    // On relance l'ensemble des animations
                    transitionMercure.play();
                    transitionVenus.play();
                    transitionTerre.play();
                    transitionMars.play();
                    transitionJupiter.play();
                    transitionSaturne.play();
                    transitionUranus.play();
                    transitionNeptune.play();
                });

        // Gestion des checkbox
        // Creation d'une checkbox
        CheckBox cbSoleil = new CheckBox();
        // Definition du positionnement
        cbSoleil.setLayoutX(62);
        cbSoleil.setLayoutY(7);
        // Definir initialement la case comme cochée
        cbSoleil.setSelected(true);
        // Gestion de l'action lorsqu'elle est cochée/décochée
        cbSoleil.setOnAction((ActionEvent event) -> {
            // Si la checkbox est selectionnée on affiche la planete
            if (cbSoleil.isSelected()) {
                rSoleil.setVisible(true);
            }
            // Si la checkbox est déselectionnée on n'affiche plus la planete
            else {
                rSoleil.setVisible(false);
            }
        });

        // Checkbox Mercure
        CheckBox cbMercure = new CheckBox();
        // Positionnement
        cbMercure.setLayoutX(62);
        cbMercure.setLayoutY(32);
        // Selectionnée
        cbMercure.setSelected(true);
        cbMercure.setOnAction((ActionEvent event) -> {
            // Gestion affichage orbite + Planète
            if (cbMercure.isSelected()) {
                eMercure.setVisible(true);
                rMercure.setVisible(true);
            } else {
                eMercure.setVisible(false);
                rMercure.setVisible(false);
            }
        });

        // Checkbox Venus
        CheckBox cbVenus = new CheckBox();
        cbVenus.setLayoutX(62);
        cbVenus.setLayoutY(57);
        cbVenus.setSelected(true);
        cbVenus.setOnAction((ActionEvent event) -> {
            if (cbVenus.isSelected()) {
                eVenus.setVisible(true);
                rVenus.setVisible(true);
            } else {
                eVenus.setVisible(false);
                rVenus.setVisible(false);
            }
        });

        // Checkbox Terre
        CheckBox cbTerre = new CheckBox();
        cbTerre.setLayoutX(62);
        cbTerre.setLayoutY(82);
        cbTerre.setSelected(true);
        cbTerre.setOnAction((ActionEvent event) -> {
            if (cbTerre.isSelected()) {
                eTerre.setVisible(true);
                rTerre.setVisible(true);
            } else {
                eTerre.setVisible(false);
                rTerre.setVisible(false);
            }
        });

        // Checkbox Mars
        CheckBox cbMars = new CheckBox();
        cbMars.setLayoutX(62);
        cbMars.setLayoutY(107);
        cbMars.setSelected(true);
        cbMars.setOnAction((ActionEvent event) -> {
            if (cbMars.isSelected()) {
                eMars.setVisible(true);
                rMars.setVisible(true);
            } else {
                eMars.setVisible(false);
                rMars.setVisible(false);
            }
        });

        // Checkbox Jupiter
        CheckBox cbJupiter = new CheckBox();
        cbJupiter.setLayoutX(62);
        cbJupiter.setLayoutY(132);
        cbJupiter.setSelected(true);
        cbJupiter.setOnAction((ActionEvent event) -> {
            if (cbJupiter.isSelected()) {
                eJupiter.setVisible(true);
                rJupiter.setVisible(true);
            } else {
                eJupiter.setVisible(false);
                rJupiter.setVisible(false);
            }
        });

        // Checkbox Saturne
        CheckBox cbSaturne = new CheckBox();
        cbSaturne.setLayoutX(62);
        cbSaturne.setLayoutY(157);
        cbSaturne.setSelected(true);
        cbSaturne.setOnAction((ActionEvent event) -> {
            if (cbSaturne.isSelected()) {
                eSaturne.setVisible(true);
                rSaturne.setVisible(true);
            } else {
                eSaturne.setVisible(false);
                rSaturne.setVisible(false);
            }
        });

        // Checkbox Uranus
        CheckBox cbUranus = new CheckBox();
        cbUranus.setLayoutX(62);
        cbUranus.setLayoutY(182);
        cbUranus.setSelected(true);
        cbUranus.setOnAction((ActionEvent event) -> {
            if (cbUranus.isSelected()) {
                eUranus.setVisible(true);
                rUranus.setVisible(true);
            } else {
                eUranus.setVisible(false);
                rUranus.setVisible(false);
            }
        });

        // Checkbox Neptune
        CheckBox cbNeptune = new CheckBox();
        cbNeptune.setLayoutX(62);
        cbNeptune.setLayoutY(207);
        cbNeptune.setSelected(true);
        cbNeptune.setOnAction((ActionEvent event) -> {
            if (cbNeptune.isSelected()) {
                eNeptune.setVisible(true);
                rNeptune.setVisible(true);
            } else {
                eNeptune.setVisible(false);
                rNeptune.setVisible(false);
            }
        });
        
        // Partie 3D ############################################################

        Camera camera = new PerspectiveCamera();
        //camera.relocate(790, 390);
        //camera.setLayoutX(790);
        //camera.setLayoutY(390);
        scene.setCamera(camera);

        //Group world = createEnvironement();

        groupePlanete.translateXProperty().set(1480 / 2);
        groupePlanete.translateYProperty().set(780 / 2);
        groupePlanete.translateZProperty().set(0);
        groupePlanete.setLayoutX(-740);
        groupePlanete.setLayoutY(-390);

        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case S:
                    groupePlanete.translateZProperty().set(groupePlanete.getTranslateZ() + 100);
                    break;
                case W:
                    groupePlanete.translateZProperty().set(groupePlanete.getTranslateZ() - 100);
                    break;
                case D:
                    groupePlanete.rotateByX(10);
                    break;
                case A:
                    groupePlanete.rotateByX(-10);
                    break;
                case Q:
                    groupePlanete.rotateByY(10);
                    break;
                case E:
                    groupePlanete.rotateByY(-10);
                    break;
            }
        });

        // Mise en relation des éléments créés avec la racine pour qu'ils soient
        // affichés
        groupePlanete.getChildren().addAll(eNeptune, eUranus, eSaturne, eJupiter, eMars, eTerre, eVenus, eMercure);
        groupePlanete.getChildren().addAll(rSoleil, rMercure, rVenus, rTerre, rMars, rJupiter, rSaturne, rUranus, rNeptune);
        root.getChildren().addAll(tSoleil, tMercure, tVenus, tTerre, tMars, tJupiter, tSaturne, tUranus, tNeptune);
        root.getChildren().addAll(cbSoleil, cbMercure, cbVenus, cbTerre, cbMars, cbJupiter, cbSaturne, cbUranus, cbNeptune);
        root.getChildren().addAll(tSlider, sliderVitesse, BoutonPause);


        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    class SmartGroup extends Group {

        Rotate r;
        Transform t = new Rotate();

        void rotateByX(int ang) {
            r = new Rotate(ang, Rotate.X_AXIS);
            r.setPivotX(740);
            r.setPivotY(390);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByY(int ang) {
            r = new Rotate(ang, Rotate.Y_AXIS);
            r.setPivotX(740);
            r.setPivotY(390);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
    }

}