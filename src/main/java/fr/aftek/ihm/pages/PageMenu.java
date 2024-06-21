package fr.aftek.ihm.pages;

import java.io.IOException;

import fr.aftek.ihm.ApplicationJO;
import fr.aftek.ihm.controleurs.ControleurMenu;
import javafx.fxml.FXMLLoader;

/**
 * Classe Menu qui étend BorderPane.
 * Affiche le menu principal de l'application.
 */
public class PageMenu extends Page {
    /**
     * Constructeur de la classe Menu.
     * 
     * @param application L'application principale pour accéder aux fonctionnalités globales.
     * @throws IOException Si une erreur survient lors du chargement du fichier FXML.
     */
    public PageMenu(ApplicationJO application, boolean afficherAdm) throws IOException {
        // Charge le fichier FXML pour le menu et initialise le contrôleur
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PageBienvenue.fxml"));
        loader.setController(new ControleurMenu(application, afficherAdm));
        loader.setRoot(this);
        loader.load();
    }
}