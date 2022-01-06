package com.mycompany.syssolaire;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {

        //Tout est défini selon le nombre de pixels
        //L'axe x part du haut gauche de la fenetre vers la droite
        //L'axe y part du haut gauche et se dirige vers le bas
        //Creation de la scène et association a la fenetre
        Group root = new Group();
        //Scene de taille 1480x780 pixels
        Scene scene = new Scene(root,1480,780);
        stage.setScene(scene);
        //Modification du nom
        stage.setTitle("Systeme Solaire");
        //Creation d'un groupe destiné au texte
        Group gtexte = new Group();
        //Association du nouveau groupe a la racine
        root.getChildren().add(gtexte);
        //Choix couleur scene
        scene.setFill(Color.rgb(1, 0, 41));
        
        // Creation soleil
        Astre soleil = new Astre(35,Color.rgb(255, 178, 1),0);
        
        
        
        //Creation representation Soleil
        Circle rSoleil = new Circle();
        rSoleil.setCenterX(740);
        rSoleil.setCenterY(390);
        rSoleil.setRadius(soleil.getRayon());
        rSoleil.setFill(soleil.getCouleur());
        //Creation de son label
        Label tSoleil = new Label("Soleil");
        tSoleil.setLayoutX(5);
        tSoleil.setLayoutY(5);
        tSoleil.setFont(Font.font("Calibri", 15.));
        tSoleil.setTextFill(soleil.getCouleur());
        
        

        
        URL urlSoleil = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Soleil.png");
        URLConnection connSoleil = urlSoleil.openConnection();
        InputStream isSoleil = connSoleil.getInputStream();
        Image iSoleil = new Image(isSoleil);
        rSoleil.setFill(new ImagePattern(iSoleil));
        
        
        
        
        //Creation orbite Mercure
        Astre mercure = new Astre (3, Color.rgb(162, 158, 156), 87.969);
        Orbite oMercure = new Orbite (740, 390, 126, 66, mercure);
        
        //Creation representation orbite
        Ellipse eMercure = new Ellipse();
        /**
        //Coordonnées centre
        eMercure.setCenterX(oMercure.getPcentrex());
        eMercure.setCenterY(oMercure.getPcentrey());
        //Longueur et largeur
        eMercure.setRadiusX(oMercure.getLongueur());
        eMercure.setRadiusY(oMercure.getLargeur());
        //Couleur
        eMercure.setStroke(Color.rgb(228, 225, 220));
        eMercure.setStrokeWidth(1);
        eMercure.setFill(Color.rgb(1, 0, 41));
        **/
        
        rOrbite orbMercure = new rOrbite(eMercure, oMercure);
        orbMercure.affichage();
        
        //Creation representation Mercure
        Circle rMercure = new Circle();
        /**
        rMercure.setRadius(mercure.getRayon());
        rMercure.setFill(mercure.getCouleur());
        **/
        //Creation de son label
        Label tMercure = new Label("Mercure");
        /**
        tMercure.setLayoutX(5);
        tMercure.setLayoutY(30);
        tMercure.setFont(Font.font("Calibri", 15.));
        tMercure.setTextFill(mercure.getCouleur());
        **/

        URL urlMercure = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Mercure.png");
        /**
        URLConnection connMercure = urlMercure.openConnection();
        InputStream isMercure = connMercure.getInputStream();
        Image iMercure = new Image(isMercure);
        rMercure.setFill(new ImagePattern(iMercure));
        **/

        rAstre repMercure = new rAstre(rMercure, mercure, tMercure, urlMercure, 5, 30);
        
        repMercure.affichagePlanete();
        repMercure.affichageTexte();
        repMercure.affichageTexture();
        
        
        //Animation
        PathTransition transitionMercure = new PathTransition();
        transitionMercure.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*mercure.getPrevolution()*3600*24));
        transitionMercure.setNode(rMercure);
        transitionMercure.setPath(eMercure);
        transitionMercure.setCycleCount(PathTransition.INDEFINITE);
        transitionMercure.setInterpolator(Interpolator.LINEAR);
        transitionMercure.play();

        
        
        
        
        
        //Creation orbite Venus
        Astre venus = new Astre (7, Color.rgb(142, 186, 195), 224.667);
        Orbite oVenus = new Orbite (740, 390, 186, 98, venus);
        
        //Creation representation orbite
        Ellipse eVenus = new Ellipse();
        
        rOrbite orbVenus = new rOrbite(eVenus, oVenus);
        orbVenus.affichage();
        
        /**
        //Coordonnées centre
        eVenus.setCenterX(oVenus.getPcentrex());
        eVenus.setCenterY(oVenus.getPcentrey());
        //Longueur et largeur
        eVenus.setRadiusX(oVenus.getLongueur());
        eVenus.setRadiusY(oVenus.getLargeur());
        //Couleur
        eVenus.setStroke(Color.rgb(228, 225, 220));
        eVenus.setStrokeWidth(1);
        eVenus.setFill(Color.rgb(1, 0, 41));
        **/
        
        //Creation representation Venus
        Circle rVenus = new Circle();
        /*
        rVenus.setRadius(venus.getRayon());
        rVenus.setFill(venus.getCouleur());
        */
        //Creation de son label
        Label tVenus = new Label("Venus");
        /*
        tVenus.setLayoutX(5);
        tVenus.setLayoutY(55);
        tVenus.setFont(Font.font("Calibri", 15.));
        tVenus.setTextFill(venus.getCouleur());
        */


        URL urlVenus = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Venus.png");
        /*
        URLConnection connVenus = urlVenus.openConnection();
        InputStream isVenus = connVenus.getInputStream();
        Image iVenus = new Image(isVenus);
        rVenus.setFill(new ImagePattern(iVenus));
        */

        rAstre repVenus = new rAstre(rVenus, venus, tVenus, urlVenus, 5, 55);
        
        repVenus.affichagePlanete();
        repVenus.affichageTexte();
        repVenus.affichageTexture();


        //Animations
        PathTransition transitionVenus = new PathTransition();
        transitionVenus.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*venus.getPrevolution()*3600*24));
        transitionVenus.setNode(rVenus);
        transitionVenus.setPath(eVenus);
        transitionVenus.setCycleCount(PathTransition.INDEFINITE);
        transitionVenus.setInterpolator(Interpolator.LINEAR);
        transitionVenus.play();


        
        //Creation Terre
        //Utilisation de la color.rgb qui donne une couleur à partir de la reference rgb
        //Nous avons utilisé https://htmlcolorcodes.com/fr/
        Astre terre = new Astre (8, Color.rgb(72, 185, 234), 365.2569);
        //Creation de l'orbite de la Terre
        Orbite oTerre = new Orbite (740, 390, 217, 114, terre);
        
        //Creation representation orbite (une ellipse)
        Ellipse eTerre = new Ellipse();
        
        rOrbite orbTerre = new rOrbite(eTerre, oTerre);
        orbTerre.affichage();
        /**
        //Coordonnées centre de l'ellipse
        //Definition de la position selon les abscisses
        eTerre.setCenterX(oTerre.getPcentrex());
        //Definition de la position selon les ordonnées
        eTerre.setCenterY(oTerre.getPcentrey());
        
        //Modification de la longueur de l'ellipse
        eTerre.setRadiusX(oTerre.getLongueur());
        //Modification de la largeur de l'ellipse
        eTerre.setRadiusY(oTerre.getLargeur());
        
        //Gestion de la couleur du contour de l'ellipse
        eTerre.setStroke(Color.rgb(228, 225, 220));
        //Gestion de l'épaisseur du contour de l'ellipse
        eTerre.setStrokeWidth(1);
        //Modification de la couleur de l'ellipse
        //Nous avons utilisé la même couleur que celle de la scène
        eTerre.setFill(Color.rgb(1, 0, 41));
        **/
        
        //Creation representation Terre
        Circle rTerre = new Circle();
        /*¨
        //Definition du rayon
        rTerre.setRadius(terre.getRayon());
        //Modification de la couleur de la représentation
        //On la récupère directement sur l'objet Astre terre
        rTerre.setFill(terre.getCouleur());
        */
        //Creation de son label
        Label tTerre = new Label("Terre");
        /*
        //Positionnement du label
        tTerre.setLayoutX(5);
        tTerre.setLayoutY(80);
        //Modification de la police d'écriture ainsi que de la taille
        tTerre.setFont(Font.font("Calibri", 15.));
        //Coloration du texte de la même couleur que la représentation
        tTerre.setTextFill(terre.getCouleur());
        */
       
        URL urlTerre = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Terre.png");
        /*
        URLConnection connTerre = urlTerre.openConnection();
        InputStream isTerre = connTerre.getInputStream();
        Image iTerre = new Image(isTerre);
        rTerre.setFill(new ImagePattern(iTerre));
        */

        rAstre repTerre = new rAstre(rTerre, terre, tTerre, urlTerre, 5, 80);
        
        repTerre.affichagePlanete();
        repTerre.affichageTexte();
        repTerre.affichageTexture();



        //Animations
        //Nous avons décidé d'utiliser des animations directement implantées dans javaFX
        //Creation d'un chemin pour l'animation
        PathTransition transitionTerre = new PathTransition();
        //Definition de la durée de cette animation (durée d'une rotation complète)
        //La durée est ajustée par un coefficient (choisi arbitrairement) s'appliquant sur la periode de révolution ramenée en secondes
        transitionTerre.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*terre.getPrevolution()*3600*24));
        //Definition de ce qui va etre animé
        transitionTerre.setNode(rTerre);
        //Definition du chemin suivi
        transitionTerre.setPath(eTerre);
        //Gestion de l'infinité de l'animation
        transitionTerre.setCycleCount(PathTransition.INDEFINITE);
        //Obligation d'avoir une vitesse linéaire sur toute l'animation
        transitionTerre.setInterpolator(Interpolator.LINEAR);
        //Lancement de l'animation
        transitionTerre.play();
        
        
        
        
        
        //Creation orbite Mars
        Astre mars = new Astre (5, Color.rgb(217, 72, 8), 686.885);
        Orbite oMars = new Orbite (740, 390, 256, 135, venus);
        
        
        //Creation representation orbite
        Ellipse eMars = new Ellipse();
        
        rOrbite orbMars = new rOrbite(eMars, oMars);
        orbMars.affichage();
        /**
        //Coordonnées centre
        eMars.setCenterX(oMars.getPcentrex());
        eMars.setCenterY(oMars.getPcentrey());
        //Longueur et largeur
        eMars.setRadiusX(oMars.getLongueur());
        eMars.setRadiusY(oMars.getLargeur());
        //Couleur
        eMars.setStroke(Color.rgb(228, 225, 220));
        eMars.setStrokeWidth(1);
        eMars.setFill(Color.rgb(1, 0, 41));
        **/
        
        //Creation representation Venus
        Circle rMars = new Circle();
        /*
        rMars.setRadius(mars.getRayon());
        rMars.setFill(mars.getCouleur());
        */
        //Creation de son label
        Label tMars = new Label("Mars");
        /*
        tMars.setLayoutX(5);
        tMars.setLayoutY(105);
        tMars.setFont(Font.font("Calibri", 15.));
        tMars.setTextFill(mars.getCouleur());
        */

        URL urlMars = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Mars.png");
        /*
        URLConnection connMars = urlMars.openConnection();
        InputStream isMars = connMars.getInputStream();
        Image iMars = new Image(isMars);
        rMars.setFill(new ImagePattern(iMars));
        */
        

        rAstre repMars = new rAstre(rMars, mars, tMars, urlMars, 5, 105);
        
        repMars.affichagePlanete();
        repMars.affichageTexte();
        repMars.affichageTexture();


        //Animations
        PathTransition transitionMars = new PathTransition();
        transitionMars.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*mars.getPrevolution()*3600*24));
        transitionMars.setNode(rMars);
        transitionMars.setPath(eMars);
        transitionMars.setCycleCount(PathTransition.INDEFINITE);
        transitionMars.setInterpolator(Interpolator.LINEAR);
        transitionMars.play();
        
        

        


        //Creation orbite Jupiter
        Astre jupiter = new Astre (25, Color.rgb(202, 158, 141), 4332.01);
        Orbite oJupiter = new Orbite (740, 390, 311, 164, jupiter);
        
        //Creation representation orbite
        Ellipse eJupiter = new Ellipse();
        
        rOrbite orbJupiter = new rOrbite(eJupiter, oJupiter);
        orbJupiter.affichage();
        
        /**
        //Coordonnées centre
        eJupiter.setCenterX(oJupiter.getPcentrex());
        eJupiter.setCenterY(oJupiter.getPcentrey());
        //Longueur et largeur
        eJupiter.setRadiusX(oJupiter.getLongueur());
        eJupiter.setRadiusY(oJupiter.getLargeur());
        //Couleur
        eJupiter.setStroke(Color.rgb(228, 225, 220));
        eJupiter.setStrokeWidth(1);
        eJupiter.setFill(Color.rgb(1, 0, 41));
        **/
        
        //Creation representation Jupiter
        Circle rJupiter = new Circle();
        /*
        rJupiter.setRadius(jupiter.getRayon());
        rJupiter.setFill(jupiter.getCouleur());
        */
        //Creation de son label
        Label tJupiter = new Label("Jupiter");
        /*
        tJupiter.setLayoutX(5);
        tJupiter.setLayoutY(130);
        tJupiter.setFont(Font.font("Calibri", 15.));
        tJupiter.setTextFill(jupiter.getCouleur());
        */

        URL urlJupiter = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Jupiter.png");
        /*
        URLConnection connJupiter = urlJupiter.openConnection();
        InputStream isJupiter = connJupiter.getInputStream();
        Image iJupiter = new Image(isJupiter);
        rJupiter.setFill(new ImagePattern(iJupiter));
        */

        rAstre repJupiter = new rAstre(rJupiter, jupiter, tJupiter, urlJupiter, 5, 130);
        
        repJupiter.affichagePlanete();
        repJupiter.affichageTexte();
        repJupiter.affichageTexture();
        
        //Animation Jupiter
        PathTransition transitionJupiter = new PathTransition();
        transitionJupiter.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*jupiter.getPrevolution()*3600*24));
        transitionJupiter.setNode(rJupiter);
        transitionJupiter.setPath(eJupiter);
        transitionJupiter.setCycleCount(PathTransition.INDEFINITE);
        transitionJupiter.setInterpolator(Interpolator.LINEAR);
        transitionJupiter.play();



        //Creation orbite Saturne
        Astre saturne = new Astre (35, Color.rgb(159, 193, 133), 10754);
        Orbite oSaturne = new Orbite (740, 390, 427, 224, saturne);
        
        //Creation representation orbite
        Ellipse eSaturne = new Ellipse();
        
        rOrbite orbSaturne = new rOrbite(eSaturne, oSaturne);
        orbSaturne.affichage();
        /**
        //Coordonnées centre
        eSaturne.setCenterX(oSaturne.getPcentrex());
        eSaturne.setCenterY(oSaturne.getPcentrey());
        //Longueur et largeur
        eSaturne.setRadiusX(oSaturne.getLongueur());
        eSaturne.setRadiusY(oSaturne.getLargeur());
        //Couleur
        eSaturne.setStroke(Color.rgb(228, 225, 220));
        eSaturne.setStrokeWidth(1);
        eSaturne.setFill(Color.rgb(1, 0, 41));
        **/
        
        //Creation representation Mercure
        Circle rSaturne = new Circle();
        /*
        rSaturne.setRadius(saturne.getRayon());
        rSaturne.setFill(saturne.getCouleur());
        */
        //Creation de son label
        Label tSaturne = new Label("Saturne");
        /*
        tSaturne.setLayoutX(5);
        tSaturne.setLayoutY(155);
        tSaturne.setFont(Font.font("Calibri", 15.));
        tSaturne.setTextFill(saturne.getCouleur());
        */

        URL urlSaturne = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Saturne.png");
        /*
        URLConnection connSaturne = urlSaturne.openConnection();
        InputStream isSaturne = connSaturne.getInputStream();
        Image iSaturne = new Image(isSaturne);
        rSaturne.setFill(new ImagePattern(iSaturne));
        */

        rAstre repSaturne = new rAstre(rSaturne, saturne, tSaturne, urlSaturne, 5, 155);
        
        repSaturne.affichagePlanete();
        repSaturne.affichageTexte();
        repSaturne.affichageTexture();
        
        //Animation Saturne
        PathTransition transitionSaturne = new PathTransition();
        transitionSaturne.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*saturne.getPrevolution()*3600*24));
        transitionSaturne.setNode(rSaturne);
        transitionSaturne.setPath(eSaturne);
        transitionSaturne.setCycleCount(PathTransition.INDEFINITE);
        transitionSaturne.setInterpolator(Interpolator.LINEAR);
        transitionSaturne.play();


        //Creation orbite Uranus
        Astre uranus = new Astre (12, Color.rgb(140, 218, 222), 30698);
        Orbite oUranus = new Orbite (740, 390, 559, 294, uranus);
        
        //Creation representation orbite
        Ellipse eUranus = new Ellipse();
        
        rOrbite orbUranus = new rOrbite(eUranus, oUranus);
        orbUranus.affichage();
        /**
        //Coordonnées centre
        eUranus.setCenterX(oUranus.getPcentrex());
        eUranus.setCenterY(oUranus.getPcentrey());
        //Longueur et largeur
        eUranus.setRadiusX(oUranus.getLongueur());
        eUranus.setRadiusY(oUranus.getLargeur());
        //Couleur
        eUranus.setStroke(Color.rgb(228, 225, 220));
        eUranus.setStrokeWidth(1);
        eUranus.setFill(Color.rgb(1, 0, 41));
        **/
        
        //Creation representation Mercure
        Circle rUranus = new Circle();
        /*
        rUranus.setRadius(uranus.getRayon());
        rUranus.setFill(uranus.getCouleur());
        */
        //Creation de son label
        Label tUranus = new Label("Uranus");
        /*tUranus.setLayoutX(5);
        tUranus.setLayoutY(180);
        tUranus.setFont(Font.font("Calibri", 15.));
        tUranus.setTextFill(uranus.getCouleur());
        */

        URL urlUranus = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Uranus.png");
        /*
        URLConnection connUranus = urlUranus.openConnection();
        InputStream isUranus = connUranus.getInputStream();
        Image iUranus = new Image(isUranus);
        rUranus.setFill(new ImagePattern(iUranus));
        */

        rAstre repUranus = new rAstre(rUranus, uranus, tUranus, urlUranus, 5, 180);
        
        repUranus.affichagePlanete();
        repUranus.affichageTexte();
        repUranus.affichageTexture();
        
        //Animation Uranus
        PathTransition transitionUranus = new PathTransition();
        transitionUranus.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*uranus.getPrevolution()*3600*24));
        transitionUranus.setNode(rUranus);
        transitionUranus.setPath(eUranus);
        transitionUranus.setCycleCount(PathTransition.INDEFINITE);
        transitionUranus.setInterpolator(Interpolator.LINEAR);
        transitionUranus.play();



        //Creation orbite Neptune
        Astre neptune = new Astre (11, Color.rgb(47, 100, 223), 60216.8);
        Orbite oNeptune = new Orbite (740, 390, 644, 339, neptune);
        
        //Creation representation orbite
        Ellipse eNeptune = new Ellipse();
        
        rOrbite orbNeptune = new rOrbite(eNeptune, oNeptune);
        orbNeptune.affichage();
        /**
        //Coordonnées centre
        eNeptune.setCenterX(oNeptune.getPcentrex());
        eNeptune.setCenterY(oNeptune.getPcentrey());
        //Longueur et largeur
        eNeptune.setRadiusX(oNeptune.getLongueur());
        eNeptune.setRadiusY(oNeptune.getLargeur());
        //Couleur
        eNeptune.setStroke(Color.rgb(228, 225, 220));
        eNeptune.setStrokeWidth(1);
        eNeptune.setFill(Color.rgb(1, 0, 41));
        **/
        
        //Creation representation Mercure
        Circle rNeptune = new Circle();
        /*
        rNeptune.setRadius(neptune.getRayon());
        rNeptune.setFill(neptune.getCouleur());
        */
        //Creation de son label
        Label tNeptune = new Label("Neptune");
        /*
        tNeptune.setLayoutX(5);
        tNeptune.setLayoutY(205);
        tNeptune.setFont(Font.font("Calibri", 15.));
        tNeptune.setTextFill(neptune.getCouleur());
        */

        URL urlNeptune = new URL("https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Neptune.png");
        /*URLConnection connNeptune = urlNeptune.openConnection();
        InputStream isNeptune = connNeptune.getInputStream();
        Image iNeptune = new Image(isNeptune);
        rNeptune.setFill(new ImagePattern(iNeptune));
        */
        

        rAstre repNeptune = new rAstre(rNeptune, neptune, tNeptune, urlNeptune, 5, 205);
        
        repNeptune.affichagePlanete();
        repNeptune.affichageTexte();
        repNeptune.affichageTexture();


        //Animation Neptune
        PathTransition transitionNeptune = new PathTransition();
        transitionNeptune.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*neptune.getPrevolution()*3600*24));
        transitionNeptune.setNode(rNeptune);
        transitionNeptune.setPath(eNeptune);
        transitionNeptune.setCycleCount(PathTransition.INDEFINITE);
        transitionNeptune.setInterpolator(Interpolator.LINEAR);
        transitionNeptune.play();

        

        //Creation du bouton play/pause
        ToggleButton BoutonPause = new ToggleButton("Play/Pause");
        //Positionnement
        BoutonPause.setLayoutX(1397);
        BoutonPause.setLayoutY(5);
        
        //Action lors du click sur bouton
        BoutonPause.setOnAction((ActionEvent event) -> {
            //Si le bouton pause est selectionné on met en pause toutes les animations
            if(BoutonPause.isSelected()){
                transitionMercure.pause();
                transitionVenus.pause();
                transitionTerre.pause();
                transitionMars.pause();
                transitionJupiter.pause();
                transitionSaturne.pause();
                transitionUranus.pause();
                transitionNeptune.pause();
            }
            //Sinon toutes les animations sont lancées
            else{
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

        //Creation Slider Vitesse
        Slider sliderVitesse = new Slider();
        //Definition min et max (de x1 à x5)
        sliderVitesse.setMin(1);
        sliderVitesse.setMax(5);
        //Valeur au lancement 1
        sliderVitesse.setValue(1);
        //Positionnement
        sliderVitesse.setLayoutX(1300);
        sliderVitesse.setLayoutY(740);
        //Label associé
        Label tSlider = new Label("Vitesse");
        //Positionnement
        tSlider.setLayoutX(1345);
        tSlider.setLayoutY(720);
        //Modification de la police et de la taille
        tSlider.setFont(Font.font("Calibri", 17.));
        //Modification de la couleur
        tSlider.setTextFill(Color.WHITE);
        //Ajout de l'échelle sur le slider
        sliderVitesse.setShowTickLabels(true);
        //Incrémentation de 1
        sliderVitesse.setBlockIncrement(1);
        //Visualiser les sous graduations
        sliderVitesse.setShowTickMarks(true);


        //Gestion du Slider vitesse
        //Recuperation des valeurs et adpataion
        sliderVitesse.valueProperty().addListener(
            (ObservableValue<? extends Number> obsVal, Number oldVal, Number newVal) -> {
                //Arret des animations pour en relancer de nouvelles avec de nouvelles durées
                transitionMercure.stop();
                transitionVenus.stop();
                transitionTerre.stop();
                transitionMars.stop();
                transitionJupiter.stop();
                transitionSaturne.stop();
                transitionUranus.stop();
                transitionNeptune.stop();
                //Nouvelle durée de l'animation en divisant par la valeur récupérée
                //On récupère cette nouvelle valeur avec newVal qui est un number
                //Nous convertissons donc cette valeur en double
                transitionMercure.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*mercure.getPrevolution()*3600*24/newVal.doubleValue()));
                transitionVenus.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*venus.getPrevolution()*3600*24/newVal.doubleValue()));
                transitionTerre.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*terre.getPrevolution()*3600*24/newVal.doubleValue()));
                transitionMars.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*mars.getPrevolution()*3600*24/newVal.doubleValue()));
                transitionJupiter.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*jupiter.getPrevolution()*3600*24/newVal.doubleValue()));
                transitionSaturne.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*saturne.getPrevolution()*3600*24/newVal.doubleValue()));
                transitionUranus.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*uranus.getPrevolution()*3600*24/newVal.doubleValue()));
                transitionNeptune.setDuration(Duration.seconds(5.77*Math.pow(10, -7)*neptune.getPrevolution()*3600*24/newVal.doubleValue()));
                //On relance l'ensemble des animations
                transitionMercure.play();
                transitionVenus.play();
                transitionTerre.play();
                transitionMars.play();
                transitionJupiter.play();
                transitionSaturne.play();
                transitionUranus.play();
                transitionNeptune.play();
            }
        );
        
        
        //Gestion des checkbox
        //Creation d'une checkbox
        CheckBox cbSoleil = new CheckBox();
        //Definition du positionnement
        cbSoleil.setLayoutX(62);
        cbSoleil.setLayoutY(7);
        //Definir initialement la case comme cochée
        cbSoleil.setSelected(true);
        //Gestion de l'action lorsqu'elle est cochée/décochée
        cbSoleil.setOnAction((ActionEvent event) -> {
            //Si la checkbox est selectionnée on affiche la planete
            if(cbSoleil.isSelected()){
                rSoleil.setVisible(true);
            }
            //Si la checkbox est déselectionnée on n'affiche plus la planete
            else{
                rSoleil.setVisible(false);
            }
        });
        

        //Checkbox Mercure
        CheckBox cbMercure = new CheckBox();
        //Positionnement
        cbMercure.setLayoutX(62);
        cbMercure.setLayoutY(32);
        //Selectionnée
        cbMercure.setSelected(true);
        cbMercure.setOnAction((ActionEvent event) -> {
            //Gestion affichage orbite + Planète
            if(cbMercure.isSelected()){
                eMercure.setVisible(true);
                rMercure.setVisible(true);
            }
            else{
                eMercure.setVisible(false);
                rMercure.setVisible(false);
            }
        });


        //Checkbox Venus
        CheckBox cbVenus = new CheckBox();
        cbVenus.setLayoutX(62);
        cbVenus.setLayoutY(57);
        cbVenus.setSelected(true);
        cbVenus.setOnAction((ActionEvent event) -> {
            if(cbVenus.isSelected()){
                eVenus.setVisible(true);
                rVenus.setVisible(true);
            }
            else{
                eVenus.setVisible(false);
                rVenus.setVisible(false);
            }
        });

        //Checkbox Terre
        CheckBox cbTerre = new CheckBox();
        cbTerre.setLayoutX(62);
        cbTerre.setLayoutY(82);
        cbTerre.setSelected(true);
        cbTerre.setOnAction((ActionEvent event) -> {
            if(cbTerre.isSelected()){
                eTerre.setVisible(true);
                rTerre.setVisible(true);
            }
            else{
                eTerre.setVisible(false);
                rTerre.setVisible(false);
            }
        });


        //Checkbox Mars
        CheckBox cbMars = new CheckBox();
        cbMars.setLayoutX(62);
        cbMars.setLayoutY(107);
        cbMars.setSelected(true);
        cbMars.setOnAction((ActionEvent event) -> {
            if(cbMars.isSelected()){
                eMars.setVisible(true);
                rMars.setVisible(true);
            }
            else{
                eMars.setVisible(false);
                rMars.setVisible(false);
            }
        });



        //Checkbox Jupiter
        CheckBox cbJupiter = new CheckBox();
        cbJupiter.setLayoutX(62);
        cbJupiter.setLayoutY(132);
        cbJupiter.setSelected(true);
        cbJupiter.setOnAction((ActionEvent event) -> {
            if(cbJupiter.isSelected()){
                eJupiter.setVisible(true);
                rJupiter.setVisible(true);
            }
            else{
                eJupiter.setVisible(false);
                rJupiter.setVisible(false);
            }
        });


        //Checkbox Saturne
        CheckBox cbSaturne = new CheckBox();
        cbSaturne.setLayoutX(62);
        cbSaturne.setLayoutY(157);
        cbSaturne.setSelected(true);
        cbSaturne.setOnAction((ActionEvent event) -> {
            if(cbSaturne.isSelected()){
                eSaturne.setVisible(true);
                rSaturne.setVisible(true);
            }
            else{
                eSaturne.setVisible(false);
                rSaturne.setVisible(false);
            }
        });


        //Checkbox Uranus
        CheckBox cbUranus = new CheckBox();
        cbUranus.setLayoutX(62);
        cbUranus.setLayoutY(182);
        cbUranus.setSelected(true);
        cbUranus.setOnAction((ActionEvent event) -> {
            if(cbUranus.isSelected()){
                eUranus.setVisible(true);
                rUranus.setVisible(true);
            }
            else{
                eUranus.setVisible(false);
                rUranus.setVisible(false);
            }
        });


        //Checkbox Neptune
        CheckBox cbNeptune = new CheckBox();
        cbNeptune.setLayoutX(62);
        cbNeptune.setLayoutY(207);
        cbNeptune.setSelected(true);
        cbNeptune.setOnAction((ActionEvent event) -> {
            if(cbNeptune.isSelected()){
                eNeptune.setVisible(true);
                rNeptune.setVisible(true);
            }
            else{
                eNeptune.setVisible(false);
                rNeptune.setVisible(false);
            }
        });



        //Mise en relation avec la zone legende
        gtexte.getChildren().addAll(tSoleil, tMercure, tVenus, tTerre, tMars, tJupiter, tSaturne, tUranus, tNeptune);
        
        //Mise en relation des éléments créés avec la racine pour qu'ils soient affichés
        root.getChildren().addAll(eNeptune, eUranus, eSaturne, eJupiter, eMars, eTerre, eVenus, eMercure);
        root.getChildren().addAll(rSoleil, rMercure, rVenus, rTerre, rMars, rJupiter, rSaturne, rUranus, rNeptune);
        root.getChildren().addAll(cbSoleil, cbMercure, cbVenus, cbTerre, cbMars, cbJupiter, cbSaturne, cbUranus, cbNeptune);
        root.getChildren().addAll(tSlider, sliderVitesse, BoutonPause);

        //Affichage
        stage.show();
        
        //Permet de fermer l'application
        //Platform.exit();
        
    }

    public static void main(String[] args) {
        launch();
    }

}