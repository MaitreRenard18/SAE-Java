package fr.aftek.ihm;

import java.io.IOException;
import java.sql.SQLException;

import fr.aftek.data.ConnexionMySQL;
import fr.aftek.ihm.pages.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Classe principale de l'application des Jeux Olympiques.
 * Cette classe étend la classe Application de JavaFX.
 */
public class ApplicationJO extends Application{
    
    private Scene scene; // Scène principale de l'application
    private ConnexionMySQL connexion; // Connexion à la base de données MySQL
    private Stage stage; // Fenêtre principale de l'application

    /**
     * Point d'entrée de l'application.
     * 
     * @param stage La fenêtre principale de l'application
     * @throws Exception Si une erreur survient lors du lancement
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Connexion à la base de données
        this.connexion = new ConnexionMySQL();
        // Création de la scène principale avec la page de connexion
        BorderPane root = new PageConnexion(this);
        this.scene = new Scene(root, 900, 600);
        this.stage = stage;
        stage.setScene(scene);
        stage.setTitle("Jeux IUT'Olympiques"); // Titre de la fenêtre
        stage.setResizable(false); // Empêche le redimensionnement de la fenêtre
        stage.show(); // Affiche la fenêtre
        // Définit l'action à réaliser lors de la fermeture de la fenêtre
        stage.setOnCloseRequest((e)->System.exit(0));
    }

    /**
     * Retourne la connexion à la base de données.
     * 
     * @return ConnexionMySQL La connexion à la base de données
     */
    public ConnexionMySQL getConnexion() {
        return connexion;
    }
    
    /**
     * Affiche le menu principal de l'application.
     * 
     * @throws IOException Si une erreur d'entrée/sortie survient
     * @throws SQLException Si une erreur SQL survient
     */
    public void menu() throws IOException, SQLException {
        // Change la scène actuelle pour le menu principal
        stage.setScene(new Scene(new Menu(this), 900, 600));

        // Récupère le rôle de l'utilisateur connecté
        String role = connexion.getRole();
        if (role == "admin") {
            // Affiche un message si l'utilisateur est un administrateur
            System.out.println("Il faut afficher le bouton admin");
        }
    }

    /**
     * Méthode principale pour lancer l'application.
     * 
     * @param args Arguments de la ligne de commande
     */
    public static void main(String[] args) {
        launch(ApplicationJO.class);
    }
}
