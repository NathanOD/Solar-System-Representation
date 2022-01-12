package com.mycompany.syssolaire;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
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

                // Creation des groupes nécessaires
                // Creation de la racine
                Group root = new Group();
                // Creation des groupes complementaires
                SmartGroup groupePlanete = new SmartGroup();
                Group ginteraction = new Group();
                Group glegende = new Group();
                // Scene de taille 1480x780 pixels
                Scene scene = new Scene(root, 1480, 780, true);
                stage.setScene(scene);
                // Modification du nom
                stage.setTitle("Systeme Solaire");

                // Choix couleur scene
                scene.setFill(Color.rgb(1, 0, 41));

                // Creation d'une lumière de couleur blanche
                PointLight lumiere = new PointLight(Color.WHITE);
                // Positionnement
                lumiere.setLayoutX(740);
                lumiere.setLayoutY(390);

                // Creation soleil
                Astre soleil = new Astre(55, Color.rgb(255, 178, 1), 0, 0);

                // Creation representation Soleil
                Sphere rSoleil = new Sphere();
                // Positionnement
                rSoleil.setLayoutX(740);
                rSoleil.setLayoutY(390);
                // Creation de son label
                Label tSoleil = new Label("Soleil");
                // Creation de l'url afin d'obtenir la texture
                URL urlSoleil = new URL(
                                "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Soleil.jpg");
                CheckBox cbSoleil = new CheckBox();
                // Creation d'une représentation
                rAstre repSoleil = new rAstre(rSoleil, soleil, tSoleil, urlSoleil, 5, 5, cbSoleil, 62, 7,
                                new Ellipse());
                // Application des méthodes pour affichage
                repSoleil.affichagePlanete();
                repSoleil.affichageTexte();
                repSoleil.gestionCheckbox();

                // Gestion de l'apparence
                // Creation de la texture par image
                URLConnection ucSoleil = urlSoleil.openConnection();
                InputStream isSoleil = ucSoleil.getInputStream();
                Image iSoleil = new Image(isSoleil);
                PhongMaterial pSoleil = new PhongMaterial();
                pSoleil.setDiffuseMap(iSoleil);
                // Illumination du Soleil
                pSoleil.setSelfIlluminationMap(iSoleil);
                rSoleil.setMaterial(pSoleil);
                // Rotation afin d'obtenir la bonne orientation
                Rotate rotSoleil = new Rotate(90, Rotate.X_AXIS);
                rSoleil.getTransforms().add(rotSoleil);

                // Creation de Mercure et de son orbite
                Astre mercure = new Astre(3, Color.rgb(162, 158, 156), 87.969, 176);
                Orbite oMercure = new Orbite(740, 390, 126, 66, mercure);
                // Representation de l'orbite
                Ellipse eMercure = new Ellipse();
                rOrbite orbMercure = new rOrbite(eMercure, oMercure);
                orbMercure.affichage();

                // Representation planète
                Sphere rMercure = new Sphere();
                Label tMercure = new Label("Mercure");
                URL urlMercure = new URL(
                                "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Mercure.jpg");
                CheckBox cbMercure = new CheckBox();
                rAstre repMercure = new rAstre(rMercure, mercure, tMercure, urlMercure, 5, 30, cbMercure, 62, 32,
                                eMercure);
                repMercure.affichagePlanete();
                repMercure.affichageTexte();
                repMercure.affichageTexture();
                repMercure.gestionCheckbox();

                // Animation
                PathTransition transitionMercure = new PathTransition();
                RotateTransition rotationMercure = new RotateTransition();
                Animation animMercure = new Animation(transitionMercure, rotationMercure, mercure, rMercure, eMercure);
                animMercure.affAnim();
                animMercure.affRotation();

                // Creation Venus et son orbite
                Astre venus = new Astre(7, Color.rgb(142, 186, 195), 224.667, 243);
                Orbite oVenus = new Orbite(740, 390, 186, 98, venus);

                // Representation orbite
                Ellipse eVenus = new Ellipse();
                rOrbite orbVenus = new rOrbite(eVenus, oVenus);
                orbVenus.affichage();

                // Representation planete
                Sphere rVenus = new Sphere();
                Label tVenus = new Label("Venus");
                URL urlVenus = new URL(
                                "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Venus.jpg");
                CheckBox cbVenus = new CheckBox();
                rAstre repVenus = new rAstre(rVenus, venus, tVenus, urlVenus, 5, 55, cbVenus, 62, 57, eVenus);
                repVenus.affichagePlanete();
                repVenus.affichageTexte();
                repVenus.affichageTexture();
                repVenus.gestionCheckbox();

                // Animations
                PathTransition transitionVenus = new PathTransition();
                RotateTransition rotationVenus = new RotateTransition();
                Animation animVenus = new Animation(transitionVenus, rotationVenus, venus, rVenus, eVenus);
                animVenus.affAnim();
                animVenus.affRotation();

                // Creation Terre
                // Utilisation de la color.rgb qui donne une couleur à partir de la reference
                // rgb
                // Nous avons utilisé https://htmlcolorcodes.com/fr/
                Astre terre = new Astre(8, Color.rgb(72, 185, 234), 365.2569, 1);
                // Creation de l'orbite de la Terre
                Orbite oTerre = new Orbite(740, 390, 217, 114, terre);

                // Creation forme representant l'orbite (une ellipse)
                Ellipse eTerre = new Ellipse();
                // Creation de la représentation de l'orbite
                rOrbite orbTerre = new rOrbite(eTerre, oTerre);
                // Affichage
                orbTerre.affichage();

                // Creation de la sphère representant la Terre
                Sphere rTerre = new Sphere();
                // Creation de son label
                Label tTerre = new Label("Terre");
                // Creation de son URL afin d'obtenir la texture
                URL urlTerre = new URL(
                                "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Terre.jpg");
                // Creation de la checkbox
                CheckBox cbTerre = new CheckBox();
                // Creation de la représentation astrale
                rAstre repTerre = new rAstre(rTerre, terre, tTerre, urlTerre, 5, 80, cbTerre, 62, 82, eTerre);
                // Affichage de la planète
                repTerre.affichagePlanete();
                // Affichage du label associé
                repTerre.affichageTexte();
                // Association avec la texture
                repTerre.affichageTexture();
                // Affichage des checkbox
                repTerre.gestionCheckbox();

                // Animations
                // Nous avons décidé d'utiliser des animations directement implantées dans
                // javaFX
                // Creation d'un chemin pour l'animation
                PathTransition transitionTerre = new PathTransition();
                // Creation d'une rotation
                RotateTransition rotationTerre = new RotateTransition();
                // Creation de l'animation
                Animation animTerre = new Animation(transitionTerre, rotationTerre, terre, rTerre, eTerre);
                // Affichage de l'animation
                animTerre.affAnim();
                // Affichage de la rotation
                animTerre.affRotation();

                // Creation de Mars et de son orbite
                Astre mars = new Astre(5, Color.rgb(217, 72, 8), 686.885, 1.028);
                Orbite oMars = new Orbite(740, 390, 256, 135, venus);

                // Representation de l'orbite de Mars
                Ellipse eMars = new Ellipse();
                rOrbite orbMars = new rOrbite(eMars, oMars);
                orbMars.affichage();

                // Representation planete
                Sphere rMars = new Sphere();
                Label tMars = new Label("Mars");
                URL urlMars = new URL(
                                "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Mars.jpg");
                CheckBox cbMars = new CheckBox();
                rAstre repMars = new rAstre(rMars, mars, tMars, urlMars, 5, 105, cbMars, 62, 107, eMars);
                repMars.affichagePlanete();
                repMars.affichageTexte();
                repMars.affichageTexture();
                repMars.gestionCheckbox();

                // Animations
                PathTransition transitionMars = new PathTransition();
                RotateTransition rotationMars = new RotateTransition();
                Animation animMars = new Animation(transitionMars, rotationMars, mars, rMars, eMars);
                animMars.affAnim();
                animMars.affRotation();

                // Creation de Jupiter et de son orbite
                Astre jupiter = new Astre(25, Color.rgb(202, 158, 141), 4332.01, 0.42);
                Orbite oJupiter = new Orbite(740, 390, 311, 164, jupiter);

                // Representation orbite
                Ellipse eJupiter = new Ellipse();
                rOrbite orbJupiter = new rOrbite(eJupiter, oJupiter);
                orbJupiter.affichage();

                // Representation planete
                Sphere rJupiter = new Sphere();
                Label tJupiter = new Label("Jupiter");
                URL urlJupiter = new URL(
                                "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Jupiter.jpg");
                CheckBox cbJupiter = new CheckBox();
                rAstre repJupiter = new rAstre(rJupiter, jupiter, tJupiter, urlJupiter, 5, 130, cbJupiter, 62, 132,
                                eJupiter);
                repJupiter.affichagePlanete();
                repJupiter.affichageTexte();
                repJupiter.affichageTexture();
                repJupiter.gestionCheckbox();

                // Animation Jupiter
                PathTransition transitionJupiter = new PathTransition();
                RotateTransition rotationJupiter = new RotateTransition();
                Animation animJupiter = new Animation(transitionJupiter, rotationJupiter, jupiter, rJupiter, eJupiter);
                animJupiter.affAnim();
                animJupiter.affRotation();

                // Creation de Saturne et de son orbite
                Astre saturne = new Astre(20, Color.rgb(159, 193, 133), 10754, 0.44);
                Orbite oSaturne = new Orbite(740, 390, 427, 224, saturne);

                // Creation representation orbite
                Ellipse eSaturne = new Ellipse();
                rOrbite orbSaturne = new rOrbite(eSaturne, oSaturne);
                orbSaturne.affichage();

                // Representation planete
                Sphere rSaturne = new Sphere();
                Label tSaturne = new Label("Saturne");
                URL urlSaturne = new URL(
                                "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Saturne.jpg");
                CheckBox cbSaturne = new CheckBox();
                rAstre repSaturne = new rAstre(rSaturne, saturne, tSaturne, urlSaturne, 5, 155, cbSaturne, 62, 157,
                                eSaturne);
                repSaturne.affichagePlanete();
                repSaturne.affichageTexte();
                repSaturne.affichageTexture();
                repSaturne.gestionCheckbox();

                // Animation Saturne
                PathTransition transitionSaturne = new PathTransition();
                RotateTransition rotationSaturne = new RotateTransition();
                Animation animSaturne = new Animation(transitionSaturne, rotationSaturne, saturne, rSaturne, eSaturne);
                animSaturne.affAnim();
                animSaturne.affRotation();

                // Creation d'Uranus et de son orbite
                Astre uranus = new Astre(12, Color.rgb(140, 218, 222), 30698, 0.71);
                Orbite oUranus = new Orbite(740, 390, 559, 294, uranus);

                // Representation orbite
                Ellipse eUranus = new Ellipse();
                rOrbite orbUranus = new rOrbite(eUranus, oUranus);
                orbUranus.affichage();

                // Representation planète
                Sphere rUranus = new Sphere();
                Label tUranus = new Label("Uranus");
                URL urlUranus = new URL(
                                "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Uranus.jpg");
                CheckBox cbUranus = new CheckBox();
                rAstre repUranus = new rAstre(rUranus, uranus, tUranus, urlUranus, 5, 180, cbUranus, 62, 182, eUranus);
                repUranus.affichagePlanete();
                repUranus.affichageTexte();
                repUranus.affichageTexture();
                repUranus.gestionCheckbox();

                // Animation Uranus
                PathTransition transitionUranus = new PathTransition();
                RotateTransition rotationUranus = new RotateTransition();
                Animation animUranus = new Animation(transitionUranus, rotationUranus, uranus, rUranus, eUranus);
                animUranus.affAnim();
                animUranus.affRotation();

                // Creation de Neptune et de son orbite
                Astre neptune = new Astre(11, Color.rgb(47, 100, 223), 60216.8, 0.67);
                Orbite oNeptune = new Orbite(740, 390, 644, 339, neptune);

                // Representation orbite
                Ellipse eNeptune = new Ellipse();
                rOrbite orbNeptune = new rOrbite(eNeptune, oNeptune);
                orbNeptune.affichage();

                // Representation planete
                Sphere rNeptune = new Sphere();
                Label tNeptune = new Label("Neptune");
                URL urlNeptune = new URL(
                                "https://raw.githubusercontent.com/NathanOD/SystemeSolaire/main/sysolaire/sysolaire/Neptune.jpg");
                CheckBox cbNeptune = new CheckBox();
                rAstre repNeptune = new rAstre(rNeptune, neptune, tNeptune, urlNeptune, 5, 205, cbNeptune, 62, 207,
                                eNeptune);
                repNeptune.affichagePlanete();
                repNeptune.affichageTexte();
                repNeptune.affichageTexture();
                repNeptune.gestionCheckbox();

                // Animation Neptune
                PathTransition transitionNeptune = new PathTransition();
                RotateTransition rotationNeptune = new RotateTransition();
                Animation animNeptune = new Animation(transitionNeptune, rotationNeptune, neptune, rNeptune, eNeptune);
                animNeptune.affAnim();
                animNeptune.affRotation();

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
                                rotationMercure.pause();
                                rotationVenus.pause();
                                rotationTerre.pause();
                                rotationMars.pause();
                                rotationJupiter.pause();
                                rotationSaturne.pause();
                                rotationUranus.pause();
                                rotationNeptune.pause();
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
                                rotationMercure.play();
                                rotationVenus.play();
                                rotationTerre.play();
                                rotationMars.play();
                                rotationJupiter.play();
                                rotationSaturne.play();
                                rotationUranus.play();
                                rotationNeptune.play();
                        }
                });

                // Creation Slider Vitesse
                Slider sliderVitesse = new Slider();
                // Definition min et max (de x1 à x5)
                sliderVitesse.setMin(1);
                sliderVitesse.setMax(10);
                // Valeur au lancement 1
                sliderVitesse.setValue(1);
                // Positionnement
                sliderVitesse.setLayoutX(1300);
                sliderVitesse.setLayoutY(740);

                // Label associé
                Label tSlider = new Label("Vitesse");
                // Positionnement du label
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
                                                        Math.pow(10, -5) * mercure.getPrevolution() * 3600 * 24
                                                                        / newVal.doubleValue()));
                                        transitionVenus.setDuration(Duration.seconds(
                                                        Math.pow(10, -5) * venus.getPrevolution() * 3600 * 24
                                                                        / newVal.doubleValue()));
                                        transitionTerre.setDuration(Duration.seconds(
                                                        Math.pow(10, -5) * terre.getPrevolution() * 3600 * 24
                                                                        / newVal.doubleValue()));
                                        transitionMars.setDuration(Duration.seconds(
                                                        Math.pow(10, -5) * mars.getPrevolution() * 3600 * 24
                                                                        / newVal.doubleValue()));
                                        transitionJupiter.setDuration(Duration.seconds(
                                                        Math.pow(10, -5) * jupiter.getPrevolution() * 3600 * 24
                                                                        / newVal.doubleValue()));
                                        transitionSaturne.setDuration(Duration.seconds(
                                                        Math.pow(10, -5) * saturne.getPrevolution() * 3600 * 24
                                                                        / newVal.doubleValue()));
                                        transitionUranus.setDuration(Duration.seconds(
                                                        Math.pow(10, -5) * uranus.getPrevolution() * 3600 * 24
                                                                        / newVal.doubleValue()));
                                        transitionNeptune.setDuration(Duration.seconds(
                                                        Math.pow(10, -5) * neptune.getPrevolution() * 3600 * 24
                                                                        / newVal.doubleValue()));
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

                // Partie 3D ############################################################

                // Creation de la camera
                Camera camera = new PerspectiveCamera();
                scene.setCamera(camera);

                // Definition du centre de la caméra
                groupePlanete.translateXProperty().set(1480 / 2);
                groupePlanete.translateYProperty().set(780 / 2);
                groupePlanete.translateZProperty().set(0);
                groupePlanete.setLayoutX(-740);
                groupePlanete.setLayoutY(-390);

                // Gestion su mouvement de la caméra
                stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                        // Lorsque une touche est appuyée alors le groupe planète se délace selon un
                        // incrément choisi
                        // Donnant ainsi l'impression que la caméra se déplace
                        switch (event.getCode()) {
                                case S:
                                        groupePlanete.translateZProperty().set(groupePlanete.getTranslateZ() + 100);
                                        break;
                                case W:
                                        groupePlanete.translateZProperty().set(groupePlanete.getTranslateZ() - 100);
                                        break;
                                case A:
                                        groupePlanete.translateXProperty().set(groupePlanete.getTranslateX() + 20);
                                        break;
                                case D:
                                        groupePlanete.translateXProperty().set(groupePlanete.getTranslateX() - 20);
                                        break;
                                case Z:
                                        groupePlanete.rotateByX(10);
                                        break;
                                case X:
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

                // Mise en relation des éléments créés avec le groupe auxquels ils correspondent
                groupePlanete.getChildren().add(lumiere);
                groupePlanete.getChildren().addAll(eNeptune, eUranus, eSaturne, eJupiter, eMars, eTerre, eVenus,
                                eMercure);
                groupePlanete.getChildren().addAll(rMercure, rVenus, rTerre, rMars, rJupiter, rSaturne, rUranus,
                                rNeptune);
                groupePlanete.getChildren().add(rSoleil);
                glegende.getChildren().addAll(tSoleil, tMercure, tVenus, tTerre, tMars, tJupiter, tSaturne, tUranus,
                                tNeptune);
                glegende.getChildren().addAll(cbSoleil, cbMercure, cbVenus, cbTerre, cbMars, cbJupiter, cbSaturne,
                                cbUranus,
                                cbNeptune);
                ginteraction.getChildren().addAll(tSlider, sliderVitesse, BoutonPause);

                // Association des groupes à la racine afin qu'ils soient affichés
                root.getChildren().add(ginteraction);
                root.getChildren().add(groupePlanete);
                root.getChildren().add(glegende);

                // Affichage
                stage.show();

        }

        public static void main(String[] args) {
                launch();
        }

}